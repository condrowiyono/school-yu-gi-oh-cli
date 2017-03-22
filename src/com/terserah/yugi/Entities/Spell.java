/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

/**
 *
 * @author Faisal
 */
public class Spell extends Card{
    private boolean hidden;
    //konstruktor
    public Spell(String name, String desc, Location loc, float prob, String position) {
            super(name, desc, loc, prob);
            this.hidden = false;
    }
    //setter getter
    public void setHidden(Boolean hidden) {
            this.hidden = hidden;
    }

    public boolean getHidden() {
            return this.hidden;
    }

    //method
    public void activate() {
            this.hidden = false;
            if (this.getLoc().equals(Location.HAND)) {
                    this.setLoc(Location.FIELD);
            }
            //effect
    }

    public void set() {
            if (this.getLoc().equals(Location.HAND)) {
                    this.setHidden(true);
                    this.setLoc(Location.FIELD);
            }
    }

    public void equip(Monster m) {
            this.setHidden(false);
            if (this.getLoc().equals(Location.HAND)) {
                    this.setLoc(Location.FIELD);
            }
            //effect
    }

    public void finish() {
            this.setHidden(false);
            this.setLoc(Location.GRAVEYARD);
    }

    @Override
    public String getJenis() {
        return this.getClass().getSimpleName();
    }
	
}


	
	
