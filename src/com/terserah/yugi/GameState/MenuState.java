package com.terserah.yugi.GameState;

import com.terserah.yugi.Main.GamePanel;
import java.util.Scanner;

import com.terserah.yugi.Manager.GameStateManager;
import com.terserah.yugi.Manager.JSONManager;

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
            System.out.println("i info");
            System.out.println("l land / m move");
            System.out.println("s save");
            System.out.println("sm savemanager");
            System.out.println("d deck");
            System.out.println("b back");
            System.out.println("q exit");
            System.out.print("Pilihan : ");

            Scanner in = new Scanner(System.in);
            String opt;
            opt = in.nextLine();
            switch (opt) {
                case "i":
                case "info" :
                    System.out.println("Nama = " + GamePanel.getMainPlayer().getName());
                    System.out.println("Money = " + GamePanel.getMainPlayer().getMONEY());
                    System.out.println("Posisi = " + GamePanel.getMainPlayer().getPosisi().getX() + "," + GamePanel.getMainPlayer().getPosisi().getY());
                    System.out.println("List Kartu = ");
                    for (int i = 0 ; i < GamePanel.PemainUtama.getAllCard().getSize(); i++ )
                        System.out.println(GamePanel.PemainUtama.getAllCard().get(i).getSlug()
                                            + "\t \t" + GamePanel.PemainUtama.getAllCard().get(i).getName());
                    break;
                case "s":
                case "save":
                    GamePanel.PemainUtama.setLastPlayed();
                    JSONManager.exportPlayer();
                    break;
                case "q":
                case "exit" :
                    System.exit(0);
                case "l":
                case "m" :
                case "move" :
                case "land" :
                    gsm.setState(GameStateManager.DUELISTLAND);
                    break;
                case "b":
                case "back":
                    gsm.setState(GameStateManager.INTRO);
                    break;
                case "d":
                case "deck":
                    gsm.setState(GameStateManager.DECK);
                    break;
                case "sm" :
                case "savemanager" :
                    gsm.setState(GameStateManager.SAVEMANAGER);
                    break;
                default:
                    break;
            }
		
	}


}
