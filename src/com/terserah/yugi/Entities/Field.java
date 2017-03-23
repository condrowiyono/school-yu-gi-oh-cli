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
        private static final int maxMonster = 3;
        private static final int maxSpellTrap = 3;
        
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
        
        public void setDeck(Deck deck) {
            this.DECK = deck;
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
        
        public void addMonsterToField(Monster monster, Mode m, boolean hidden) {
            Location  loc = monster.getLoc();
            if (loc==Location.HAND)
                HAND.remove(monster);
            monster.setMode(m);
            monster.setHidden(hidden);
            monster.setLoc((Location.FIELD));
            MONSTER.add(monster);
        }
        
        public void addMonsterToField(Monster monster, Mode m, boolean hidden,
                ArrayList<Monster> tribute) {
            removeMonsterToGraveyard(tribute);
            addMonsterToField(monster, m, hidden);
        }
        
        public void removeMonsterToGraveyard(ArrayList<Monster> tribute) {
            for (int i = 0 ; i < MONSTER.size();i++) 
                removeMonsterToGraveyard(MONSTER.get(i));
        }
        
        public void removeMonsterToGraveyard(Monster monster) {
            if (MONSTER.contains(monster)) {
                monster.setLoc(Location.GRAVEYARD);
                MONSTER.remove(monster);
                GRAVEYARD.add(monster);
            }
        }
        
        public void addSpellToField(Spell spell, Monster monster, boolean hidden) {
            if (this.SPELLTRAP.size() < this.maxSpellTrap) {
                spell.setHidden(hidden);
                spell.setLoc(Location.FIELD);
                HAND.remove(spell);
                if (!hidden)
                    activateSpell(spell, monster);
                else
                    spell.setHidden(true);
            }
        }
        
        public void activateSpell(Spell spell, Monster monster){
            if (this.SPELLTRAP.contains(spell) &&
                    this.getPhase() != Phase.BATTLE) {
                
                spell.setHidden(false);
                CardEffect.actionSpell(spell, monster);
                CardEffect.actionSpell(spell, this.MONSTER);
                removeSpellToGraveyard(spell);
            }
        }
        
        public void removeSpellToGraveyard(Spell spell) {
            if (this.SPELLTRAP.contains(spell)) {
                this.SPELLTRAP.remove(spell);
                spell.setLoc(Location.GRAVEYARD);
                this.GRAVEYARD.add(spell);
            }
        }
        
        public void removeSpellToGraveyard(ArrayList<Spell> spells) {
		int n = spells.size();
		for (int i = n - 1; i >= 0; i--) {
			if (this.SPELLTRAP.contains(spells.get(i)))
				removeSpellToGraveyard(spells.get(i));
		}            
        }
        
        public void addTrapToField(Trap trap, Monster monster, boolean hidden) {
            if (this.SPELLTRAP.size() < this.maxSpellTrap) {
                trap.setHidden(hidden);
                trap.setLoc(Location.FIELD);
                HAND.remove(trap);
                if (!hidden)
                    activateTrap(trap, monster);
                else
                    trap.setHidden(true);
            }
        }
        
        public void activateTrap(Trap trap, Monster monster){
            if (this.SPELLTRAP.contains(trap) &&
                    this.getPhase() != Phase.BATTLE) {
                
                trap.setHidden(false);
                CardEffect.actionTrap(trap, monster);
                CardEffect.actionTrap(trap, this.MONSTER);
                removeTrapToGraveyard(trap);
            }
        }
        
        public void removeTrapToGraveyard(Trap trap) {
            if (this.SPELLTRAP.contains(trap)) {
                this.SPELLTRAP.remove(trap);
                trap.setLoc(Location.GRAVEYARD);
                this.GRAVEYARD.add(trap);
            }
        }
        
        public void removeTrapToGraveyard(ArrayList<Trap> traps) {
		int n = traps.size();
		for (int i = n - 1; i >= 0; i--) {
			if (this.SPELLTRAP.contains(traps.get(i)))
				removeTrapToGraveyard(traps.get(i));
		}            
        }    
        
        public void addCardsToHand() {
            Card card = this.DECK.draw();
            card.setLoc(Location.HAND);
            this.HAND.add(card);
        }
        
        public void addNCardsToHand(int n) {
            ArrayList<Card> d = this.DECK.drawNCards(n);
            for (Card card : d) {
                card.setLoc(Location.HAND);
                this.HAND.add(card);
            }
        }
        
        //Card Destruction
        public int removeHandToGraveyard() {
            for (int i=0;i<this.HAND.size();i++) {
                Card tem = this.HAND.remove(i);
                tem.setLoc(Location.GRAVEYARD);
                this.GRAVEYARD.add(tem);
            }
            return this.HAND.size();
        }
        
        
        public void clearAll() {
            for (int i=0; i< this.MONSTER.size();i++){
                this.MONSTER.get(i).setAttackingOption(true);
                this.MONSTER.get(i).setSwitchingOption(true);
            }
        }
        
	public boolean CheckAddingCard() {
		if(this.phase==Phase.BATTLE)
			System.out.print("Salah Fase");
		return ((this.phase == Phase.MAIN1 || this.phase == Phase.MAIN2)
				&& Card.getActiveField() == this && Card.getBoard().getWinner() == null);

	}
            
        //spell dan trap
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
