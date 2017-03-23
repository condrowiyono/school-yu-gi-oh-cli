/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import java.util.ArrayList;

/**
 *
 * @author DELL-PC
 */
public class CardEffect {
    
    //aksi di kartu monster
    public static void actionMonsterEffect(Monster monster, Monster opp) {
        switch (monster.getSlug()) {
            case "hane-hane" :
                System.out.println("Hane - hane activated");
                break;
            case "man-eaterbug":
                System.out.println("man eater bug ativated");
                break;
            default :
                break;
        }
    }
    
    //aksi effect di kartu spell
    public static void actionSpell(Spell spell, Monster opp) {
        switch (spell.getSlug()) {
            case "fissure":
                System.out.println("fisure activated");
                break;
            case "stopdefense" :
                System.out.println("Sto defense activated");
                break;
            default :
                break;
                      
        }
    }
    // FOLLOW WIND 
    public static void actionSpell(Spell spell, ArrayList<Monster> arrmonster) {
        switch (spell.getSlug()) {
            case "followwind":
                System.out.println("follow wind activated");
                break;
            default :
                break;
                      
        }
    }
    
    public static void actionTrap(Trap trap, Monster monster ) {
        switch (trap.getSlug()) {
            case "negateattack":
                System.out.println("Negate attack activated");
                break;
            case "traphole" :
                System.out.println("traphole activated");
                break;
            default :
                break;
                      
        }          
    }
    
    //untuk mirror force
    public static void actionTrap(Trap trap, ArrayList<Monster> monster) {
        switch (trap.getSlug()) {
            case "mirrorforce":
                System.out.println("mirror force");
                break;
            default :
                break;
                      
        }       
    }
}
