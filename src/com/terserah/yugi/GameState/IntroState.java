package com.terserah.yugi.GameState;

import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import com.terserah.yugi.Manager.JSONManager;
import java.util.Scanner;

public class IntroState extends GameState {
	
	public IntroState(GameStateManager gsm) {
		super(gsm);
	}
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Yu Gi Oh Game");
		handleInput();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
                System.out.println("Command");
                System.out.println("N New Game");
                System.out.println("L Load Game");
                System.out.println("E Exit");
                System.out.print("Pilihan : ");
		Scanner in = new Scanner(System.in);
		String opt;
		opt = in.nextLine();
                String[] arrOpt ;
                arrOpt = opt.split(" ");
                if (null != arrOpt[0]) switch (arrOpt[0]) {
                    case "new" :
                    case "N":
                        System.out.println("Please Enter Name:");
                        String name;
                        name = in.nextLine();
                        GamePanel.createPlayer(name);
                        GamePanel.PemainUtama.getAllCard().addToBottom(ShopState.allCard.getBySlug("fissure"));
                        GamePanel.PemainUtama.getAllCard().addToBottom(ShopState.allCard.getBySlug("traphole"));
                        
                        JSONManager.semuaPemain.add(GamePanel.PemainUtama);
                        
                        gsm.setState(GameStateManager.MENU);
                        break;
                    case "load" :
                    case "L":
                        gsm.setState(GameStateManager.LOAD);
                        break;
                    case "exit" :
                    case "E":
                        System.exit(0);
                    default :
                        break;
                
                }
        }

}
