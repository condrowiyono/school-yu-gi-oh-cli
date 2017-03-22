/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import java.util.ArrayList;

/**
 *
 * @author condro
 */


public abstract class Player {
   private String NAME;
   private Deck PLAYERDECK;
   private Point POSISI;
   //Field for Dueling Purpose
   private Field FIELD;

   public Player(String name) {
       this.NAME = name;
       Point newPos = new Point(5,5);
       this.POSISI = newPos;
       this.PLAYERDECK = new Deck();
       this.FIELD = new Field();
   }
   
   public Player(String name, int x, int y) {
       this.NAME = name;
       Point newPos = new Point(x,y);
       this.PLAYERDECK = new Deck();
       this.POSISI = newPos;
   }
   public Player(String name, int x, int y, Deck deck) {
       this.NAME = name;
       Point newPos = new Point(x,y);
       this.PLAYERDECK = new Deck();
       this.POSISI = newPos;
       this.PLAYERDECK = deck;
   }
   
   public String getName() {
       return this.NAME;
   };
   
   public Point getPosisi() {
       return this.POSISI;
   }
   
   public void setPosisi(int x, int y) {
       this.POSISI.setX(x);
       this.POSISI.setY(y);
   }
   
   public Deck getDeck() {
       return this.PLAYERDECK;
   }
   
   public boolean overDeck() {
        return ((this.PLAYERDECK.getSize()<10) || 
                (this.PLAYERDECK.getSize()>15));
   }
   
    public boolean isDoubledCard() {
        boolean flag = false; 
        for (int i = 0; i < this.PLAYERDECK.getSize(); i++) { 
            for (int j = i + 1 ; j < this.PLAYERDECK.getSize(); j++) { 
                if (this.PLAYERDECK.get(i).equals(this.PLAYERDECK.get(j))) { 
                    flag =  true;
                } 
            }  
        }
        return flag;
    }
    
        //astract method for dueling
    public abstract boolean summonMonster(Monster monster);
    public abstract boolean summonMonster(Monster monster, ArrayList<Monster> tribute);
    public abstract boolean setMonster(Monster monster);
    public abstract boolean setMonster(Monster monster, ArrayList<Monster> tribute);
    
    public abstract boolean setSpell(Spell spell);
    public abstract boolean activateSpell(Spell spell);
    
    public abstract boolean attack(Monster monster, Monster opp);
    public abstract boolean directAttack(Monster monster);
    
    //card to hand
    public abstract void addCardToHand();
    public abstract void addNCardsToHand(int n);
    
    public abstract void endPhase();
    public abstract boolean switchMonsterPosition(Monster monster);
    public abstract boolean endTurn();
}
