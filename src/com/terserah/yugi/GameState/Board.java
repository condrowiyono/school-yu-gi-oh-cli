/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Card;
import com.terserah.yugi.Entities.Deck;
import com.terserah.yugi.Entities.Phase;
import com.terserah.yugi.Entities.Player;

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
    
    public Board(Player p1, Player p2) {
        this.activePlayer = null;
        this.oppPlayer = null;
        this.winner = null;
        Card.setBoard(this);
        this.p1 = p1;
        this.p2 = p2;
        Deck da = p1.getDeck();
        Deck db = p2.getDeck();
        this.p2.getField().setDeck(db);
        this.p1.getField().setDeck(da);
        p1.getField().addNCardsToHand(6);
        p2.getField().addNCardsToHand(5);
        whoStarts();
    }

    private void whoStarts() {
        activePlayer = p1;
        oppPlayer = p2;
    }
    public void startGame(Player p1, Player p2) {
        this.setP1(p1);
        this.setP2(p2);
        whoStarts();
        activePlayer.getField().addNCardsToHand(6);
        oppPlayer.getField().addNCardsToHand(5);
    }

    public void nextPlayer() {
        //Swapping player
        if (getWinner()==null) {
            Player tmp = activePlayer;
            tmp.getField().clearAll();
            activePlayer = oppPlayer;
            oppPlayer = tmp;
            activePlayer.addCardToHand();
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
        if (activePlayer.getLP()<1) {
            activePlayer.setLP(0);
            this.setWinner(oppPlayer);
        } else if (oppPlayer.getLP()<1) {
            oppPlayer.setLP(0);
            this.setWinner(activePlayer);
        }
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
