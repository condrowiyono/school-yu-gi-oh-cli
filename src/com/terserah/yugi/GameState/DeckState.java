/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Card;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class DeckState extends GameState {

    public DeckState(GameStateManager gsm) {
        super(gsm);
    }
    public void printCard(ArrayList<Card> initialDeck) {
        int i;
        int k = 1;
        for (i = 0; i == initialDeck.size();i++) {
          System.out.println(k+": "+initialDeck.get(i).getName());
          k++;
        }
    }
    public ArrayList<Card> setDeck(ArrayList<Card> initialDeck) {
        ArrayList<Card> deck = new ArrayList<Card>();
        boolean y = true;
        System.out.println("Ketik '0' jika sudah selesai membuat deck");
        int i;
        System.out.println("Masukkan no kartu yang ingin dimasukkan ke deck ");
        Scanner in = new Scanner(System.in);
        int opt;
        System.out.println("Masukkan no kartu : ");
        opt = Integer.parseInt(in.nextLine());
        i = 1;
        while ((opt == 0) && (i >= 10) && (i <= 15)) {
            System.out.println("Masukkan no kartu : ");
            opt = Integer.parseInt(in.nextLine());
            deck.add(initialDeck.get(opt));   
            i++;
        }
        return deck;
    }
    @Override
    public void draw() {
        System.out.println("DECK");
        //ANOTHER GOES HERE
        handleInput();    
    }

    @Override
    public void handleInput() {
        
    }
    
    public void handleInput (ArrayList<Card> initialDeck) {
        System.out.println("Kartu yang anda miliki :");
        printCard(initialDeck);
        ArrayList<Card> card = setDeck(initialDeck);
    }
}
