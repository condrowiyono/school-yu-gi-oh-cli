/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

/**
 *
 * @author condro
 */
public class MainPlayer extends Player{
    private int MONEY;
    private Deck AllCard;
    
    public MainPlayer(String name) {
        super(name);
        this.MONEY = 2000;
        this.AllCard = new Deck();
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
}
