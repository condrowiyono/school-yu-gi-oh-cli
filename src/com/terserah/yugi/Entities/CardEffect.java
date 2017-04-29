package com.terserah.yugi.Entities;

import com.terserah.yugi.GameState.DuelState;
import com.terserah.yugi.GameState.ShopState;
import java.util.ArrayList;

/**
 *
 * @author DELL-PC
 */
public class CardEffect {
        public static void actionMonsterEffect(Monster monster, Monster opp) {
             switch (monster.getSlug()) {
                 case "hane-hane" :
                     if (monster.getMode()==Mode.DEFENSE)
                        if (DuelState.ingame.getActivePlayer().getField().getHand().size()>5) {
                            opp.setLoc(Location.HAND);
                            DuelState.ingame.getActivePlayer().getField().getHand().add(opp);
                            DuelState.ingame.getActivePlayer().getField().getMonsterArea().remove(opp);
                        } else DuelState.ingame.getActivePlayer().getField().removeMonsterToGraveyard(opp);
                     break;
                 case "man-eaterbug":
                     if (monster.getMode()==Mode.DEFENSE)
                         DuelState.ingame.getActivePlayer().getField().removeMonsterToGraveyard(opp);
                     break;
                 default :
                     break;
             }
         }
         
         public static void actionEquib(Spell spell) {
            ArrayList<Monster> arena = DuelState.ingame.getOppPlayer().getField().getMonsterArea(); 
            if (!arena.isEmpty()) {
                for (int i=1;i < arena.size();i++)
                    if (arena.get(i).getSlug().equals("tyhone") ||
                        arena.get(i).getSlug().equals("harpielady")) {
                            arena.get(i).setATK(arena.get(i).getATK()+300);
                            arena.get(i).setDEF(arena.get(i).getDEF()+300);
                    }
            }
         }
           //aksi effect di kartu spell
         public static void actionSpell(Spell spell) {
             ArrayList<Monster> arena = DuelState.ingame.getOppPlayer().getField().getMonsterArea();
             switch (spell.getSlug()) {
                 case "fissure":
                        if (!arena.isEmpty()) {
                            int min = arena.get(0).getATK();
                            int idx = 0;
                            for (int i=1;i < arena.size();i++)
                                if (min>arena.get(i).getATK() ) {
                                        min=arena.get(i).getATK();
                                        idx = i;
                                }
                            DuelState.ingame.getOppPlayer().getField().removeMonsterToGraveyard(arena.get(idx));
                        }     
                 break;
                 case "stopdefense" :
                        arena = DuelState.ingame.getOppPlayer().getField().getMonsterArea(); 
                        if (!arena.isEmpty()) {
                            for (int i=1;i < arena.size();i++)
                                if (arena.get(i).getMode() == (Mode.DEFENSE))
                                        arena.get(i).setMode(Mode.ATTACK);
                        }
                 break;
                 default :
                     break;

             }
         }

         public static boolean actionTrapHole() {
             Trap trap = (Trap) ShopState.allCard.getBySlug("traphole");
             return (DuelState.ingame.getOppPlayer().getField().getSpellTrapArea().contains(trap));
         }

         //untuk mirror force
         public  static void actionTrap(Trap trap, ArrayList<Monster> monster) {
             switch (trap.getSlug()) {
                 case "mirrorforce":
                     System.out.println("mirror force");
                     break;
                 default :
                     break;

             }       
         }
}
