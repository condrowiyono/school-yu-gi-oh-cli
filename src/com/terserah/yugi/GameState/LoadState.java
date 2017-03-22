/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.GameState;

import com.terserah.yugi.Main.GamePanel;
import com.terserah.yugi.Manager.GameStateManager;
import com.terserah.yugi.Manager.JSONManager;
import java.util.Scanner;

/**
 *
 * @author condro
 */
public class LoadState extends GameState {

    public LoadState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void draw() {
        printLoadFile();
        System.out.print("Pilihan ");
        
        handleInput();
        //To change body of generated methods, choose Tools | Templates.
        
    }
    private void printLoadFile() {
        for (int i = 0; i< GamePanel.semuaPemain.size();i++ )
            System.out.println(i+ "\t" + GamePanel.semuaPemain.get(i).getName());
    }
    
    private boolean cekLoadFile(String id) {
        boolean flag = false;
        String idx;
        for (int i = 0; i< GamePanel.semuaPemain.size() ;i++) {
            idx = Integer.toString(i);
            if (id.equals(idx))
                flag = true;
        }
        return flag;
    }
    @Override
    public void handleInput() {
        //To change body of generated methods, choose Tools | Templates.
        Scanner in = new Scanner(System.in);
        String opt;
        opt = in.nextLine();
        String[] arrOpt ;
        arrOpt = opt.split(" ");

        if (null != arrOpt[0]) switch (arrOpt[0]) {
        case "list":
            if ("All".equals(arrOpt[1])) {
                printLoadFile();
            } 
            break;
        case "load":
            if (cekLoadFile(arrOpt[1])) {
                int idx= Integer.parseInt(arrOpt[1]);
                GamePanel.PemainUtama = GamePanel.semuaPemain.get(idx);
                gsm.setState(GameStateManager.MENU);

            } else {
                System.out.println("Not Found");
            }
            break;
        case "back" :
            gsm.setState(GameStateManager.INTRO);
            break;
        default:
            break;
        } 
    }
    
}
