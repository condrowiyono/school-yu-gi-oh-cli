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
	private String position;
	//konstruktor
	public Spell(String name, String desc, String post, float prob, String position) {
		super(name, desc, post, prob);
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
	public void activate() {
		this.setPosition("Open");
		if (this.getPos().equals("Hand")) {
			this.setPos("Field");
		}
		//effect
	}
	
	public void set() {
		if (this.getPos().equals("Hand")) {
			this.setPosition("Set");
			this.setPos("Field");
		}
	}
	
	public void equip(Monster m) {
		this.setPosition("Open");
		if (this.getPos().equals("Hand")) {
			this.setPos("Field");
		}
		//effect
	}
	
	public void finish() {
		this.setPosition("Other");
		this.setPos("Graveyard");
	}
	
}


	
	
