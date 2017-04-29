package com.terserah.yugi.Entities;

import com.terserah.yugi.GameState.DuelState;
import com.terserah.yugi.GameState.ShopState;
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
   private int lp;
   private boolean AddMonsterOption ; 

   public Player(String name) {
       this.NAME = name;
       Point newPos = new Point(5,5);
       this.POSISI = newPos;
       this.PLAYERDECK = new Deck();
       this.FIELD = new Field();
       this.lp = 2000;
       this.AddMonsterOption = true;
   }
   
   public Player(String name, int x, int y) {
       this.NAME = name;
       Point newPos = new Point(x,y);
       this.PLAYERDECK = new Deck();
       this.POSISI = newPos;
       this.FIELD = new Field();
       this.lp = 2000;
       this.AddMonsterOption = true;
   }
   public Player(String name, int x, int y, Deck deck) {
       this.NAME = name;
       Point newPos = new Point(x,y);
       this.PLAYERDECK = new Deck();
       this.POSISI = newPos;
       this.PLAYERDECK = deck;
       this.FIELD = new Field();
       this.lp = 2000;
       this.AddMonsterOption = true;
   }
   
   public int getLP() {
       return this.lp;
   }
   public void setLP(int lp) {
       this.lp = lp;
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
   public void setPlayerDeck(Deck deck) {
       this.PLAYERDECK = deck;
   }
   
   public boolean overDeck() {
        return ((this.PLAYERDECK.getSize()<10) || 
                (this.PLAYERDECK.getSize()>15));
   }
    
    public Field getField() {
        return this.FIELD;
    }
    
    public void resetField() {
        this.AddMonsterOption = true;
        this.FIELD = new Field();
    }

    public  boolean isAddMonsterOption() {
        return AddMonsterOption;
    }
    public void setAddMonsterOption(boolean addMonsterOption) {
        AddMonsterOption = addMonsterOption;
    }
        //astract method for dueling
    public boolean summonMonster(Monster monster) {
        boolean flag = false;
        if (!this.isAddMonsterOption())
            System.out.println("Another summon occur");
        else if (this.getField().getMonsterArea().size() >= 3 ) {
            System.out.print("No more space available");
        }
        else if (this.getField().CheckAddingCard() &&
                this.getField().getHand().contains((Monster) monster) &&
                this.isAddMonsterOption() && monster.getLevel() < 5) {
            this.getField().addMonsterToField(monster, Mode.ATTACK, false); 
            
            if (CardEffect.actionTrapHole()) {
                 Trap trap = (Trap) ShopState.allCard.getBySlug("traphole");
                 DuelState.ingame.getOppPlayer().getField().removeMonsterToGraveyard(monster);
                 DuelState.ingame.getOppPlayer().getField().removeTrapToGraveyard(trap);
                 System.out.println("should be a trap");
            }
            System.out.println(CardEffect.actionTrapHole());
            this.setAddMonsterOption(false);
            flag =  true;
        }
        return flag;
    }

    
    public boolean summonMonster(Monster monster, ArrayList<Monster> tribute) {
        boolean flag = false;
        if (!this.isAddMonsterOption())
            System.out.println("Another summon occur");
        else if (this.getField().getMonsterArea().size() >= 3 ) {
            System.out.print("No more space available");
        } else if (this.getField().CheckAddingCard() &&
                this.getField().getHand().contains((Monster) monster)) {
            this.getField().addMonsterToField(monster, Mode.ATTACK, false,tribute);
            this.setAddMonsterOption(false);
            flag =  true;
        }    
       return false;
    }
    
    public boolean setMonster(Monster monster) {
        boolean flag = false;
        if (!this.isAddMonsterOption())
            System.out.println("Another summon occur");
        else if (this.getField().getMonsterArea().size() >= 3 ) {
            System.out.print("No more space available");
        } else if (this.getField().CheckAddingCard() &&
                this.getField().getHand().contains((Monster) monster)) {
            this.getField().addMonsterToField(monster, Mode.DEFENSE, true);
            this.setAddMonsterOption(false);
            flag =  true;
        }    
       return false;
    }
    
    
    public boolean setMonster(Monster monster, ArrayList<Monster> tribute) {
        boolean flag = false;
        if (!this.isAddMonsterOption())
            System.out.println("Another summon occur");
        else if (this.getField().getMonsterArea().size() >= 3 ) {
            System.out.print("No more space available");
        } else if (this.getField().CheckAddingCard() &&
                this.getField().getHand().contains((Monster) monster) &&
                (monster.getLevel()>=7 && tribute.size() == 2 ||
                monster.getLevel() < 7 && tribute.size()==1) &&
                this.isAddMonsterOption())
                {
                    this.getField().addMonsterToField(monster, Mode.DEFENSE, true, tribute);
                    this.setAddMonsterOption(false);
                    flag =  true;
        }    
       return false;
    }
    public boolean setSpell(Spell spell) {
        boolean flag = false;
        if (this.getField().getSpellTrapArea().size()>=3)
            System.out.println("No more room");
        else if (this.getField().CheckAddingCard() &&
                this.getField().getHand().contains((Spell) spell)) {
            this.getField().addSpellToField(spell,true);
            flag = true;
        } 
        return flag;
    }
    public boolean activateSpell(Spell spell) {
        boolean flag = false;
        if (this.getField().getSpellTrapArea().size()>=3)
            System.out.println("No more room");
        else if ( Card.getActiveField().getPhase() == Phase.BATTLE)
            System.out.println("Salah fase");
        else if (Card.getBoard().getActivePlayer() == this
                && Card.getBoard().getWinner() == null
                && ((this.getField().getHand().contains((Spell) spell)
                && this.getField().getSpellTrapArea().size()<5)
                || this.getField().getSpellTrapArea().contains((Spell) spell))) {
                this.getField().activateSpell(spell);
                flag = true;
        }   
        return flag;
    }
   public boolean setTrap(Trap trap) {
        boolean flag = false;
        if (this.getField().getSpellTrapArea().size()>=3)
            System.out.println("No more room");
        else if (this.getField().CheckAddingCard() &&
                this.getField().getHand().contains((Trap) trap)) {
            this.getField().addTrapToField(trap);
            flag = true;
        } 
        return flag;
    }
    public boolean activateTrap(Trap trap, Monster monster) {
      return true;
    }
    
    //batle
    public boolean attack(Monster monster, Monster opp) {
        boolean flag = false;
        if (!monster.isAttackingOption())
            System.out.println("No more attack");
        else if (Card.getActiveField().getPhase() !=Phase.BATTLE)
            System.out.println("Salah fase");
        else if (monster.getMode() == Mode.DEFENSE)
            System.out.println("Posisi defense");
        else if (Card.getActiveField().getMonsterArea().contains(monster)
                && Card.getOppField().getMonsterArea().contains(opp)
                && Card.getBoard().getWinner()==null
                && monster.isAttackingOption()) {
            monster.attack(opp);
            CardEffect.actionMonsterEffect(opp, monster);
            monster.setAttackingOption(false);
            Card.getBoard().isAnyWinner();
            flag = true;
        }
        return flag;
    }
    public boolean directAttack(Monster monster) {
        boolean flag = false;
        if (!monster.isAttackingOption())
            System.out.println("No more attack");
        else if (Card.getActiveField().getPhase() !=Phase.BATTLE)
            System.out.println("Salah fase");
        else if (monster.getMode() == Mode.DEFENSE)
            System.out.println("Posisi defense");
        else if (Card.getActiveField().getMonsterArea().contains(monster)
                && this == Card.getBoard().getActivePlayer()
                && Card.getOppField().getMonsterArea().isEmpty()
                && Card.getBoard().getWinner()==null) {
            monster.directAttack();
            monster.setAttackingOption(false);
            Card.getBoard().isAnyWinner();
            flag = true;
        }
        return flag;    
    }
    
    //card to hand
    public void addCardToHand() {
        if (this == Card.getBoard().getActivePlayer()
                && Card.getBoard().getWinner() == null) {
            if (this.getField().getDeck().getSize()==0)
                //menang
                Card.getBoard().setWinner(Card.getBoard().getOppPlayer());
            else
                this.getField().addCardsToHand();
        }
    }
    public void addNCardsToHand(int n) {
        if (this == Card.getBoard().getActivePlayer()
                && Card.getBoard().getWinner() == null) {
            if (this.getField().getDeck().getSize()<n)
                //menang
                Card.getBoard().setWinner(Card.getBoard().getOppPlayer());
            else
                this.getField().addNCardsToHand(n);
        }
    }
    
    public void endPhase() {
        if (Card.getBoard().getWinner() == null
            && this == Card.getBoard().getActivePlayer()) {
            if (this.getField().getPhase() == Phase.MAIN1)
                this.getField().setPhase(Phase.BATTLE);
            else if (this.getField().getPhase() == Phase.BATTLE)
                this.getField().setPhase(Phase.MAIN2);
        }   else if  (this.getField().getPhase() == Phase.MAIN2)
                this.endTurn();
    }
    public boolean switchMonsterPosition(Monster monster) {
        boolean flag = false;
        if (!monster.isSwitchingOption())
            System.out.println("Gak bisa dibalik");
        else if (this.getField().CheckAddingCard()
                && this.getField().getMonsterArea().contains(monster)){
            if (monster.getMode() == Mode.ATTACK)
                monster.setMode(Mode.DEFENSE);
            else {
                monster.setMode(Mode.ATTACK);
                monster.setHidden(false);
            }
            monster.setSwitchingOption(false);
            flag = true;
        }
        return flag;
    }
    
    public boolean endTurn() {
        boolean flag = false;
        if ((Card.getActiveField() == this.getField() 
                && Card.getBoard().getWinner()==null)) {
            this.AddMonsterOption = true;
            Card.getBoard().nextPlayer();
            Card.getBoard().isAnyWinner();
            flag = true;
        }
        return flag;
    }
}
