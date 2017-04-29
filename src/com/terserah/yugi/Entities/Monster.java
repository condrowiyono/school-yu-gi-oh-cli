/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

/**
 *
 * @author muhfai
 */
public class Monster extends Card{
	//attributes
	private int ATK, DEF, level;
	private String elemen, type;
        private Mode mode;
        //dueling need
        private boolean attackingOption;
        private boolean switchingOption;
	//konstruktor
	public Monster(String name, String desc, Location loc, float prob, 
                    int ATK, int DEF, int level, String elemen, String type, 
                    Mode mode, boolean hidden) {
		
                super(name, desc, loc, prob,hidden);
		this.ATK = ATK;
		this.DEF = DEF;
		this.level = level;
		this.elemen = elemen;
		this.type = type;
		this.mode = mode;
                this.attackingOption = true;
                this.switchingOption = true;
	}

	//setter getter
	public void setATK(int atk) {
		this.ATK = atk;
	}

	public void setDEF(int def) {
		this.DEF = def;
	}

	public void setLevel(int lvl) {
		this.level = lvl;
	}

	public void setElemen(String elemen) {
		this.elemen = elemen;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getATK() {
		return this.ATK;
	}

	public int getDEF() {
		return this.DEF;
	}

	public int getLevel() {
		return this.level;
	}

	public String getElemen() {
		return this.elemen;
	}

	public String getType() {
		return this.type;
	}

	public Mode getMode() {
		return this.mode;
	}
        @Override
        public String getJenis() {
            return this.getClass().getSimpleName();
        }

	public void summon() {
		this.setLoc(Location.FIELD);
		this.setMode(Mode.ATTACK);
	}

	public void summon(Monster m) {
		m.substituted();
		this.summon();
	}

	public void summon(Monster m, Monster n) {
		m.substituted();
		n.substituted();
		this.summon();
	}

	public void set() {
		this.setLoc(Location.FIELD);
		this.setMode(Mode.DEFENSE);
	}

	public void destroyed() {
		this.setLoc(Location.GRAVEYARD);
		//this.setPosition("Other");
	}

	public void substituted() {
		this.setLoc(Location.GRAVEYARD);
		//this.setPosition("Other");
	}

	public void changeToATK() {
		this.setMode(Mode.ATTACK);
	}

	public void changeToDEF() {
		this.setMode(Mode.DEFENSE);
	}

	public void flip() {
		this.setMode(Mode.ATTACK);
	}

	public void flipSummon() {
		this.setMode(Mode.ATTACK);
	}
        
        public boolean isAttackingOption() {
            return this.attackingOption;
        } 
        public boolean isSwitchingOption() {
            return this.switchingOption;
        } 
        public void setAttackingOption(boolean a) {
            this.attackingOption = a;
        }
        
        public void setSwitchingOption(boolean a) {
            this.switchingOption = a;
        }
        
        public void attack(Monster m) {
            if ((this.getATK() > m.getDEF() && 
                m.getMode() == Mode.DEFENSE) ||
                (this.getATK()>m.getATK() &&
                m.getMode() == Mode.ATTACK)) {
                    if (m.mode == Mode.DEFENSE)
                       Card.getOppField().removeMonsterToGraveyard(m);
                    else {
                        Card.getOppField().removeMonsterToGraveyard(m);
                        Card.DecreaseLPOpp(this.getATK() - m.getATK());
                    }
            } else if ((this.getATK()<m.getDEF() &&
                        m.getMode() == Mode.DEFENSE) ||
                        (this.getATK()<m.getATK() &&
                        m.getMode() == Mode.ATTACK)) {
                    if (m.mode==Mode.DEFENSE) {
                        Card.DecreaseLPActive(m.getDEF() - this.getATK());
                        m.setHidden(false);
                    } else {
                        Card.getActiveField().removeMonsterToGraveyard(this);
                        Card.DecreaseLPActive((m.getATK() - this.getATK()));
                    }
            } else if (m.mode != Mode.DEFENSE) {
                Card.getOppField().removeMonsterToGraveyard(m);
                Card.getActiveField().removeMonsterToGraveyard(this);
            }
        }

	public void directAttack() {
            Card.DecreaseLPOpp(this.ATK);
                
	}
        
}


