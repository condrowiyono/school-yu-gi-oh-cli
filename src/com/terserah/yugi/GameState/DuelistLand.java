/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Duelist;
import com.terserah.yugi.Entities.Player;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;
import com.terserah.yugi.Main.GamePanel;
import java.util.*;
/**
 *
 * @author condro
 */
public class DuelistLand extends GameState {
    //Array of Duelist
    public static ArrayList<Duelist> arrDuelist = new ArrayList<Duelist>();
    
    //Current Duelist for DuelState
    private static Duelist curDuelist ;
    
    //Array Map
    private static String[][] arrMap;
    
    public DuelistLand(GameStateManager gsm){
        super(gsm);
    }
    
    public static Duelist getCurDuelist() {
        return DuelistLand.curDuelist;
    }
    public void makeMap() {
    arrMap =  new String[][] {
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
            {" ", " ", " ", " " , " ", " ", " ", " ", " ", " " },
        } ; 
        //menentukan lokasi duelist
        for (int a=0;a<DuelistLand.arrDuelist.size();a++) {
            int x = DuelistLand.arrDuelist.get(a).getPosisi().getX();
            int y = DuelistLand.arrDuelist.get(a).getPosisi().getY();
            arrMap[x-1][y-1] = "D";
        }
        
        //shop
        arrMap[2][2] = "S";
        arrMap[9][8] = "S";
    }  
    public void printMap() {
        makeMap();
        //print maps
        System.out.println("------------");
        for (int i=1;i<=10;i++) {
            System.out.print("|");
            for (int j=1;j<=10;j++) {
                int x = GamePanel.PemainUtama.getPosisi().getX();
                int y = GamePanel.PemainUtama.getPosisi().getY();
                if ((i==x)&&(j==y))
                    System.out.print("0");
                else
                    System.out.print(arrMap[i-1][j-1]);
            }
            System.out.print("|\n");
                
        }
        System.out.println("------------");
    }

    @Override
    public void draw() {
        printMap();
        handleInput();
        
    }

    @Override
    public void handleInput() {
        if (meetShop()) {
            gsm.setState(GameStateManager.SHOP);
        } else if (meetDuelist()) {
            System.out.println(DuelistLand.getCurDuelist().getDeck().getSize());
            Duelist opp = (Duelist) new Duelist(
                            DuelistLand.getCurDuelist().getName(),
                            DuelistLand.getCurDuelist().getPosisi().getX(),
                            DuelistLand.getCurDuelist().getPosisi().getY(),
                            DuelistLand.getCurDuelist().getRank(),
                            DuelistLand.getCurDuelist().getDeck());
            Player act = GamePanel.PemainUtama;
            act.setLP(2000);
            System.out.println(GamePanel.PemainUtama.getDeck().getSize());
            DuelState.ingame = new Board(act, opp);
            gsm.setState(GameStateManager.DUEL);
        } else
        {
            System.out.println("Nama = " + GamePanel.getMainPlayer().getName());
            System.out.println("Posisi = " + GamePanel.getMainPlayer().getPosisi().getX() + "," + GamePanel.getMainPlayer().getPosisi().getY());
            System.out.println("Command");
            System.out.println("1 w move up");
            System.out.println("2 s move down");
            System.out.println("3 a move left");
            System.out.println("4 d move right");
            System.out.println("--------------");
            System.out.println("0 back");
            System.out.print("Pilihan : ");
            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            switch (opt) {
                case "0" :
                case "back" :
                    gsm.setState(GameStateManager.MENU);
                    break;
                case "1":
                case "w":
                case "move up" :
                    if (GamePanel.getMainPlayer().getPosisi().getX()>1)
                        GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX()-1,GamePanel.getMainPlayer().getPosisi().getY());
                    break;
                case "2":
                case "s":
                case "move down" :
                    if (GamePanel.getMainPlayer().getPosisi().getX()<10)
                        GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX()+1,GamePanel.getMainPlayer().getPosisi().getY());
                    break;
                case "3":
                case "a":
                case "move left" :
                    if (GamePanel.getMainPlayer().getPosisi().getY()>1)
                        GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()-1);
                    break;
                case "4":
                case "d":
                case "move right" :
                    if (GamePanel.getMainPlayer().getPosisi().getY()<10)
                        GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()+1);
                    break;             
                default:
                    break;
            }
        }
    }
    
    public boolean meetShop(){
        int x = GamePanel.PemainUtama.getPosisi().getX();
        int y = GamePanel.PemainUtama.getPosisi().getY();
        return ("S".equals(this.arrMap[x-1][y-1]));             
    }
    public boolean meetDuelist() {
        int x = GamePanel.PemainUtama.getPosisi().getX();
        int y = GamePanel.PemainUtama.getPosisi().getY();
        DuelistLand.curDuelist = findByPosition(x,y);
        return ("D".equals(this.arrMap[x-1][y-1]));    
    }
    
    public Duelist findByPosition(int x,int y) {
        boolean flag = false;
        int idx =0 ;
        for (int i=0; i<DuelistLand.arrDuelist.size();i++) {
            if ((x==DuelistLand.arrDuelist.get(i).getPosisi().getX()) &&
                (y==DuelistLand.arrDuelist.get(i).getPosisi().getY())) {
                flag = true;
                idx = i;
            }
        }
        if (flag) 
            return DuelistLand.arrDuelist.get(idx) ;
        else 
            return null;
    }
}
