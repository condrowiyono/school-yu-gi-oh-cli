/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Card;
import com.terserah.yugi.Entities.Deck;
import com.terserah.yugi.Entities.Monster;
import com.terserah.yugi.Entities.Spell;
import com.terserah.yugi.Entities.Trap;
import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class ShopState extends GameState {

    public static Deck allCard = new Deck();
    
    public ShopState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void draw() {
        System.out.println("SHOP");
        printCard(ShopState.allCard);
        //GOES HERE
        handleInput();
    }

    public void printCard(Deck deck) {
        int i;
        int k = 1;
        Deck monster = deck;
        for (i = 0; i < monster.getSize();i++) {
          System.out.println(k+": "+monster.get(i).getName());
          k++;
        }
    }
         
    @Override
    public void handleInput() {
            System.out.println("Apakah anda ingin membeli pack?");
            System.out.println("0 Tidak");
            System.out.println("1 Iya");
            System.out.print("Pilihan : ");
            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            switch (opt) {
                case "1":
                case "iya" :
                    int money = GamePanel.PemainUtama.getMONEY();
                    if (money<100) {
                        System.out.println("Uang kurang");
                    } else {
                    GamePanel.PemainUtama.setMONEY(money-200);
                    for (int z =1; z <=3; z++){
                        Random rand = new Random();
                        int v = rand.nextInt(99);
                        if ((v >=0) && (v <= 1)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(0));
                            System.out.println(ShopState.allCard.get(0).getName());
                        }
                        else if ((v >=2) && (v <= 8)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(1));
                            System.out.println(ShopState.allCard.get(1).getName());
                        }
                        else if ((v >=9) && (v <= 14)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(2));
                            System.out.println(ShopState.allCard.get(2).getName());
                        } 
                        else if ((v >=15) && (v <= 24)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(3));
                            System.out.println(ShopState.allCard.get(3).getName());
                        }
                        else if ((v >=25) && (v <= 34)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(4));
                            System.out.println(ShopState.allCard.get(4).getName());
                        }
                        else if ((v >=35) && (v <= 40)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(5));
                            System.out.println(ShopState.allCard.get(5).getName());
                        }
                        else if ((v >=41) && (v <= 46)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(6));
                            System.out.println(ShopState.allCard.get(6).getName());
                        }
                        else if ((v >=47) && (v <= 50)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(7));
                            System.out.println(ShopState.allCard.get(7).getName());
                        }
                        else if ((v >=51) && (v <= 57)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(8));
                            System.out.println(ShopState.allCard.get(8).getName());
                        }
                        else if ((v >=51) && (v <= 57)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(9));
                            System.out.println(ShopState.allCard.get(9).getName());
                        }
                        else if ((v >=58) && (v <= 65)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(10));
                            System.out.println(ShopState.allCard.get(10).getName());
                        }
                        else if ((v >=66) && (v <= 72)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(11));
                            System.out.println(ShopState.allCard.get(11).getName());
                        }
                        else if ((v >=73) && (v <= 79)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(12));
                            System.out.println(ShopState.allCard.get(12).getName());
                        }

                        else if ((v >=80) && (v <= 86)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(13));
                            System.out.println(ShopState.allCard.get(13).getName());
                        }
                        else if ((v >=87) && (v <= 94)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(14));
                            System.out.println(ShopState.allCard.get(14).getName());
                        }
                        else if ((v >=94) && (v <= 99)) {
                            GamePanel.PemainUtama.getAllCard().addToDeck(ShopState.allCard.get(15));
                            System.out.println(ShopState.allCard.get(15).getName());
                        }
                    }
                    GamePanel.PemainUtama.setMONEY(money-100);
                    }
                case "0":
                case "tidak":
                    GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()+1);
                    gsm.setState(GameStateManager.DUELISTLAND);
                    break;
                default:
                    break;
            }
    }
    
}
