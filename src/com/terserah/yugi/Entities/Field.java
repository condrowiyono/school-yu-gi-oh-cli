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
public abstract class Field{
	private Card[] arena;
	private int size;
	
	public Field(int size) {
		arena = new Card[size];
		this.setSize(size);
	}
	
	public void setSize(int s) {
		this.size = s;
	}
	
	public int getSize() {
		return size;
	}
	
	public Card getACard(int i) {
		return this.arena[i];
	}
	
	public void setACard(int idx, Card c) {
		this.arena[idx] = c;
	}
	
	public void add(Card c) {
		int i = 0;
		while ((this.arena[i] != null) && (i<size)){
			i++;
		}
		if (this.arena[i] == null) {
			this.arena[i] = c;
		}
	}
	
	public void move(int idx, Field f) {
		Card temp = this.arena[idx];
		this.arena[idx] = null;
		f.add(temp);
	}
	
	public void reset() {
		int i;
		for (i=0; i<size; i++) {
			this.arena[i] = null;
		}
	}
	
}
