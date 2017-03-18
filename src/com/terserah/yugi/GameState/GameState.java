//GameState

package com.terserah.yugi.GameState;

import com.terserah.yugi.Manager.GameStateManager;

public abstract class GameState {
	protected GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	public abstract void draw();
	public abstract void handleInput();
	
}
