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
public abstract class Card{
	//attributes
	private String name, description, pos;
	private float probability = 0;
	//konstruktor
	public Card(String name) {
		this.name = name;
	}
	public Card(String name, String description, String pos, float probability) {
		this.name = name;
		this.description = description;
		this.pos = pos;
		this.probability = probability;
	}
	//setter getter
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setProability(float prob) {
		this.probability = prob;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPos() {
		return this.pos;
	}

	public float getProbability() {
		return this.probability;
	}

}

