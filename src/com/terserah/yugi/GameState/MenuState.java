package com.terserah.yugi.GameState;

import java.util.Scanner;

import com.terserah.yugi.Manager.GameStateManager;

public class MenuState extends GameState {
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Ini main menu");
		System.out.println("M. Main");
		System.out.println("exit");
		handleInput();
	}
	
	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String opt;
		opt = in.nextLine();
		if(opt.equals("M")) {
			System.out.println("Main game");
		} else if(opt.equals("P")) {
			gsm.setPaused(true);
		} else if (opt.equals("exit")) {
			System.exit(0);
		}
		
	}


}
