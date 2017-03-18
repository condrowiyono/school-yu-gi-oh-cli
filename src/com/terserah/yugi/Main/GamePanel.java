package com.terserah.yugi.Main;

import com.terserah.yugi.Manager.GameStateManager;

public class GamePanel implements Runnable {
	
		private GameStateManager gsm;
		public boolean running;
		
		public  GamePanel() {
			run();
		}
		public void run() {
			running = true;
			gsm = new GameStateManager();
			while(running) {
				gsm.draw();
			}
		}
		
}
