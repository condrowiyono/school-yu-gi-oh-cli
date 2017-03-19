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
public class MainPlayer extends Player{
    private int MONEY;
    
    public MainPlayer(String name) {
        super(name);
        this.MONEY = 2000;
    }
    
    public int getMoney() {
        return this.MONEY;
    }
    public void setMoney(int money) {
        this.MONEY = money;
    }
    
}
