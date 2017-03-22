package com.terserah.yugi.Main;

import com.terserah.yugi.Entities.Deck;
import com.terserah.yugi.Entities.Duelist;
import com.terserah.yugi.GameState.DuelistLand;
import com.terserah.yugi.GameState.ShopState;
import com.terserah.yugi.Manager.JSONManager;
import java.util.Random;
public class Game {
    /* 
    GENERATE DUELIST 
    private static void generateDuelist() {
        DuelistLand.arrDuelist.add(new Duelist("Yugi Mutou",2,3,"Elite Duelist",Game.getRandCard(10) ));
        DuelistLand.arrDuelist.add(new Duelist("Anzu Mazaki",8,7,"King Of Game",Game.getRandCard(10) ));
        JSONManager.exportDuelist();
    }
    */
    public static Deck getRandCard(int n) {
        Deck deck = new Deck();
        Random rand = new Random(); 

        for (int i=1;i<=n;i++) {
            int value = rand.nextInt(ShopState.allCard.getSize());
            deck.addToBottom(ShopState.allCard.get(value));
        }

        return deck;
    }
            
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
