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

    public DuelState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void draw() {
        System.out.println("DUEL");
        //ANOTHER GOES HERE
        handleInput();
    }

    @Override
    public void handleInput() {
    System.out.println("0 Back");
            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            switch (opt) {
                case "0":
                    GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()+1);
                    gsm.setState(GameStateManager.DUELISTLAND);
                    break;
                default:
                    break;
            }
    }
    
}
