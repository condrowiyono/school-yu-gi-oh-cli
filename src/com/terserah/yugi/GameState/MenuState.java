package com.terserah.yugi.GameState;

import com.terserah.yugi.Main.GamePanel;
import java.util.Scanner;

import com.terserah.yugi.Manager.GameStateManager;

public class MenuState extends GameState {
	
	public MenuState(GameStateManager gsm) {
		super(gsm);
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Yu Gi Oh Game Menu");
		handleInput();
	}
	
	@Override
	public void handleInput() {
            // TODO Auto-generated method stub
            System.out.println("I Info");
            System.out.println("L DuelistLand / Move Character");
            System.out.println("P Pause");
            System.out.println("D Deck");
            System.out.println("B Back");
            System.out.println("Q Exit");
            System.out.print("Pilihan : ");

            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            switch (opt) {
                case "I":
                    System.out.println("Nama = " + GamePanel.getMainPlayer().getName());
                    System.out.println("Money = " + GamePanel.getMainPlayer().getMONEY());
                    System.out.println("Posisi = " + GamePanel.getMainPlayer().getPosisi().getX() + "," + GamePanel.getMainPlayer().getPosisi().getY());
                    System.out.println("List Kartu = ");
                    for (int i = 0 ; i < GamePanel.PemainUtama.getAllCard().getSize(); i++ )
                        System.out.println(GamePanel.PemainUtama.getAllCard().get(i).getSlug()
                                            + "\t \t" + GamePanel.PemainUtama.getAllCard().get(i).getName());
                    break;
                case "P":
                    gsm.setPaused(true);
                    break;
                case "Q":
                    System.exit(0);
                case "L":
                    gsm.setState(GameStateManager.DUELISTLAND);
                    break;
                case "B":
                    gsm.setState(GameStateManager.INTRO);
                    break;
                case "D":
                    gsm.setState(GameStateManager.DECK);
                    break;
                 case "C":
                    //CardDeck
                    break;   
                default:
                    break;
            }
		
	}


}
