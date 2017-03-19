/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

/**
 *
 * @author condro
 */


public class Player {
   private String NAME;
   private Deck PLAYERDECK;
   private Point POSISI;
   
   public Player(String name) {
       this.NAME = name;
       Point newPos = new Point(5,5);
       this.POSISI = newPos;
   }
   
   public Player(String name, int x, int y) {
       this.NAME = name;
       Point newPos = new Point(x,y);
       this.POSISI = newPos;
   }
   
   public String getName() {
       return this.NAME;
   };
   
   public Point getPosisi() {
       return this.POSISI;
   }
   
   public void setPosisi(int x, int y) {
       this.POSISI.setX(x);
       this.POSISI.setY(y);
   }

}
