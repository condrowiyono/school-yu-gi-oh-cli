/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import static com.terserah.yugi.GameState.DuelState.ingame;

/**
 *
 * @author DELL-PC
 */
public class Ais {
    public static void last () {
        ingame.isAnyWinner();
         if (ingame.getActivePlayer().getField().getHand().size()>=5) {
                    ingame.getActivePlayer().getField().removeHand(
                    ingame.getActivePlayer().getField().getHand().get(0));
                    ingame.getActivePlayer().getField().addNCardsToHand(1);
                }
                ingame.getActivePlayer().endTurn();
    }
    
    public static void init() {
        Player oppPlayer =  ingame.getActivePlayer();
        boolean flag = false;
        for (int i = 0; i < oppPlayer.getField().getHand().size();i++) {
            if ("Monster".equals(oppPlayer.getField().getHand().get(i).getJenis()))
            {
                Monster monster = (Monster) oppPlayer.getField().getHand().get(i);
                if (oppPlayer.summonMonster(monster)) {
                    break;
                }
            }
        }
    }
    public static void attack() {
        Player oppPlayer = ingame.getOppPlayer();
        Player actPlayer = ingame.getActivePlayer();
        
        if (actPlayer.getField().getPhase() == Phase.MAIN1)
                actPlayer.getField().setPhase(Phase.BATTLE);
        else if (actPlayer.getField().getPhase() == Phase.BATTLE)
                actPlayer.getField().setPhase(Phase.MAIN2);
        
                
        if (!actPlayer.getField().getMonsterArea().isEmpty()) {
            Monster dirisendiri = actPlayer.getField().getMonsterArea().get(0);
            if (ingame.getOppPlayer().getField().getMonsterArea().isEmpty()) {
                actPlayer.directAttack(dirisendiri);
            } else {
                Monster lawannya = oppPlayer.getField().getMonsterArea().get(0);
                actPlayer.attack(dirisendiri, lawannya);
            } 
        }
        ingame.isAnyWinner();
    }
}
