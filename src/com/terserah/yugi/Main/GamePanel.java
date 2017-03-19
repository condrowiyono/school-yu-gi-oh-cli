package com.terserah.yugi.Main;

import com.terserah.yugi.Entities.MainPlayer;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;

public class GamePanel implements Runnable {
	
		private GameStateManager gsm;
		public boolean running;
                public static MainPlayer PemainUtama;
		
 
		public  GamePanel() {
			run();
		}
                public static void createPlayer(String name){
                        GamePanel.PemainUtama = new MainPlayer(name);
                }
                
                public static MainPlayer getMainPlayer() {
                    return GamePanel.PemainUtama;
                }
                
                @Override
		public void run() {
			running = true;
			gsm = new GameStateManager();
			while(running) {
				gsm.draw();
			}
		}
		
}
