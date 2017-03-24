package com.terserah.yugi.Entities;

import java.text.SimpleDateFormat;
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
}
