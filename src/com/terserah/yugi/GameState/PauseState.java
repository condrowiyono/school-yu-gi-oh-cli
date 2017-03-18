package com.terserah.yugi.GameState;

import java.util.Scanner;

import com.terserah.yugi.Manager.GameStateManager;

public class PauseState extends GameState {
	
	public PauseState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void draw() {
		System.out.println("Menu Pause");
		System.out.println("Bla bla bla");
		handleInput();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String opt;
		opt = in.nextLine();
		if(opt.equals("P")) {
			gsm.setPaused(false);
		} 
	}

}
