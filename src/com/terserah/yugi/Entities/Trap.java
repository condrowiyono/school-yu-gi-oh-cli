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
	public Trap(String name, String description, String pos, float probability, String position) {
		super(name, description, pos, probability);
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
		if (this.getPos().equals("Hand")) {
			this.setPosition("Set");
			this.setPos("Field");
		}
	}

	public void flip() {
		if (this.getPos().equals("Field") && (this.getPosition().equals("Set"))) {
			this.setPosition("Open");
			//effect
		}
	}

	public void finish() {
		this.setPosition("Other");
		this.setPos("Graveyard");
	}
    @Override
    public String getJenis() {
        return this.getClass().getSimpleName();
    }

}
