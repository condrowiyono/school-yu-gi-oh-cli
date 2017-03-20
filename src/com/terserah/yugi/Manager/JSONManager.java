package com.terserah.yugi.Manager;
import com.terserah.yugi.Entities.*;
import com.terserah.yugi.GameState.DuelistLand;
import com.terserah.yugi.GameState.ShopState;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author condro
 */
public class JSONManager {
    
    public static void exportCard() {
    JSONObject obj = new JSONObject();
    //Tingkat 1
    obj.put("count", new Integer(15));
    
    //Tingkat 2
    JSONArray monstertype = new JSONArray();
    JSONArray spelltype = new JSONArray();
    JSONArray traptype = new JSONArray();
        
        //Tingkat 3
        JSONObject member1 = new JSONObject();
        member1.put("name", "Blue-Eyes White Dragon");
        member1.put("type", "Monster");
        member1.put("probability", new Float(0.03));
        member1.put("description", "This legendary dragon is a powerful engine of "
                + "destruction. Virtually invincible, very few have faced this "
                + "awesome creature and lived to tell the tale."); 
        member1.put("ATK", 3000);
        member1.put("DEF", 2500);
        member1.put("level", 8);
        member1.put("attr", "Light");
        member1.put("type", "Dragon");
        member1.put("effect", "null");
        member1.put("pos", "Face Up Attack");
        //Tingkat 4 - 1
        
        JSONObject member2 = new JSONObject();
        member2.put("name", "Celtic Guardian");
        member2.put("type", "Monster");
        member2.put("probability", new Float(0.06));
        member2.put("description", "An elf who learned to wield a sword, "
                + "he baffles enemies with lightning swift attacks."); 
        member2.put("ATK", 1400);
        member2.put("DEF", 1200);
        member2.put("level", 4);
        member2.put("attr", "Earth");
        member2.put("type", "Warrior");
        member2.put("effect", "null");
        member2.put("pos", "Face Up Attack");
        
        JSONObject member3 = new JSONObject();
        member3.put("name", "Tyhone");
        member3.put("type", "Monster");
        member3.put("probability", new Float(0.06));
        member3.put("description", "Capable of firing cannonballs from its mouth "
                + "for long-range attacks, this creature is particularly "
                + "effective in mountain battles."); 
        member3.put("ATK", 1200);
        member3.put("DEF", 1400);
        member3.put("level", 4);
        member3.put("attr", "Earth");
        member3.put("type", "Winged Beast");
        member3.put("effect", "null");
        member3.put("pos", "Face Up Attack");
        
        JSONObject member4 = new JSONObject();
        member4.put("name", "Hane-Hane");
        member4.put("type", "Monster");
        member4.put("probability", new Float(0.10));
        member4.put("description", "FLIP : Select 1 monster on the field and "
                + "return it to its owner's hand.."); 
        member4.put("ATK", 450);
        member4.put("DEF", 500);
        member4.put("level", 2);
        member4.put("attr", "Earth");
        member4.put("type", "Beast");
        member4.put("effect", "null");
        member4.put("pos", "Face Up Attack");
        
        JSONObject member5 = new JSONObject();
        member5.put("name", "Man-Eater Bug");
        member5.put("type", "Monster");
        member5.put("probability", new Float(0.10));
        member5.put("description", "FLIP: Target 1 monster on the field, "
                + "destroy that target."); 
        member5.put("ATK", 450);
        member5.put("DEF", 600);
        member5.put("level", 2);
        member5.put("attr", "Earth");
        member5.put("type", "Insect");
        member5.put("effect", "null");
        member5.put("pos", "Face Up Attack");
        
        JSONObject member6 = new JSONObject();
        member6.put("name", "Turtle Tiger");
        member6.put("type", "Monster");
        member6.put("probability", new Float(0.06));
        member6.put("description", "A tiger encased in a protective shell that attack with razor-sharp fangs."); 
        member6.put("ATK", 1000);
        member6.put("DEF", 1500);
        member6.put("level", 4);
        member6.put("attr", "Water");
        member6.put("type", "Aqua");
        member6.put("effect", "null");
        member6.put("pos", "Face Up Attack");
        
        JSONObject member7 = new JSONObject();
        member7.put("name", "Harpie Lady");
        member7.put("type", "Monster");
        member7.put("probability", new Float(0.06));
        member7.put("description", "This human-shaped animal with wings is "
                + "beautiful to watch but deadly in battle"); 
        member7.put("ATK", 1300);
        member7.put("DEF", 1400);
        member7.put("level", 4);
        member7.put("attr", "Wind");
        member7.put("type", "Winged Beast");
        member7.put("effect", "null");
        member7.put("pos", "Face Up Attack");
        
        JSONObject member8 = new JSONObject();
        member8.put("name", "Curse of Dragon");
        member8.put("type", "Monster");
        member8.put("probability", new Float(0.04));
        member8.put("description", "A wicked dragon that taps into "
                + "dark forces to execute a powerful attack."); 
        member8.put("ATK", 2000);
        member8.put("DEF", 1500);
        member8.put("level", 5);
        member8.put("attr", "Dark");
        member8.put("type", "Dragon");
        member8.put("effect", "null");
        member8.put("pos", "Face Up Attack");
        
        JSONObject member9 = new JSONObject();
        member9.put("name", "Fissure");
        member9.put("type", "Spell");
        member9.put("probability", new Float(0.07));
        member9.put("description", "Destroy the 1 face-up monster your "
                + "opponent controls that has the lowest ATK (your choice, if tied).."); 
        member9.put("type", "Normal");
        
        JSONObject member10 = new JSONObject();
        member10.put("name", "Change of Heart");
        member10.put("type", "Spell");
        member10.put("probability", new Float(0.07));
        member10.put("description", "Select and control 1 opposing "
                + "monster (regardless of position) on the field until the end of your turn."); 
        member10.put("type", "Normal"); 
        
        JSONObject member11 = new JSONObject();
        member11.put("name", "Stop Defense");
        member11.put("type", "Spell");
        member11.put("probability", new Float(0.07));
        member11.put("description", "Select 1 Defense Position monster on "
                + "your opponentÅfs side of the field and charge it to Attack Position."); 
        member11.put("type", "Normal"); 
        JSONObject member12 = new JSONObject();
        member12.put("name", "Follow Wind");
        member12.put("type", "Spell");
        member12.put("probability", new Float(0.07));
        member12.put("description", "Increase the ATK and DEF of a "
                + "Winged-Beast-Type monster equipped with this card by 300 points."); 
        member12.put("type", "Equip"); 
        
        JSONObject member13 = new JSONObject();
        member13.put("name", "Negate Attack");
        member13.put("type", "Trap");
        member13.put("probability", new Float(0.07));
        member13.put("description", "When an opponentÅfs monster declares an "
                + "attack: Target the attacking monster; negate the attack, then end the Battle Phase."); 
        member13.put("type", "Equip"); 
        
        JSONObject member14 = new JSONObject();
        member14.put("name", "Trap Hole");
        member14.put("type", "Trap");
        member14.put("probability", new Float(0.07));
        member14.put("description", "When your opponent Normal or Flip Summons 1 "
                + "monster with 1000 or more ATK: Target that monster; destroy "
                + "that target."); 
        member14.put("type", "Normal"); 
        
        JSONObject member15 = new JSONObject();
        member15.put("name", "Mirror Force");
        member15.put("type", "Trap");
        member15.put("probability", new Float(0.07));
        member15.put("description", "When an opponentÅ's monster declares an "
                + "attack: Destroy all Attack Position monsters your "
                + "opponent controls."); 
        member15.put("type", "Normal");        
        
    monstertype.add(member1);
    monstertype.add(member2);
    monstertype.add(member3);
    monstertype.add(member4);
    monstertype.add(member5);
    monstertype.add(member6);
    monstertype.add(member7);
    monstertype.add(member8);
    
    spelltype.add(member9);
    spelltype.add(member10);
    spelltype.add(member11);
    spelltype.add(member12);
    
    traptype.add(member13);
    traptype.add(member14);
    traptype.add(member15);
    
    obj.put("monster", monstertype);
    obj.put("spell", spelltype);
    obj.put("trap", traptype);
    
    try {
        FileWriter file = new FileWriter("kartu.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
 
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    //System.out.print(obj);
 
    }
    
    public static void importCard() {
        JSONParser parser = new JSONParser();
        System.out.println();
        try {
	 
	  Object obj = parser.parse(new FileReader("kartu.json"));
	 
	  JSONObject jsonObject = (JSONObject) obj;
	  Long jumlah  = (Long) jsonObject.get("count");
         
                JSONArray monsterlist = (JSONArray) jsonObject.get("monster");
                
                for (int j=0; j<monsterlist.size();j++) {
                    JSONObject monstermember = (JSONObject) monsterlist.get(j);
                    String cardname,desc,post,attrib,type,position;
                    Double prob;
                    Long ATK,DEF,level;
                    
                    cardname = (String) monstermember.get("name");
                    desc = (String) monstermember.get("description");
                    attrib = (String) monstermember.get("attr");
                    position = (String) monstermember.get("pos");
                    type = (String) monstermember.get("type");
                    prob = (Double) monstermember.get("probability");
                    ATK = (Long) monstermember.get("ATK");
                    DEF = (Long) monstermember.get("DEF");
                    level = (Long) monstermember.get("level");
                    Monster monster = new Monster(cardname,desc,"monster",
                                          prob.floatValue(), ATK.intValue() , DEF.intValue(), 
                                          level.intValue(),
                                          attrib,type,position);
                    
                    ShopState.allCard.addToBottom(monster);
                }
                
                JSONArray spelllist = (JSONArray) jsonObject.get("spell");
                
                for (int j=0; j<spelllist.size();j++) {
                    JSONObject spellmember = (JSONObject) spelllist.get(j);
                    String cardname,desc,type;
                    Double prob;
                    
                    cardname = (String) spellmember.get("name");
                    desc = (String) spellmember.get("description");
                    type = (String) spellmember.get("type");
                    prob = (Double) spellmember.get("probability");
                    Spell spell = new Spell(cardname,desc,"spell",prob.floatValue()
                                            , "null");
                    ShopState.allCard.addToBottom(spell);
                }
                
                JSONArray traplist = (JSONArray) jsonObject.get("trap");
                
                for (int j=0; j<traplist.size();j++) {
                    JSONObject trapmember = (JSONObject) traplist.get(j);
                    String cardname,desc,type;
                    Double prob;
                    
                    cardname = (String) trapmember.get("name");
                    desc = (String) trapmember.get("description");
                    type = (String) trapmember.get("type");
                    prob = (Double) trapmember.get("probability");
                    Trap trap = new Trap(cardname,desc,"spell",prob.floatValue()
                                            , "null");                   
                    ShopState.allCard.addToBottom(trap);
                }
         
	} catch (FileNotFoundException ex) {
	   ex.printStackTrace();
	} catch (IOException ex) {
	   ex.printStackTrace();
	} catch (ParseException ex) {
	   ex.printStackTrace();
	}
    }
    
    
    public static void importDuelist() {
        JSONParser parser = new JSONParser();
        System.out.println();
        try {
	 
	  Object obj = parser.parse(new FileReader("duelist.json"));
	 
	  JSONObject jsonObject = (JSONObject) obj;
	  Long jumlah  = (Long) jsonObject.get("count");
	  //System.out.println("Count = "+jumlah);

	 JSONArray duelistmember = (JSONArray) jsonObject.get("duelistmember");
	 for (int i = 0; i<duelistmember.size();i++) {
             String name,rank;
             int x,y;
             Long xl,yl;
             
             JSONObject jsonAnggota = (JSONObject) duelistmember.get(i);
             JSONObject biodata = (JSONObject) jsonAnggota.get("biodata");
                name = (String) biodata.get("name");
                rank = (String) biodata.get("rank");
                xl = (Long) biodata.get("x");
                yl = (Long) biodata.get("y");
                x = xl.intValue();
                y = yl.intValue(); 
                JSONObject deck = (JSONObject) jsonAnggota.get("deck");
                //Array List<Card>
                ArrayList<Card> arrCard = new ArrayList<Card>();
                
                JSONArray monsterlist = (JSONArray) deck.get("monster");
                
                for (int j=0; j<monsterlist.size();j++) {
                    JSONObject monstermember = (JSONObject) monsterlist.get(j);
                    String cardname,desc,post,attrib,type,position;
                    Double prob;
                    Long ATK,DEF,level;
                    
                    cardname = (String) monstermember.get("name");
                    desc = (String) monstermember.get("description");
                    attrib = (String) monstermember.get("attr");
                    position = (String) monstermember.get("pos");
                    type = (String) monstermember.get("type");
                    prob = (Double) monstermember.get("probability");
                    ATK = (Long) monstermember.get("ATK");
                    DEF = (Long) monstermember.get("DEF");
                    level = (Long) monstermember.get("level");
                    Monster monster = new Monster(cardname,desc,"monster",
                                          prob.floatValue(), ATK.intValue() , DEF.intValue(), 
                                          level.intValue(),
                                          attrib,type,position);
                    
                    arrCard.add(monster);
                }
                
                JSONArray spelllist = (JSONArray) deck.get("spell");
                
                for (int j=0; j<spelllist.size();j++) {
                    JSONObject spellmember = (JSONObject) spelllist.get(j);
                    String cardname,desc,type;
                    Double prob;
                    
                    cardname = (String) spellmember.get("name");
                    desc = (String) spellmember.get("description");
                    type = (String) spellmember.get("type");
                    prob = (Double) spellmember.get("probability");
                    Spell spell = new Spell(cardname,desc,"spell",prob.floatValue()
                                            , "null");
                    arrCard.add(spell);
                }
                JSONArray traplist = (JSONArray) deck.get("trap");
                
                for (int j=0; j<traplist.size();j++) {
                    JSONObject trapmember = (JSONObject) traplist.get(j);
                    String cardname,desc,type;
                    Double prob;
                    
                    cardname = (String) trapmember.get("name");
                    desc = (String) trapmember.get("description");
                    type = (String) trapmember.get("type");
                    prob = (Double) trapmember.get("probability");
                    Trap trap = new Trap(cardname,desc,"spell",prob.floatValue()
                                            , "null");
                    arrCard.add(trap);
                }
                
                Deck duelistdeck = new Deck(arrCard);
                Duelist duelist = new Duelist(name,x,y,rank, duelistdeck);
                DuelistLand.arrDuelist.add(duelist);
         }
	} catch (FileNotFoundException ex) {
	   ex.printStackTrace();
	} catch (IOException ex) {
	   ex.printStackTrace();
	} catch (ParseException ex) {
	   ex.printStackTrace();
	}
    }
    
    public static void exportDuelist() {
    JSONObject obj = new JSONObject();
    //Tingkat 1
    obj.put("count", new Integer(2));
    //Tingkat 1,2
    JSONArray duelistmember = new JSONArray();
    JSONObject memberObject1 = new JSONObject();
    //Tingkat 2
    JSONObject biodata = new JSONObject();
    biodata.put("name", "Yugi");
    biodata.put("x", 2);
    biodata.put("y", 3);
    biodata.put("rank", "dewa");
    JSONObject deck = new JSONObject();
        //Tingkat 4
        JSONArray monstertype = new JSONArray();
        JSONArray spelltype = new JSONArray();
        JSONArray traptype = new JSONArray();

        //Tingkat 5
        JSONObject member1 = new JSONObject();
        member1.put("name", "Blue-Eyes White Dragon");
        member1.put("type", "Monster");
        member1.put("probability", new Float(0.03));
        member1.put("description", "This legendary dragon is a powerful engine of "
                + "destruction. Virtually invincible, very few have faced this "
                + "awesome creature and lived to tell the tale."); 
        member1.put("ATK", 3000);
        member1.put("DEF", 2500);
        member1.put("level", 8);
        member1.put("attr", "Light");
        member1.put("type", "Dragon");
        member1.put("effect", "null");
        member1.put("pos", "Face Up Attack");
    
    monstertype.add(member1);
    deck.put("monster", monstertype);
    deck.put("trap", traptype);
    deck.put("spell", spelltype);
    memberObject1.put("biodata", biodata);
    memberObject1.put("deck", deck);
    duelistmember.add(memberObject1);
    obj.put("duelistmember", duelistmember);
    
    try {
        FileWriter file = new FileWriter("duelist.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
 
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    //System.out.print(obj);
 
    }
    
    public static void exportPlayer() {
    JSONObject obj = new JSONObject();
    //Tingkat 1
    obj.put("count", new Integer(2));
    //Tingkat 1.5
    JSONArray savemember = new JSONArray();
    
    //Tingkat 2
    JSONObject biodata = new JSONObject();
    biodata.put("name", "Yugi");
    biodata.put("x", 2);
    biodata.put("y", 3);
    biodata.put("money", 1000);
    JSONObject kartu = new JSONObject();
    JSONObject deck = new JSONObject();
        //Tingkat 4
        JSONArray monstertype = new JSONArray();
        JSONArray spelltype = new JSONArray();
        JSONArray traptype = new JSONArray();

        //Tingkat 5
        JSONObject member1 = new JSONObject();
        member1.put("name", "Blue-Eyes White Dragon");
        member1.put("type", "Monster");
        member1.put("probability", new Float(0.03));
        member1.put("description", "This legendary dragon is a powerful engine of "
                + "destruction. Virtually invincible, very few have faced this "
                + "awesome creature and lived to tell the tale."); 
        member1.put("ATK", 3000);
        member1.put("DEF", 2500);
        member1.put("level", 8);
        member1.put("attr", "Light");
        member1.put("type", "Dragon");
        member1.put("effect", "null");
        member1.put("pos", "Face Up Attack");
    
    monstertype.add(member1);
    deck.put("monster", monstertype);
    deck.put("trap", traptype);
    deck.put("spell", spelltype);
    kartu.put("monster", monstertype);
    kartu.put("spell", spelltype);
    kartu.put("trap", traptype);
    savemember.add(biodata);
    savemember.add(deck);
    savemember.add(kartu);
    obj.put("member", savemember);
    
    try {
        FileWriter file = new FileWriter("player.json");
        file.write(obj.toJSONString());
        file.flush();
        file.close();
 
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    //System.out.print(obj);
 
    }

}
