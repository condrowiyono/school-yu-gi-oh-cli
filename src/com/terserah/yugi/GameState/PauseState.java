package com.terserah.yugi.GameState;

import java.util.Scanner;
import com.terserah.yugi.Manager.GameStateManager;

public class PauseState extends GameState {
	
	public PauseState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void draw() {
                System.out.println("Menu Pause");
		handleInput();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		System.out.println("R Resume");
                System.out.println("S Save");
                System.out.println("Q Exit");
                System.out.println("C Card Deck");
                System.out.print("Pilihan : ");
		Scanner in = new Scanner(System.in);
		String opt;
		opt = in.nextLine();
                switch (opt) {
                case "R":
                    gsm.setPaused(false);
                    break;
                case "Q":
                    System.exit(0);
                case "S":
                    //Save
                    break;
                 case "C":
                    gsm.setState(GameStateManager.DECK);
                    break;   
                default:
                    break;
            }

	}

}
