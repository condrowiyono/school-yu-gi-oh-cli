/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import java.util.*;
/**
 *
 * @author condro
 */
public class Duelist extends Player{
    private String RANK;
   
    public Duelist(String name, int x, int y, String rank, Deck initDeck) {
        super(name,x,y,initDeck);
        this.RANK = rank;
    }
    
    public String getRank() {
        return this.RANK;
    }
    
    public void setRank(String rank) {
        this.RANK = rank;
    }

}
