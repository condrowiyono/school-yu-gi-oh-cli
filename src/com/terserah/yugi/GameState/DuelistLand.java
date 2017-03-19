/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Duelist;
import com.terserah.yugi.Entities.Point;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;
import com.terserah.yugi.Main.GamePanel;
/**
 *
 * @author condro
 */
public class DuelistLand extends GameState {
    
    public static Duelist[] arrDuelist;
    
    
    public DuelistLand(GameStateManager gsm){
        super(gsm);
        DuelistLand.arrDuelist = new Duelist[] { 
            new Duelist("Sukarti",2,2,"Elite Duelist"),
            new Duelist("Sukarto",4,5,"Elite Duelist"),  
            new Duelist("Sukarto",7,7,"Tinggi 3")
        };
    }
    
    public void printMap() {
        int i,j ;
        for (i=1;i<=10;i++) {
            for (j=1;j<=10;j++) {
                if ((GamePanel.getMainPlayer().getPosisi().getX()==i) && 
                    (GamePanel.getMainPlayer().getPosisi().getY()==j))
                        System.out.print("o");
                else
                    System.out.print("#");
            }
            System.out.println();
                
        }
    }

    @Override
    public void draw() {
        printMap();
        handleInput();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void handleInput() {
        //To change body of generated methods, choose Tools | Templates.
        if (meetShop()) {
            gsm.setState(GameStateManager.SHOP);
        } else if (meetDuelist()) {
            gsm.setState(GameStateManager.DUEL);
        } else
        {
            System.out.println("Nama = " + GamePanel.getMainPlayer().getName());
            System.out.println("Posisi = " + GamePanel.getMainPlayer().getPosisi().getX() + "," + GamePanel.getMainPlayer().getPosisi().getY());
            System.out.println("Jumlah Duelist : " + DuelistLand.arrDuelist.length);
            System.out.println("Jumlah Toko : 1 ( 3,3) ");
            System.out.println("Command");
            System.out.println("1 w move up");
            System.out.println("2 s move down");
            System.out.println("3 a move left");
            System.out.println("4 d move right");
            System.out.println("==============");
            System.out.println("0 back");
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
        return (( GamePanel.getMainPlayer().getPosisi().getX()==3) && ( GamePanel.getMainPlayer().getPosisi().getY()==3));
    }
    public boolean meetDuelist() {
        return ( (samakah(GamePanel.getMainPlayer().getPosisi(),DuelistLand.arrDuelist[0].getPosisi())) ||
                 (samakah(GamePanel.getMainPlayer().getPosisi(),DuelistLand.arrDuelist[1].getPosisi())) ||
                 (samakah(GamePanel.getMainPlayer().getPosisi(),DuelistLand.arrDuelist[2].getPosisi()))
               );
    }
    
    public boolean samakah(Point x, Point y) {
        return ((x.getX() == y.getX()) && (x.getY() ==y.getY()));
    }
    
}
