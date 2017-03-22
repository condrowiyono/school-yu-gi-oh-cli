/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author condro
 */
public class MainPlayer extends Player{
    private int MONEY;
    private Deck AllCard;
    private String lastPlayed;
    
    public MainPlayer(String name) {
        super(name);
        this.MONEY = 2000;
        this.AllCard = new Deck();
        this.lastPlayed = this.getToday();
    }
    
    public MainPlayer(String name, Deck deck) {
        super(name);
        this.MONEY = 2000;
        this.AllCard = new Deck();
        this.lastPlayed = this.getToday();
        this.AllCard = deck;
    }
    
    public MainPlayer(String name, int x, int y, int money, Deck allCard, Deck deck, String lp) {
        super(name,x,y,deck);
        this.MONEY = money;
        this.AllCard = allCard;
        this.lastPlayed = lp;
    }

    public int getMONEY() {
            return MONEY;
    }
    public void setMONEY(int mONEY) {
            MONEY = mONEY;
    }
    public Deck getAllCard() {
            return AllCard;
    }
    public void setAllCard(Deck allCard) {
            AllCard = allCard;
    }
    
    public String getLastPlayed() {
        return this.lastPlayed;
    }
    
    private  String getToday() {
        Date date = new Date(); 
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd HH:MM");
        return dt1.format(date);

    }
    public void setLastPlayed() {
        this.lastPlayed = this.getToday();
    }

    @Override
    public boolean summonMonster(Monster monster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean summonMonster(Monster monster, ArrayList<Monster> tribute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setMonster(Monster monster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setMonster(Monster monster, ArrayList<Monster> tribute) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setSpell(Spell spell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean activateSpell(Spell spell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean attack(Monster monster, Monster opp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean directAttack(Monster monster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCardToHand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNCardsToHand(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void endPhase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean switchMonsterPosition(Monster monster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endTurn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
