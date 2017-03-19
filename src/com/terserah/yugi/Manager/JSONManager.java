package com.terserah.yugi.Manager;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author condro
 */
public class JSONManager {
    
    public static void exportCard() {
    JSONObject obj = new JSONObject();
    obj.put("jumlah", new Integer(2));
    
    JSONArray listAnggota = new JSONArray();
    
        JSONObject member = new JSONObject();
        member.put("name", "Blue-Eyes White Dragon");
        member.put("type", "Monster");
        member.put("probability", new Float(0.03));
        member.put("description", "This legendary dragon is a powerful engine of "
                + "destruction. Virtually invincible, very few have faced this "
                + "awesome creature and lived to tell the tale."); 
        
    listAnggota.add(member);
    
    obj.put("anggota", listAnggota);
 
    try {
        FileWriter file = new FileWriter("kartu.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
 
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    System.out.print(obj);
 
    }
    
    public static void importCard() {
        JSONParser parser = new JSONParser();
        System.out.println();
        try {
	 
	  Object obj = parser.parse(new FileReader("kartu.json"));
	 
	  JSONObject jsonObject = (JSONObject) obj;
	 
	  Long jumlah  = (Long) jsonObject.get("jumlah");
	  System.out.println("Jumlah = "+jumlah);
	 
	 JSONArray array = (JSONArray) jsonObject.get("anggota");
	 for (int i = 0; i<array.size();i++) {
             JSONObject jsonAnggota = (JSONObject) array.get(i);
             System.out.println(jsonAnggota.get("name"));
         }
	} catch (FileNotFoundException ex) {
	   ex.printStackTrace();
	} catch (IOException ex) {
	   ex.printStackTrace();
	} catch (ParseException ex) {
	   ex.printStackTrace();
	}
    }
 
}
