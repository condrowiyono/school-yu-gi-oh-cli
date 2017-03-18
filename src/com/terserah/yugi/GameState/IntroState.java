package com.terserah.yugi.GameState;

import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;

public class IntroState extends GameState {
	
	public IntroState(GameStateManager gsm) {
		super(gsm);
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the game.Press Enter");
		handleInput();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String opt;
		opt = in.nextLine();
		if(opt.equals(""))
			gsm.setState(GameStateManager.MENU);
	}

}
