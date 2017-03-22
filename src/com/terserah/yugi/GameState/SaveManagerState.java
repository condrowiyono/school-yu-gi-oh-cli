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
public class SaveManagerState extends GameState {

    public SaveManagerState(GameStateManager gsm) {
        super(gsm);
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
    public void draw() {
        printLoadFile();
        System.out.print("Pilihan ");
        
        handleInput();
    }

    @Override
    public void handleInput() {
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
        case "remove":
            if (cekLoadFile(arrOpt[1])) {
                int idx= Integer.parseInt(arrOpt[1]);
                GamePanel.semuaPemain.remove(idx);
            } else if (("all").equals(arrOpt[1])) {
                GamePanel.semuaPemain.clear();
                gsm.setState(GameStateManager.INTRO);
                JSONManager.exportPlayer();
            } else
                System.out.println("Not Found");
            break;
        case "save" :
            JSONManager.exportPlayer();
            break;
        case "back" :
            gsm.setState(GameStateManager.MENU);
            break;
        default:
            break;
        } 
    }
    
}
