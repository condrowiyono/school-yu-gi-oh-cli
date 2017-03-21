package com.terserah.yugi.Main;

import com.terserah.yugi.GameState.ShopState;
import com.terserah.yugi.Manager.GameStateManager;
import com.terserah.yugi.Manager.FileManager;
import com.terserah.yugi.Manager.JSONManager;
public class Game {

	public static void main(String[] args){
                JSONManager.importDuelist();
                JSONManager.exportCard();
                JSONManager.importCard();
                JSONManager.loadPlayer();
                //Start the game
		GamePanel a = new GamePanel();
                //JSONManager.exportDuelist();
                
                
        }
	
}
