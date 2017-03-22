/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class DuelState extends GameState {
    
    //turn
    private static final int PLAYERTURN = 0;
    private static final int DUELISTTURN = 1;
    //phase
    
    //
    private static int TURNCOUNT = 0;
    private static boolean FINISHED = false;
    
    //LIVE POINT
    private int PLAYERLP = 2000;
    private int DUELISTLP = 2000;
    
    public DuelState(GameStateManager gsm) {
        super(gsm);
    }
    //DUEL DISINI KUY
    private static void turn(int i) {
        
    }
    
    private static void drawphase(int i) {
        
    }
    
    private void run() {
        while (!FINISHED) {
            turn(1);
        }
    }
    
    
    
    
    
    
    @Override
    public void draw() {
        System.out.println("DUEL dengan " + DuelistLand.getCurDuelist().getName());
        //ANOTHER GOES HERE
        handleInput();
    }

    @Override
    public void handleInput() {
    System.out.println("0 Back");
            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            String[] arrOpt ;
            arrOpt = opt.split(" ");
            if (null != arrOpt[0]) switch (arrOpt[0]) {
            case "list":
                if ("All".equals(arrOpt[1])) {
                    
                } else if ("Deck".equals(arrOpt[1])) {
                    
                }
                break;
            case "add":
                if (true) {
                    
                   
                } else {
                    
                }
                break;
            case "remove":
                if (true) {
                   
                   
                } else {
                    
                }
                break; 
            //Later by removes
            case "0":
            case "back":
                GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()+1);
                gsm.setState(GameStateManager.DUELISTLAND);
                break;
            default:
                break;
        }           
    }
    
}
