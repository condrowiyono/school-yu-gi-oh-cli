package com.terserah.yugi.Main;

import com.terserah.yugi.Entities.Deck;
import com.terserah.yugi.Entities.Duelist;
import com.terserah.yugi.GameState.DuelistLand;
import com.terserah.yugi.GameState.ShopState;
import com.terserah.yugi.Manager.JSONManager;
import java.util.Random;
public class Game {
            
    public static void main(String[] args){
    //Card Manager        
    //JSONManager.exportCard();
        JSONManager.importCard();
        //buat duelist
        //deck standar duelist
        JSONManager.importDuelist();
        JSONManager.loadPlayer();
        //Start the engine
        GamePanel a = new GamePanel();


    }

	
}
