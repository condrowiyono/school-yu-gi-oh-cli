/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

/**
 *
 * @author muhfai
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import com.terserah.yugi.GameState.ShopState;

public class Deck {
    private ArrayList<Card> deck;
    public final static int MAX_DECK_SIZE = 30;
    public final static int MIN_DECK_SIZE = 20;
    int numCardsRemaining; 

    public Deck(){
        this.deck = new ArrayList<Card>();
        numCardsRemaining = 0;
    }

    public Deck(ArrayList<Card> initialDeck){
        this.deck = new ArrayList<Card>();
        for(int i = 0; i < initialDeck.size(); i++){
            deck.add(initialDeck.get(i));
        }
        numCardsRemaining = deck.size();
        shuffle();
    }
    
    public ArrayList<Card> getArrDeck() {
        return this.deck;
    }
    private void shuffle(){
        Collections.shuffle(deck);
    }

    public Card drawOneCard() {
        return deck.remove(deck.size() - 1);
    }
    
    public ArrayList<Card> drawNCards(int n) {
        ArrayList<Card> res = new ArrayList<Card>();
        for (int i=1;i<=n;i++) {
            res.add(drawOneCard());
        }
        return res;
    }

    public int getNumCardsRemaining(){
        return numCardsRemaining;
    }

    public void addToBottom(Card c){
        deck.add(c);
    }

    public void addToTop(Card c){
        deck.add(0, c);
    }

    public void addToDeck(Card c){
        deck.add(c);
        shuffle();
    }

    public int getSize(){
        return deck.size();
    }

    public Card get(int index){
        return deck.get(index);
    }
    
    public Card getbyName(String name) {
        boolean flag = false;
        int idx = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (name.equals(deck.get(i).getName())) {
                flag = true;
                idx = i;
            }
        }
        if (flag) {
            return deck.get(idx);
        } else {
            return null;
        }
    }
    
    public void delete(Card c) {
        deck.remove(c);
    }
    
    public Card getBySlug(String slug) {
        boolean flag = false;
        int idx = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (slug.equals(deck.get(i).getName().replaceAll(" ", "").toLowerCase())) {
                flag = true;
                idx = i;
            }
        }
        if (flag) {
            return deck.get(idx);
        } else {
            return null;
        }
    }
    
    public Deck getbyJenis(String jenis) {
        Deck getDeck = new Deck();
        int count = 0;
        while (count<deck.size()) {
            if (jenis.equals(deck.get(count).getJenis())) {
                getDeck.addToBottom(deck.get(count));
            }
            count++;
        }
            return getDeck;
    }
    
    public static Deck getRandCard(int n) {
        ArrayList<Card> arrCard = new ArrayList<Card>();
        
        while (arrCard.size() < n) {
            Random rand = new Random(); 
            Card kartu = ShopState.allCard.get(rand.nextInt(ShopState.allCard.getSize()));
            if (!arrCard.contains(kartu)) {
                arrCard.add(kartu);
            }
        }
        return new Deck(arrCard);
    }
    public void clear() {
        deck.clear();
    }
}

