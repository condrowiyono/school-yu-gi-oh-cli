/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Ais;
import com.terserah.yugi.Entities.Card;
import com.terserah.yugi.Entities.Field;
import com.terserah.yugi.Entities.Mode;
import com.terserah.yugi.Entities.Monster;
import com.terserah.yugi.Entities.Player;
import com.terserah.yugi.Entities.Spell;
import com.terserah.yugi.Entities.Trap;
import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class DuelState extends GameState {
    public static Board ingame;
            
    public DuelState(GameStateManager gsm) {
        super(gsm);
    }
    public boolean cekMonsterArea(Player p, String slug) {
        boolean found = false;
        int i = 0;
        while (i < p.getField().getMonsterArea().size() && !found ) 
             if (slug.equals(p.getField().getMonsterArea().get(i).getSlug()))
                 found = true;
             else 
                 i++;
        return found;
    }
    public boolean cekCard(Player p, String slug) {
        boolean found = false;
        int i = 0;
        while (i < p.getField().getHand().size() && !found ) 
             if (slug.equals(p.getField().getHand().get(i).getSlug()))
                 found = true;
             else 
                 i++;
        return found;
    }
    public void printField() {
        Field f1 = ingame.getActivePlayer().getField();
        Field f2 = ingame.getOppPlayer().getField();
        System.out.format("%6s", ingame.getOppPlayer().getName());
        System.out.format(" ( LP : %4d )\n", ingame.getOppPlayer().getLP());
        for (int i=0; i < f2.getHand().size();i++) {
            System.out.format("[ ] " );
        }
        System.out.format("\n[%2d]   ", f2.getDeck().getSize());
        int remaining = 3 - f2.getSpellTrapArea().size();
        for (Card spellTrapArea : f2.getSpellTrapArea()) {
            System.out.format("[-] " );
        }
        for (int i=0; i<remaining;i++) {
            System.out.format("[ ] " );
        }
        System.out.println();
        System.out.format("[%2d]   ", f2.getGraveyard().size());
        remaining = 3 - f2.getMonsterArea().size();
        for (int i = 0 ; i < f2.getMonsterArea().size(); i++) {
            if (Mode.DEFENSE.equals(f2.getMonsterArea().get(i).getMode()))
                System.out.format("[-] " );
            else if (Mode.ATTACK.equals(f2.getMonsterArea().get(i).getMode()))
                System.out.format("[*] " );
        }
        for (int i=0; i<remaining;i++) {
            System.out.format("[ ] " );
        }
        System.out.println("\n------------------");
        System.out.format("[%2d]   ", f1.getGraveyard().size());
        remaining = 3 - f1.getMonsterArea().size();
        
        for (int i = 0 ; i < f1.getMonsterArea().size(); i++) {
            if (Mode.DEFENSE.equals(f1.getMonsterArea().get(i).getMode()))
                System.out.format("[-] " );
            else if (Mode.ATTACK.equals(f1.getMonsterArea().get(i).getMode()))
                System.out.format("[*] " );
        }
        for (int i=0; i<remaining;i++) {
            System.out.format("[ ] " );
        }
        System.out.println();
        System.out.format("[%2d]   ", f1.getDeck().getSize());
        remaining = 3 - f1.getSpellTrapArea().size();
        for (Card spellTrapArea : f1.getSpellTrapArea()) {
            System.out.format("[-] " );
        }
        for (int i=0; i<remaining;i++) {
            System.out.format("[ ] " );
        }
        System.out.println();
        for (int i=0; i<f1.getHand().size();i++) {
            System.out.format("[ ] " );
        }
        System.out.println();
        System.out.format("%6s", ingame.getActivePlayer().getName());
        System.out.format(" ( LP : %4d )\n", ingame.getActivePlayer().getLP());
        
    }
    public void printNameOnField(){
        System.out.format("Kartu Di Tangan \n");
        for (int i = 0 ; i < ingame.getActivePlayer().getField().getHand().size();i++) 
            System.out.format("%2d (%-1s) %s \n", 
                    i, 
                    ingame.getActivePlayer().getField().getHand().get(i).getJenis(),
                    ingame.getActivePlayer().getField().getHand().get(i).getName());
        System.out.format("Kartu Di Monster Area \n");
        for (int i = 0 ; i < ingame.getActivePlayer().getField().getMonsterArea().size();i++) 
        System.out.format("%2d (%-1s) %s \n", 
                    i, 
                    ingame.getActivePlayer().getField().getMonsterArea().get(i).getJenis(),
                    ingame.getActivePlayer().getField().getMonsterArea().get(i).getName());
        System.out.format("Kartu Di Spell/Trap Area \n");
        for (int i = 0 ; i < ingame.getActivePlayer().getField().getSpellTrapArea().size();i++) 
        System.out.format("%2d (%-1s) %s \n", 
                    i, 
                    ingame.getActivePlayer().getField().getSpellTrapArea().get(i).getJenis(),
                    ingame.getActivePlayer().getField().getSpellTrapArea().get(i).getName());
    }
    public void printOppOnField(){
        Field field = ingame.getOppPlayer().getField();
        System.out.format("Opponent \n");
        System.out.format("Kartu Di Monster Area \n");
        for (int i = 0 ; i < field.getMonsterArea().size();i++)  {
        if ((field.getMonsterArea().get(i)).getMode()==(Mode.ATTACK))
            System.out.format("%2d (%-1s) %s \n", 
                        i, 
                        field.getMonsterArea().get(i).getJenis(),
                        field.getMonsterArea().get(i).getName());
        else if ((field.getMonsterArea().get(i)).getMode()==(Mode.DEFENSE))
            System.out.format("%2d %-1s \n", i, "Placed" );        
        }
        System.out.format("Kartu Di Spell/Trap Area \n");
        for (int i = 0 ; i < field.getSpellTrapArea().size();i++) 
        System.out.format("%2d %-1s \n", i, "Placed" );
    }
    @Override
    public void draw() {
        while (ingame.getWinner()==null) {
            System.out.println(ingame.getActivePlayer().getName()
                                + " vs " 
                                + ingame.getOppPlayer().getName());
            
            handleInput();
            if ((GamePanel.PemainUtama).equals(ingame.getOppPlayer())) {
                printField(); 
                Ais.init();
                Ais.attack();
                Ais.last();
            }
            printField(); 
        }
        if (null!=ingame.getWinner()) {
            gsm.setState(GameStateManager.WIN);
        }
    }

    @Override
    public void handleInput() {
        printField(); 
        Player actPlayer = ingame.getActivePlayer();
        Player oppPlayer = ingame.getOppPlayer();
        System.out.print (actPlayer.getName()+" "+ actPlayer.getField().getPhase()+ " >");
        Monster monster;
        Scanner in = new Scanner(System.in);
        String opt;
        opt = in.nextLine();
        String[] arrOpt ;
        arrOpt = opt.split(" ");
        if (null != arrOpt[0]) switch (arrOpt[0]) {
        case "summon":
            if (arrOpt.length<=1){
                System.out.println("Input Error");
            break;}
            else { 
                int i = Integer.parseInt(arrOpt[1]);
                if (cekCard(actPlayer,arrOpt[1]) || (i<=actPlayer.getField().getHand().size())) {
                    if (cekCard(actPlayer,arrOpt[1])) 
                        monster = (Monster) ShopState.allCard.getBySlug(arrOpt[1]);
                    else monster = (Monster) actPlayer.getField().getHand().get(i);
                if ("Monster".equals(monster.getJenis()))
                    if (monster.getLevel()<5)
                        if (actPlayer.summonMonster(monster))
                            System.out.println("Monster summoned");   
                        else System.out.println("Error occur 1");
                    else if ((monster.getLevel() ==5 ||
                             monster.getLevel() ==6) &&
                             actPlayer.getField().getMonsterArea().size()>0) {
                        ArrayList<Monster> monstertribute = new ArrayList<Monster>();
                        System.out.println("Tribute Monster");
                        for (int j=0; j < actPlayer.getField().getMonsterArea().size();j++)
                            System.out.format("%2d : %s \n", j, actPlayer.getField().getMonsterArea().get(j).getName());
                        System.out.print("Tribute ");
                        int trib = Integer.parseInt(in.nextLine());
                        if (trib<=actPlayer.getField().getMonsterArea().size())
                        {
                            monstertribute.add(actPlayer.getField().getMonsterArea().get(trib));
                            if (actPlayer.summonMonster(monster,monstertribute))
                                System.out.println("Monster summoned");   
                            else System.out.println("Error occur 2");
                        }  
                    } else if (monster.getLevel() >=7 &&
                        actPlayer.getField().getMonsterArea().size()>=2) {
                        ArrayList<Monster> monstertribute = new ArrayList<Monster>();
                        System.out.println("Tribute Monster");
                        for (int j=0; j < actPlayer.getField().getMonsterArea().size();j++)
                            System.out.format("%2d : %s \n", j, actPlayer.getField().getMonsterArea().get(j).getName());
                        System.out.print("Tribute 1: ");
                        int trib1 = Integer.parseInt(in.nextLine());
                        System.out.print("Tribute 2: ");
                        int trib2 = Integer.parseInt(in.nextLine());
                        if (trib1<=actPlayer.getField().getMonsterArea().size() &&
                            trib2<=actPlayer.getField().getMonsterArea().size())
                        {
                            monstertribute.add(actPlayer.getField().getMonsterArea().get(trib1));
                            monstertribute.add(actPlayer.getField().getMonsterArea().get(trib2));
                            if (actPlayer.summonMonster(monster,monstertribute))
                                System.out.println("Monster summoned. tribute " + monstertribute.size());   
                            else System.out.println("Error occur");
                        }    
                    }
                else System.out.println("Not monster");
                }
            }
            break;
        
        case "attack":
            if (arrOpt.length<2) {
                System.out.println("Input Error");
                break;
            }
            else {
                //attack on monster
                if (arrOpt.length==3) {
                    int i = Integer.parseInt(arrOpt[1]);
                    int j = Integer.parseInt(arrOpt[2]);
                    if (i <=actPlayer.getField().getMonsterArea().size() &&
                        i <=oppPlayer.getField().getMonsterArea().size()) {
                        Monster actMonster = (Monster) actPlayer.getField().getMonsterArea().get(i); 
                        Monster oppMonster = (Monster) oppPlayer.getField().getMonsterArea().get(j);
                        if (actPlayer.attack(actMonster, oppMonster))
                            System.out.println("Attack");   
                        else 
                            System.out.println("Error occur");
                    }
                } else 
                if (arrOpt.length==2) {
                //direct attack
                    int i = Integer.parseInt(arrOpt[1]);
                    if (i <=actPlayer.getField().getMonsterArea().size()) {
                        monster = (Monster) actPlayer.getField().getMonsterArea().get(i);
                        if ("Monster".equals(monster.getJenis())) {
                            if (actPlayer.directAttack(monster))
                                System.out.println("Direct Attack");   
                            else 
                                System.out.println("Error occur");
                        }
                    }
                }   
            break;
            }
        case "set":
            if (arrOpt.length<=1){
                System.out.println("Input Error");
            break;}
            else {
                int i = Integer.parseInt(arrOpt[1]);
                
                if (i <=actPlayer.getField().getHand().size()) {
                    monster = (Monster) actPlayer.getField().getHand().get(i);
                    if ("Monster".equals(monster.getJenis())) 
                    if (actPlayer.setMonster(monster))
                        System.out.println("monster set");   
                    else 
                        System.out.println("Error occur");
                else System.out.println("Not monster");
                }
            }
            break;

        case "flip":
            if (arrOpt.length<=1){
                System.out.println("Input Error");
            break;}
            else {
                int i = Integer.parseInt(arrOpt[1]);
                if (i>actPlayer.getField().getMonsterArea().size()) {
                    System.out.println("Salah input");
                } else {
                    monster = (Monster) actPlayer.getField().getMonsterArea().get(i);
                    if (i <=actPlayer.getField().getMonsterArea().size()) {
                    if ("Monster".equals(monster.getJenis())) 
                        if (actPlayer.switchMonsterPosition(monster))
                            System.out.println("monster flipped");   
                        else 
                            System.out.println("Error occur");
                    else System.out.println("Not monster");
                    }
                }
            }
            break;  
        case "place":
            Spell spell;
            if (arrOpt.length<=1){
                System.out.println("Input Error");
            break;}

            else {
                int i = Integer.parseInt(arrOpt[1]);
                if (i <=actPlayer.getField().getHand().size()) {
                    spell = (Spell) actPlayer.getField().getHand().get(i);
                    if ("Spell".equals(spell.getJenis())) 
                    if (actPlayer.setSpell(spell))
                        System.out.println("spell placed");   
                    else 
                        System.out.println("Error occur");
                else System.out.println("Not spell");
                }
            }
            break;
        case "trap":
            Trap trap;
            if (arrOpt.length<=1){
                System.out.println("Input Error");
            break;}

            else {
                int i = Integer.parseInt(arrOpt[1]);
                if (i <=actPlayer.getField().getHand().size()) {
                    trap = (Trap) actPlayer.getField().getHand().get(i);
                    if ("Trap".equals(trap.getJenis())) 
                    if (actPlayer.setTrap(trap))
                        System.out.println("trap placed");   
                    else 
                        System.out.println("Error occur");
                else System.out.println("Not a Trap");
                }
            }
            break;
        case "use":
            if (arrOpt.length<=1){
                System.out.println("Input Error");
            break;}
            else {
                int i = Integer.parseInt(arrOpt[1]);
                if (i <=actPlayer.getField().getSpellTrapArea().size()) {
                    spell = (Spell) actPlayer.getField().getSpellTrapArea().get(i);
                    if (actPlayer.activateSpell(spell))
                        System.out.println("spell activated");   
                    else 
                        System.out.println("Error occur");
               
                }
            }
            break;
        case "endphase":
            ingame.getActivePlayer().endPhase();
            System.out.println("Fase : " + ingame.getActivePlayer().getField().getPhase());
            break; 
        case "endturn":
            System.out.println("Ganti Giliran ");
            ingame.getActivePlayer().endTurn();
            break; 
        case "listname":
            printOppOnField();
            printNameOnField();
            break; 
        //Later be removed
        case "0":
        case "back":
            GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()+1);
            gsm.setState(GameStateManager.DUELISTLAND);
            break;
        default:
            break;
        }           
    }
}
