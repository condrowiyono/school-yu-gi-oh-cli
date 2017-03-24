//NO NEEDED
package com.terserah.yugi.Entities;

/**
 *
 * @author muhfai
 */
import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand = new ArrayList<Card>();
    public static final int MAX_HAND_SIZE = 6; //Maksimal size kartu di tangan
    public static final int INITIAL_HAND_SIZE = 5;
    int numCardsHand;

    public Hand(){
        numCardsHand = 0;
    }

    public Hand(ArrayList<Card> iniHand){
        for(int i = 0; i < iniHand.size(); i++){
            hand.add(iniHand.get(i));
            numCardsHand++;
        }
    }

    public void addCard(Card c){
        hand.add(c);
        numCardsHand++;
    }

    public void discardHand(){
        hand.clear();
        numCardsHand = 0;
    }

    public Object removeCardName(Card c){
        int cardIndex = hand.indexOf(c);
        if(cardIndex == -1)
            return "";
        else{
            hand.remove(c);
            numCardsHand--;
            return c;
        }
    }

    public Object removeCardNumber(int index){
        Card c = hand.get(index);
        hand.remove(index);
        numCardsHand--;
        return c;
    }

    public int getNumCards(){
        return numCardsHand;
    }

    public Card get(int index){
        return hand.get(index);
    }
}
