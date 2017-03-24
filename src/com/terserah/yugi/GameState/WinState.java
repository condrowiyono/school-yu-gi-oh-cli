/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Duelist;
import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;

/**
 *
 * @author DELL-PC
 */
public class WinState extends GameState{

    public WinState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void draw() {
        System.out.println("Selamat " + DuelState.ingame.getWinner().getName());
        System.out.println("Deck " + DuelState.ingame.getWinner().getDeck().getSize());
        System.out.println("Deck Field " + DuelState.ingame.getWinner().getField().getDeck().getSize());
        handleInput();
    }

    @Override
    public void handleInput() {
            System.out.print("Pilihan ");
            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            switch (opt) {
                case "b":
                case "back" :
                    DuelistLand.arrDuelist.remove((Duelist) DuelState.ingame.getLoser());
                    GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()+1);
                    gsm.setState(GameStateManager.DUELISTLAND);
                    break;
                default :
                    break;
            }
    }
    
}
