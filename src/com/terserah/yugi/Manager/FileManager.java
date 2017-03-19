/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Manager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author condro
 */
public class FileManager {
    private static String file = "duelist.txt";
    private static String[] arrText = new String[100] ;
    
    public static void Baca() {
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;
           try {
                 reader = new BufferedReader(new FileReader(file));
                  String text = null;
                    // ulangi sampai semua baris terbaca
                    int i = 0 ;
                    while ((text = reader.readLine()) != null) {
                        FileManager.arrText[i] = text;
                        contents.append(text)
                        .append(System.getProperty("line.separator"));
                        i++;
                    }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
              } catch (IOException e) {
                e.printStackTrace();
                } finally {
                    try {
                        if (reader != null) {
                        reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

         // tampilkan isi file
         System.out.println(contents.toString());
    }
    
    public static void getLine(int id) {
        System.out.println(FileManager.arrText[id]);
    }
    
    //USAGE 
    /*
    //Get all line
    FileManager.Baca();
    
    //get by line
    FileManager.getLine(0);
    FileManager.getLine(1);
    FileManager.getLine(2);
    FileManager.getLine(3);
    
    */
}
