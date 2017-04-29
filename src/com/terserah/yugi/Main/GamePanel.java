package com.terserah.yugi.Main;

import com.terserah.yugi.Entities.Deck;
import com.terserah.yugi.Entities.MainPlayer;
import com.terserah.yugi.GameState.ShopState;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.ArrayList;

public class GamePanel implements Runnable {
	
		private GameStateManager gsm;
		public boolean running;
                public static MainPlayer PemainUtama;
		public static ArrayList<MainPlayer> semuaPemain = new ArrayList<MainPlayer>();
 
		public  GamePanel() {
			run();
		}
                
                public static void createPlayer(String name){
                    GamePanel.PemainUtama = new MainPlayer(name, Deck.getRandCard(15));
                    GamePanel.PemainUtama.getDeck().addToDeck(ShopState.allCard.getBySlug("traphole"));
                    GamePanel.PemainUtama.setPlayerDeck(Deck.getRandCard(11));
                }
                
                public static MainPlayer getMainPlayer() {
                    return GamePanel.PemainUtama;
                }
                
                @Override
		public final void run() {
			running = true;
			gsm = new GameStateManager();
			while(running) {
				gsm.draw();
			}
		}
		
}
