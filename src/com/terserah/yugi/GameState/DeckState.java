/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Deck;
import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class DeckState extends GameState {

    public DeckState(GameStateManager gsm) {
        super(gsm);
    }
    public void printCard(Deck deck) {
        if (deck.getSize()>0) {
            int k = 1;
            for (int i = 0; i < deck.getSize();i++) {
              System.out.println(deck.get(i).getSlug()+ "\t \t" + deck.get(i).getName());
              k++;
            }
        } else
            System.out.println("No Card");
    }
    
    public boolean cekCard(String slug) {
        boolean flag = false;
        for (int i = 0; i< GamePanel.PemainUtama.getAllCard().getSize();i++)
            if (slug.equals(GamePanel.PemainUtama.getAllCard().get(i).getSlug()))
                flag = true;
        return flag;
    }
    
    @Override
    public void draw() {
        System.out.println("\n");
        System.out.println("Command");
        System.out.println("list All");
        System.out.println("list Deck");
        System.out.println("add id");
        System.out.println("remove id");
        System.out.println("save");
        handleInput();    
    }

    @Override
    public void handleInput() {
            System.out.print("Pilihan : ");
            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            //System.out.println(cekCard("fissure"));
            String[] arrOpt ;
            arrOpt = opt.split(" ");
            //for (int i = 0; i<arrOpt.length;i++)
            //    System.out.println(arrOpt[i]);
            
            
            if (null != arrOpt[0]) switch (arrOpt[0]) {
            case "list":
                if ("All".equals(arrOpt[1])) {
                    printCard(GamePanel.PemainUtama.getAllCard());
                } else if ("Deck".equals(arrOpt[1])) {
                    printCard(GamePanel.PemainUtama.getDeck());
                }
                break;
            case "add":
                if ((cekCard(arrOpt[1]))&&(!GamePanel.PemainUtama.isDoubledCard())) {
                    GamePanel.PemainUtama.getDeck().addToDeck(ShopState.allCard.getBySlug(arrOpt[1]));
                } else {
                    System.out.println("Not Found or card already doubled");
                }
                break;
            case "remove":
                if (cekCard(arrOpt[1])) {
                    GamePanel.PemainUtama.getDeck().delete(ShopState.allCard.getBySlug(arrOpt[1]));    
                } else {
                    System.out.println("Not Found");
                }
                break; 
            case "save" :
                if (GamePanel.PemainUtama.overDeck()==false) {
                    gsm.setState(GameStateManager.MENU);
                    break;
                }
            default:
                break;
        } 
            
            
    }

}
