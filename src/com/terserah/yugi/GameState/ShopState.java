/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Entities.Card;
import com.terserah.yugi.Entities.Monster;
import com.terserah.yugi.Entities.Spell;
import com.terserah.yugi.Entities.Trap;
import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class ShopState extends GameState {

    public ShopState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void draw() {
        System.out.println("SHOP");
        
        //GOES HERE
        handleInput();
    }

    @Override
    public void handleInput() {
            
    }
    
    public void handeInput(ArrayList<Card> initialDeck) {
        System.out.println("Apakah anda ingin membeli pack?");
            System.out.println("0 Tidak");
            System.out.println("1 Iya");
            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            switch (opt) {
                case "1":
                    int z;
                    for (z =1; z == 3; z++){
                        Random rand = new Random();
                        int v = rand.nextInt(99);
                        if ((v >=0) && (v <= 1)) {
                            initialDeck.add(new Monster("Blue-Eyes White Dragon","This legendary dragon is a powerful engine of destruction. Virtually invincible, very few have faced this awesome creature","monster", (float) 0.02,3000,2500,8,"Light","Dragon","null"));      
                        }
                        else if ((v >=2) && (v <= 8)) {
                            initialDeck.add(new Monster("Celtic Guardian","An elf who learned to wield a sword, he baffles enemies with lightning swift attacks.","monster", (float) 0.07,1400,1200,4,"Earth","Warrior","null"));      
                        }
                        else if ((v >=9) && (v <= 14)) {
                            initialDeck.add(new Monster("Tyhone","Capable of firing cannonballs from its mouth for long-range attacks, this creature is particularly effective in mountain battles.","monster", (float) 0.06,1200,1400,4,"Earth","Winged Beast","null"));      
                        } 
                        else if ((v >=15) && (v <= 24)) {
                            initialDeck.add(new Monster("Hane-Hane","FLIP : Select 1 monster on the field and return it to its ownerfs hand.","monster", (float) 0.10,450,500,2,"Earth","Beast","null"));      
                        } 
                        else if ((v >=25) && (v <= 34)) {
                            initialDeck.add(new Monster("Man-Eater Bug","FLIP: Target 1 monster on the field, destroy that target.","monster", (float) 0.10,450,500,2,"Earth","Insect","null"));      
                        }
                        else if ((v >=35) && (v <= 40)) {
                            initialDeck.add(new Monster("Turtle Tiger","A tiger encased in a protective shell that attack with razor-sharp fangs.","monster", (float) 0.06,1000,1500,4,"Water","Aqua","null"));      
                        }
                        else if ((v >=41) && (v <= 46)) {
                            initialDeck.add(new Monster("Harpie Lady","This human-shaped animal with wings is beautiful to watch but deadly in battle.","monster", (float) 0.06,1300,1400,4,"Wind","Winged Beast","null"));      
                        }
                        else if ((v >=47) && (v <= 50)) {
                            initialDeck.add(new Monster("Curse of Dragon","A wicked dragon that taps into dark forces to execute a powerful attack.","monster", (float) 0.04,2000,1500,5,"Dark","Dragon","null"));      
                        }
                        else if ((v >=51) && (v <= 57)) {
                            initialDeck.add(new Spell("Fissure","Destroy the 1 face-up monster your opponent controls that has the lowest ATK (your choice, if tied).","spell", (float) 0.07,"null"));      
                        }
                        else if ((v >=51) && (v <= 57)) {
                            initialDeck.add(new Spell("Fissure","Destroy the 1 face-up monster your opponent controls that has the lowest ATK (your choice, if tied).","spell", (float) 0.07,"null"));      
                        }
                        else if ((v >=58) && (v <= 65)) {
                            initialDeck.add(new Spell("Change of Heart","Select and control 1 opposing monster (regardless of position) on the field until the end of your turn.","spell", (float) 0.07,"null"));      
                        }
                        else if ((v >=66) && (v <= 72)) {
                            initialDeck.add(new Spell("Stop Defense","Select 1 Defense Position monster on your opponentfs side of the field and charge it to Attack Position.","spell", (float) 0.07,"null"));      
                        }
                        else if ((v >=73) && (v <= 79)) {
                            initialDeck.add(new Spell("Follow Wind","Increase the ATK and DEF of a Winged-Beast-Type monster equipped with this card by 300 points.","spell", (float) 0.07,"null"));      
                        }

                        else if ((v >=80) && (v <= 86)) {
                            initialDeck.add(new Trap("Negate Attack","When an opponents monster declares an attack: Target the attacking monster; negate the attack, then end the Battle Phase.","spell", (float) 0.07,"null"));      
                        }
                        else if ((v >=87) && (v <= 94)) {
                            initialDeck.add(new Trap("Trap Hole","When your opponent Normal or Flip Summons 1 monster with 1000 or more ATK: Target that monster; destroy that target.","spell", (float) 0.07,"null"));      
                        }
                        else if ((v >=94) && (v <= 99)) {
                            initialDeck.add(new Trap("Mirror Force","When an opponent's monster declares an attack: Destroy all Attack Position monsters your opponent controls.","spell", (float) 0.07,"null"));      
                        }
                    }
                    
                case "0":
                    GamePanel.getMainPlayer().setPosisi(GamePanel.getMainPlayer().getPosisi().getX(),GamePanel.getMainPlayer().getPosisi().getY()+1);
                    gsm.setState(GameStateManager.DUELISTLAND);
                    break;
                default:
                    break;
            }
    }
    
}
