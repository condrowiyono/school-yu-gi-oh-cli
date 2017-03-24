/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Card;
import com.terserah.yugi.Entities.Deck;
import com.terserah.yugi.Entities.Field;
import com.terserah.yugi.Entities.Phase;
import com.terserah.yugi.Entities.Player;
import java.util.Scanner;

/**
 *
 * @author DELL-PC
 */
//di ada di game state tapi enggak extends Game state
public class Board {
    //deklarasi pemain 
    private Player activePlayer;
    private Player oppPlayer;
    private Player winner;
    private Player p1;
    private Player p2;
    private Player loser;
    
    public Board(Player p1, Player p2) {
        Deck d1 = new Deck(p1.getDeck().getArrDeck());
        Deck d2 = new Deck(p2.getDeck().getArrDeck());
        this.activePlayer = null;
        this.oppPlayer = null;
        this.winner = null;
        Card.setBoard(this);
        this.p1 = p1;
        this.p2 = p2;
        this.p1.resetField();
        this.p2.resetField();
        this.p1.getField().setFieldDeck(d1);
        this.p2.getField().setFieldDeck(d2);
        p1.getField().addNCardsToHand(3);
        p2.getField().addNCardsToHand(3);
        whoStarts();
    }

    private void whoStarts() {
        activePlayer = p1;
        oppPlayer = p2;
    }
    public void nextPlayer() {
        //Swapping player
        if (getWinner()==null) {
            Player tmp = activePlayer;
            tmp.getField().clearAll();
            activePlayer = oppPlayer;
            oppPlayer = tmp;
            activePlayer.addCardToHand();
            //cek kartu di tangan
            if (activePlayer.getField().getHand().size()>5)
            {
                Scanner in = new Scanner(System.in);
                System.out.println("Remove card from hand " + activePlayer);
                for (int i = 0; i< activePlayer.getField().getHand().size();i++)
                    System.out.println(i + " " + activePlayer.getField().getHand().get(i).getName());
                System.out.print("Card > ");
                int i = Integer.parseInt(in.nextLine());
                if (i<activePlayer.getField().getHand().size())
                {
                    activePlayer.getField().removeHand(activePlayer.getField().getHand().get(i));
                    System.out.println("removed");
                } else System.out.println("Error Occur");
            }
            activePlayer.getField().setPhase(Phase.MAIN1);
        }
    }
    
    public Player getActivePlayer() {
        return activePlayer;
    }
    public void setActivePlayer(Player p) {
        this.activePlayer =p;
    }
    public  Player getOppPlayer() {
        return oppPlayer;
    }
    public void setOppPlayer(Player p) {
        this.oppPlayer =p;
    }
    private void setP2(Player p2) {
        this.p2 = p2;
    }

    private void setP1(Player p1) {
        this.p1 = p1;
    }
    
    public Player getP1() {
        return this.p1;
    }
    
    public Player getP2() {
        return this.p2;
    }

    public Player getWinner() {
        Card.getBoard().isAnyWinner();
        return winner;
    }
    
    public void isAnyWinner() {
        if ( activePlayer.getLP()<1) {
            activePlayer.setLP(0);
            this.setWinner(oppPlayer);
            this.setLoser(activePlayer);
        } else if (oppPlayer.getLP()<1) {
            oppPlayer.setLP(0);
            this.setWinner(activePlayer);
            this.setLoser(oppPlayer);
        }
    }

    public void setWinner(Player winner) {
        //kembalikan kartu ke deck
        this.winner = winner;
    }
    public void setLoser(Player loser) {
        this.loser = loser;
    }
    public Player getLoser() {
        Card.getBoard().isAnyWinner();
        return loser;
    }
}
