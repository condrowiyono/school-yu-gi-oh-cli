package com.terserah.yugi.Entities;

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
        
        public void actionMonsterEffect(Monster monster, Monster opp) {
             switch (monster.getSlug()) {
                 case "hane-hane" :
                     if (monster.getMode()==Mode.DEFENSE
                         && this.MONSTER.contains(opp))
                     {
                         this.MONSTER.remove(opp);
                         if (this.HAND.size()<5) 
                         { 
                             opp.setLoc(Location.HAND);
                             this.HAND.add(opp);
                         } else 
                         {
                             opp.setLoc(Location.GRAVEYARD);
                             this.GRAVEYARD.add(opp);
                         }
                         System.out.println("Hane - hane activated");
                     }
                     break;
                 case "man-eaterbug":
                     if (monster.getMode()==Mode.DEFENSE
                         && this.MONSTER.contains(opp))
                     {
                         this.MONSTER.remove(opp);
                         {
                             opp.setLoc(Location.GRAVEYARD);
                             this.GRAVEYARD.add(opp);
                             System.out.println("man eater bug ativated");
                         }   
                     }
                     break;
                 default :
                     break;
             }
         }

         //aksi effect di kartu spell
         public void actionSpell(Spell spell, ArrayList<Monster> opps) {
             switch (spell.getSlug()) {
                 case "fissure":
                     if (opps.size()>0) {
                        
                     }
                     break;
                 case "stopdefense" :
                     System.out.println("Sto defense activated");
                     break;
                 default :
                     break;

             }
         }

         public  void actionTrap(Trap trap, Monster monster ) {
             switch (trap.getSlug()) {
                 case "negateattack":
                     System.out.println("Negate attack activated");
                     break;
                 case "traphole" :
                     System.out.println("traphole activated");
                     break;
                 default :
                     break;

             }          
         }

         //untuk mirror force
         public  void actionTrap(Trap trap, ArrayList<Monster> monster) {
             switch (trap.getSlug()) {
                 case "mirrorforce":
                     System.out.println("mirror force");
                     break;
                 default :
                     break;

             }       
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
        
        public void addSpellToField(Spell spell, Monster monster, boolean hidden) {
            if (this.SPELLTRAP.size() < 3) {
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
            if (this.SPELLTRAP.size() < 3) {
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