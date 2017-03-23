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
public class Trap extends Card{
    private boolean hidden;

    //konstruktor
    public Trap(String name, String description, Location loc, float probability, boolean hidden) {
            super(name, description, loc, probability);
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

    public void set() {
            if (this.getLoc().equals(Location.HAND)) {
                    this.setHidden(true);
                    this.setLoc(Location.FIELD);
            }
    }

    public void flip() {
            if (this.getLoc().equals(Location.FIELD) && (getHidden())) {
                    this.setHidden(false);
                    //effect
            }
    }

    public void finish() {
            this.setHidden(true);
            this.setLoc(Location.GRAVEYARD);
    }
    @Override
    public String getJenis() {
        return this.getClass().getSimpleName();
       }

}
