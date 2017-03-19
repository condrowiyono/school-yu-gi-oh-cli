/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Manager.GameStateManager;

/**
 *
 * @author condro
 */
public class DeckState extends GameState {

    public DeckState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void draw() {
        System.out.println("DECK");
        //ANOTHER GOES HERE
        handleInput();    
    }

    @Override
    public void handleInput() {
    }
    
}
