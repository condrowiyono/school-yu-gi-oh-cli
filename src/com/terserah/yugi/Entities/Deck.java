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
import com.terserah.yugi.GameState.*;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    public final static int MAX_DECK_SIZE = 30;
    public final static int MIN_DECK_SIZE = 20;
    int numCardsRemaining; 

    public Deck(){
        numCardsRemaining = 0;
    }

    public Deck(ArrayList<Card> initialDeck){
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
        /*
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random random = new Random();
        while(deck.size() > 0){
            int cardToRemove = random.nextInt(deck.size());
            Card tempCard = deck.get(cardToRemove);
            deck.remove(cardToRemove);
            tempDeck.add(tempCard);
        }
        while(tempDeck.size() > 0){
            Card tempCard = tempDeck.get(0);
            tempDeck.remove(0);
            deck.add(tempCard);
        }
        */
    }

    public Card draw(){
        Card toDraw = deck.get(0);
        deck.remove(0);
        return toDraw;
    }
    public ArrayList<Card> drawNCards(int n) {
        ArrayList<Card> res = new ArrayList<Card>();
        for (int i=1;i<=n;i++) {
            res.add(draw());
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
}

