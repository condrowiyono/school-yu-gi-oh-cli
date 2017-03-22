/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import java.util.ArrayList;

/**
 *
 * @author muhfai
 */
public class Field{
        private final int maxMonster = 3;
        private final int maxSpellTrap = 3;
        
        private ArrayList<Monster> MONSTER ;
        private ArrayList<Card> SPELLTRAP ;
        private ArrayList<Card> GRAVEYARD;
        private ArrayList<Card> HAND;
        private Deck DECK;
        private Phase phase;
        
        public Field() {
            this.MONSTER = new ArrayList<Monster>();
            this.SPELLTRAP = new ArrayList<Card>();
            this.HAND = new ArrayList<Card>();
            this.GRAVEYARD = new ArrayList<Card>();
            this.DECK = new Deck();
            this.phase = Phase.MAIN1;
        }
        
        //setter getter
        public Phase getPhase() {
            return phase; 
        }
        public void setPhase(Phase phase) {
            this.phase = phase;
        }
        public ArrayList<Monster> getMonsterArea() {
            return MONSTER;
        }
        public ArrayList<Card> getSpellTrapArea() {
            return SPELLTRAP;
        }
        public ArrayList<Card> getHand() {
            return HAND;
        }
        public ArrayList<Card> getGraveyard() {
            return GRAVEYARD;
        }
        
        public Deck getDeck() {
            return DECK;
        }
        
        public void addMonsterToField(Monster monster, Mode m) {
            Location  loc = monster.getLoc();
            if (loc==Location.HAND)
                HAND.remove(monster);
            monster.setMode(m);
            monster.setLoc((Location.FIELD));
            MONSTER.add(monster);
        }
        
        public void addMonsterToField(Monster monster, Mode m,
                ArrayList<Monster> tribute) {
            removeMonsterToGraveyard(tribute);
            addMonsterToField(monster, m);
        }
        
        private void removeMonsterToGraveyard(ArrayList<Monster> tribute) {
            for (int i = 0 ; i < MONSTER.size();i++) 
                removeMonsterToGraveyard(MONSTER.get(i));
        }
        
        private void removeMonsterToGraveyard(Monster monster) {
            if (MONSTER.contains(monster)) {
                monster.setLoc(Location.GRAVEYARD);
                MONSTER.remove(monster);
                GRAVEYARD.add(monster);
            }
        }
        
        
        
        
        //tambahkan monster ke field
        //public void addMonsterToField(Monster monster, )
        
	/*
        private Card[] arena;
	private int size;
	
	public Field(int size) {
		arena = new Card[size];
		this.setSize(size);
	}
	
	public void setSize(int s) {
		this.size = s;
	}
	
	public int getSize() {
		return size;
	}
	
	public Card getACard(int i) {
		return this.arena[i];
	}
	
	public void setACard(int idx, Card c) {
		this.arena[idx] = c;
	}
	
	public void add(Card c) {
		int i = 0;
		while ((this.arena[i] != null) && (i<size)){
			i++;
		}
		if (this.arena[i] == null) {
			this.arena[i] = c;
		}
	}
	
	public void move(int idx, Field f) {
		Card temp = this.arena[idx];
		this.arena[idx] = null;
		f.add(temp);
	}
	
	public void reset() {
		int i;
		for (i=0; i<size; i++) {
			this.arena[i] = null;
		}
	}
    */




}
