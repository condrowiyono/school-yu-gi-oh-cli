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
	//konstruktor
	public Monster(String name, String desc, Location loc, float prob, 
                    int ATK, int DEF, int level, String elemen, String type, 
                    Mode mode) {
		
                super(name, desc, loc, prob);
		this.ATK = ATK;
		this.DEF = DEF;
		this.level = level;
		this.elemen = elemen;
		this.type = type;
		this.mode = mode;
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

	/* nunggu selesai dibuat class pendukungnyas
        public void attack(Monster m, Duelist d, Player p) {
		if (m.getPosition().equals("Attack")) {
			if(this.getATK() > m.getATK()) {
				d.setLifePoint(d.getLifePoint() - (this.getATK() - m.getATK()));
				m.destroyed();
			} else if (this.getATK() == m.getATK()) {
				this.destroyed();
				m.destroyed();
			} else {
				p.setLifePoint(p.getLifePoint() - (m.getATK() - this.getATK()));
				this.destroyed();
			}
		} else if (m.getPosition().equals("Open Defend")) {
			if (this.getATK() > m.getDEF()) {
				m.destroyed();
			} else if (this.getATK() < m.getDEF()) {
				p.setLifePoint(p.getLifePoint() - (m.getDEF() - this.getATK()));
			}
		} else if (m.getPosition().equals("Close Defend")) {
			m.flip();
			if (this.getATK() > m.getDEF()) {
				m.destroyed();
			} else if (this.getATK() < m.getDEF()) {
				p.setLifePoint(p.getLifePoint() - (m.getDEF() - this.getATK()));
			}
		}
	}

	public void directAttack(Player p) {
		p.setLifePoint(p.getLifePoint() - this.getATK());
	}

	public void showDetail() {
		System.out.println("Monster name	    : "+getName());
		System.out.println("Monster description	: "+getDesc());
		System.out.println("Monster ATK		    : "+getATK());
		System.out.println("Monster DEF		    :"+getDEF());
		System.out.println("Monster Level	    :"+getLevel());
		System.out.println("Monster Element	    :"+getElemen());
		System.out.println("Monster Type	    :"+getType());
	}

	public void effect() {

	}
        */
        @Override
        public String getJenis() {
            return this.getClass().getSimpleName();
        }
}


