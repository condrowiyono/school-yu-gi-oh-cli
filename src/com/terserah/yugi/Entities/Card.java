/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import com.terserah.yugi.GameState.Board;
/**
 *
 * @author muhfai
 */
public abstract class Card{

    //attributes
    String name;
	private String description, slug;
        private Location loc;
	private float probability = 0;
        private boolean isHidden;
	//for dueling option
        private static Board board;
        //konstruktor
	
        public Card(String name) {
		this.name = name;
                this.slug = name.replaceAll(" ", "").toLowerCase();
                this.isHidden = true;
        }
	public Card(String name, String description, Location pos, float probability) {
		this.name = name;
		this.description = description;
		this.probability = probability;
                this.slug = name.replaceAll(" ", "").toLowerCase();
                this.isHidden = true;
        }
	public Card(String name, String description, Location pos, float probability, boolean hidden) {
		this.name = name;
		this.description = description;
		this.probability = probability;
                this.slug = name.replaceAll(" ", "").toLowerCase();
                this.isHidden = hidden;
        }
        //setter getter
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
        
        public boolean isHidden() {
		return isHidden;
	}
        public void setHidden(boolean b) {
		isHidden = b;
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
        
    public static void setBoard(Board b) {
		board = b;
	}
        
    public static Board getBoard() {
        return Card.board; 
	} 
        
    public static Field getOppField() {
        return board.getOppPlayer().getField();
    }
        
    public static Field getActiveField() {
        return board.getActivePlayer().getField();
    }
    
    public static void DecreaseLPActive(int n) {
        Card.getBoard().getActivePlayer()
                .setLP(
                Card.getBoard().getActivePlayer().getLP()-n);
    }
    
    public static void DecreaseLPOpp(int n) {
        Card.getBoard().getOppPlayer()
                .setLP(
                Card.getBoard().getOppPlayer().getLP()-n);
    }
}
