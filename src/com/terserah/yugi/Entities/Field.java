package com.terserah.yugi.Entities;

import com.terserah.yugi.GameState.ShopState;
import java.util.ArrayList;

/**
 *
 * @author muhfai
 */
public class Field{
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
        
        public void setFieldDeck(Deck deck) {
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
            for (int i = 0 ; i < tribute.size();i++) 
                removeMonsterToGraveyard(tribute.get(i));
        }
        
        public void removeMonsterToGraveyard(Monster monster) {
            if (MONSTER.contains(monster)) {
                monster.setLoc(Location.GRAVEYARD);
                MONSTER.remove(monster);
                GRAVEYARD.add(monster);
            }
        }
        
        public void addSpellToField(Spell spell, boolean hidden) {
            if (this.SPELLTRAP.size() < 3) {
                spell.setLoc(Location.FIELD);
                SPELLTRAP.add(spell);
                HAND.remove(spell);
            }
        }
        
        public void activateSpell(Spell spell){
            if (this.SPELLTRAP.contains(spell) &&
                    this.getPhase() != Phase.BATTLE) {
                
                spell.setHidden(false);
                CardEffect.actionSpell(spell);
                removeSpellToGraveyard(spell);
            }
        }
 
        
        public void removeSpellToGraveyard(Spell spell) {
            //Equip spell
            //should be getbyType= Equib, not implement yet
            Spell equib = (Spell) ShopState.allCard.getBySlug("followind");
            
            if (this.SPELLTRAP.contains(equib)) { } 
            else if (this.SPELLTRAP.contains(spell)) {
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
        
        public void addTrapToField(Trap trap) {
            if (this.SPELLTRAP.size() < 3) {
                trap.setHidden(false);
                SPELLTRAP.add(trap);
                trap.setLoc(Location.FIELD);
                HAND.remove(trap);
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
            Card card = this.DECK.drawOneCard();
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
        public void removeHand(Card card) {
            if (this.HAND.contains(card)) {
                this.HAND.remove(card);
                card.setLoc(Location.GRAVEYARD);
                this.GRAVEYARD.add(card);
            }
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
}