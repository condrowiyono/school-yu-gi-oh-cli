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
	private String name, description, slug;
        private Location loc;
	private float probability = 0;
	//konstruktor
	
        public Card(String name) {
		this.name = name;
                this.slug = name.replaceAll(" ", "").toLowerCase();
	}
	public Card(String name, String description, Location pos, float probability) {
		this.name = name;
		this.description = description;
		this.probability = probability;
                this.slug = name.replaceAll(" ", "").toLowerCase();
	}
	//setter getter
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
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

	public Location getLoc() {
		return this.loc;
	}

	public float getProbability() {
		return this.probability;
	}
	public String getSlug() {
		return this.slug;
	}
        public abstract String getJenis() ;
}

