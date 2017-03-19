package com.terserah.yugi.Manager;

import com.terserah.yugi.GameState.*;

public class GameStateManager {
	private boolean paused;
	private PauseState pauseState;
	
	private GameState[] gameStates;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 8;
	public static final int INTRO = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	public static final int DUELISTLAND = 3;
        public static final int DUEL = 4;
        public static final int SHOP = 5;
        public static final int DECK = 6;
        public static final int GAMEOVER = 7;

	public GameStateManager() {
		paused = false;
		pauseState = new PauseState(this);
		
		gameStates = new GameState[NUM_STATES];
		setState(INTRO);
	}
	
	public void setState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
                switch (i) {
                    case INTRO:
                        gameStates[i] = new IntroState(this);
                        gameStates[i].draw();
                        break;
                    case MENU:
                        gameStates[i] = new MenuState(this);
                        gameStates[i].draw();
                        break;
                    case DUELISTLAND:
                        gameStates[i] = new DuelistLand(this);
                        gameStates[i].draw();
                        break; 
                    case DUEL:
                        gameStates[i] = new DuelState(this);
                        gameStates[i].draw();
                        break; 
                    case DECK:
                        gameStates[i] = new DeckState(this);
                        gameStates[i].draw();
                        break; 
                    case SHOP:
                        gameStates[i] = new ShopState(this);
                        gameStates[i].draw();
                        break; 
                    default:
                        break;
                }
	}
	
	public void unloadState(int i) {
		gameStates[i] = null;
	}
	
	public void setPaused(boolean b) {
		paused = b;
	}
	
	public void draw() {
		if(paused) {
			pauseState.draw();
		}
		else if(gameStates[currentState] != null) {
            
			gameStates[currentState].draw();
		}
	}
}
