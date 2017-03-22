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
	private String position;
	//konstruktor
	public Trap(String name, String description, Location loc, float probability, String position) {
		super(name, description, loc, probability);
		this.position = position;
	}
	//setter getter
	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return this.position;
	}
	//method

	public void set() {
		if (this.getLoc().equals(Location.HAND)) {
			this.setPosition("Set");
			this.setLoc(Location.FIELD);
		}
	}

	public void flip() {
		if (this.getLoc().equals(Location.FIELD) && (this.getPosition().equals("Set"))) {
			this.setPosition("Open");
			//effect
		}
	}

	public void finish() {
		this.setPosition("Other");
		this.setLoc(Location.GRAVEYARD);
	}
    @Override
    public String getJenis() {
        return this.getClass().getSimpleName();
    }

}
