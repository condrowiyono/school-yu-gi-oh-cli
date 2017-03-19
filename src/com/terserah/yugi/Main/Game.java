package com.terserah.yugi.Main;

import com.terserah.yugi.Manager.GameStateManager;
import com.terserah.yugi.Manager.FileManager;
import com.terserah.yugi.Manager.JSONManager;
public class Game {

	public static void main(String[] args){
		//GamePanel a = new GamePanel();
                /* 
                FileManager.Baca();
                FileManager.getLine(0);
                FileManager.getLine(1);
                FileManager.getLine(2);
                FileManager.getLine(3);
                */
                JSONManager.exportCard();
                JSONManager.importCard();
	}
	
}
