/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Card;
import com.terserah.yugi.Entities.Field;
import com.terserah.yugi.Entities.Monster;
import com.terserah.yugi.Entities.Player;
import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class DuelState extends GameState {
    public static Board ingame;
    private final Player opp;
            
    public DuelState(GameStateManager gsm) {
        super(gsm);
        opp = DuelistLand.getCurDuelist();
        ingame = new Board(GamePanel.PemainUtama, opp);
    }
    
    public boolean cekCard(Player p, String slug) {
        boolean flag = false;
        for (int i = 0; i< p.getField().getHand().size();i++)
            if (slug.equals(p.getField().getHand().get(i).getSlug()))
                flag = true;
        return flag;
    }
    
    public boolean checkPlayerTurn() {
            return GamePanel.PemainUtama == Card.getBoard().getActivePlayer();
    }
    public void printField(Player p) {
        Field f = p.getField();
        System.out.println("Field " + p.getName());
        System.out.println("Field " + p.getLP());
        System.out.println("Monster Arena");
        if (f.getMonsterArea().size()<1)
            System.out.println("-");
        else
            for (int i = 0 ; i < f.getMonsterArea().size();i++ ) {
                System.out.println(f.getMonsterArea().get(i).getName() +" "+  f.getMonsterArea().get(i).getMode());
                
            }
        System.out.println("Spell/Trap Arena");
        if (f.getSpellTrapArea().size()<1)
            System.out.println("-");
        else
            for (int i = 0 ; i < f.getSpellTrapArea().size();i++ ) {
                System.out.println(f.getSpellTrapArea().get(i).getName());
            }
        System.out.println("Graveyard : " + f.getGraveyard().size());
        System.out.println("Deck : " + f.getDeck().getSize());
        System.out.println("Kartu di tangan");
        if (f.getDeck().getSize()<1)
            System.out.println("-");
        else
            for (int i = 0 ; i < f.getHand().size();i++ ) {
                System.out.println(f.getHand().get(i).getName());
            }
    }


    @Override
    public void draw() {
        while (ingame.getWinner()==null) {
            System.out.println(ingame.getActivePlayer().getName()
                                + " vs " 
                                + ingame.getOppPlayer().getName());

            printField(ingame.getActivePlayer());
            System.out.println("--------");
            printField(ingame.getOppPlayer());
            handleInput();
        }
        if (null!=ingame.getWinner()) {
           gsm.setState(GameStateManager.DUELISTLAND);
        }
    }

    @Override
    public void handleInput() {
        System.out.print ("Pilihan ");
        Monster monster;
        Scanner in = new Scanner(System.in);
        String opt;
        opt = in.nextLine();
        String[] arrOpt ;
        arrOpt = opt.split(" ");
        if (null != arrOpt[0]) switch (arrOpt[0]) {
        case "summon":
            if (null==arrOpt[1]){}
            else if (cekCard(ingame.getActivePlayer(),arrOpt[1])) {
                monster = (Monster) ShopState.allCard.getBySlug(arrOpt[1]);
                if (ingame.getActivePlayer().summonMonster(monster))
                    System.out.println("monster summoned");   
                else 
                    System.out.println("Error occur");

            }
            break;
        case "attack":
            monster = (Monster) ShopState.allCard.getBySlug(arrOpt[1]);
            if (null==arrOpt[1]){}
            else if (ingame.getActivePlayer().getField().getMonsterArea().contains(monster)) {  
                if (ingame.getActivePlayer().directAttack(monster))
                    System.out.println("direct attack");
                else 
                    System.out.println("Error occur");
            }
            break;
        case "set":
            monster = (Monster) ShopState.allCard.getBySlug(arrOpt[1]);
            if (null==arrOpt[1]){}
            else if (cekCard(ingame.getActivePlayer(),arrOpt[1])) {
                if (ingame.getActivePlayer().setMonster(monster))
                    System.out.println("Monster set");   
                else 
                    System.out.println("Error occur");
            }
            break;           
        case "endphase":
            ingame.getActivePlayer().endPhase();
            System.out.println("Fase : " + ingame.getActivePlayer().getField().getPhase());
            break; 
        case "endturn":
            ingame.getActivePlayer().endTurn();
            System.out.println("Ganti Giliran ");
            break; 
        //Later by removes
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
