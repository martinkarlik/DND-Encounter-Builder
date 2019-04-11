package src.MarinAndVictorMP;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Monsters {
    ArrayList<String> savingThrows = new ArrayList<>();

    protected String name, size, type, subtype, alignment, speed, damage_vulnerabilities,damage_resistances,
            damage_immunities, senses, languages, hit_dice;

    protected int AC, HP, strength, dexterity, constitution, intelligence, wisdom, charisma,
            str_save, dex_save, con_save, int_save, wis_save, cha_save, stealth;

    protected double challenge_rating;

    public Monsters(String id) throws IOException, JSONException {
        URL url = new URL(id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObject = new JSONObject(response.toString());

            name = jsonObject.getString("name");
            size = jsonObject.getString("size");
            type = jsonObject.getString("type");
            AC = jsonObject.getInt("armor_class");
            HP = jsonObject.getInt("hit_points");
            hit_dice = jsonObject.getString("hit_dice");
            speed = jsonObject.getString("speed");
            challenge_rating = jsonObject.getDouble("challenge_rating");

            // Uncommon attributes
            if(jsonObject.has("strength")){
                strength = jsonObject.getInt("strength");
            }
            if(jsonObject.has("dexterity")){
                dexterity = jsonObject.getInt("dexterity");
            }
            if(jsonObject.has("constitution")){
                constitution = jsonObject.getInt("constitution");
            }
            if(jsonObject.has("intelligence")){
                intelligence = jsonObject.getInt("intelligence");
            }
            if(jsonObject.has("wisdom")){
                wisdom = jsonObject.getInt("wisdom");
            }
            if(jsonObject.has("charisma")){
                charisma = jsonObject.getInt("charisma");
            }
            if(jsonObject.has("languages")){
                languages = jsonObject.getString("languages");
            }
            if(jsonObject.has("senses")){
                senses = jsonObject.getString("senses");
            }
            if(jsonObject.has("damage_vulnerabilities")){
                damage_vulnerabilities = jsonObject.getString("damage_vulnerabilities");
            }
            if(jsonObject.has("damage_resistances")){
                damage_resistances = jsonObject.getString("damage_resistances");
            }
            if(jsonObject.has("damage_immunities")){
                damage_immunities = jsonObject.getString("damage_immunities");
            }
            if(jsonObject.has("subtype")){
                subtype = jsonObject.getString("subtype");
            }
            if(jsonObject.has("alignment")){
                alignment = jsonObject.getString("alignment");
            }

            // Special attributes
            if(jsonObject.has("stealth")){
                stealth = jsonObject.getInt("stealth");
            }

            // Saving throws
            if(jsonObject.has("strength_save")){
                str_save = jsonObject.getInt("strength_save");
                savingThrows.add("STR + " + str_save);
            }
            if(jsonObject.has("dexterity_save")){
                dex_save = jsonObject.getInt("dexterity_save");
                savingThrows.add("DEX + " + dex_save);
            }
            if(jsonObject.has("constitution_save")){
                con_save = jsonObject.getInt("constitution_save");
                savingThrows.add("CON + " + con_save);
            }
            if(jsonObject.has("intelligence_save")){
                int_save = jsonObject.getInt("intelligence_save");
                savingThrows.add("INT + " + int_save);
            }
            if(jsonObject.has("wisdom_save")){
                wis_save = jsonObject.getInt("wisdom_save");
                savingThrows.add("WIS + " + wis_save);
            }
            if(jsonObject.has("charisma_save")){
                cha_save = jsonObject.getInt("charisma_save");
                savingThrows.add("CHA + " + cha_save);
            }


        }
    }

    public void GetStats(){
        System.out.println("Strength: " + strength + " " + GetBonus(strength));
        System.out.println("Dexterity: " + dexterity + " " + GetBonus(dexterity));
        System.out.println("Constitution: " + constitution + " " + GetBonus(constitution));
        System.out.println("Intelligence: " + intelligence + " " + GetBonus(intelligence));
        System.out.println("Wisdom: " + wisdom + " " + GetBonus(wisdom));
        System.out.println("Charisma: " + charisma + " " + GetBonus(charisma));
    }

    // Calculates the number bonus from the stats
    public int GetBonus(int number){
        int bonus = 0;
        switch (number){
            case 1:
                bonus = -5;
                break;
            case 2: case 3:
                bonus = -4;
                break;
            case 4: case 5:
                bonus = -3;
                break;
            case 6: case 7:
                bonus = -2;
                break;
            case 8: case 9:
                bonus = -1;
                break;
            case 10: case 11:
                bonus = 0;
                break;
            case 12: case 13:
                bonus = 1;
                break;
            case 14: case 15:
                bonus = 2;
                break;
            case 16: case 17:
                bonus = 3;
                break;
            case 18: case 19:
                bonus = 4;
                break;
            case 20: case 21:
                bonus = 5;
                break;
            case 22: case 23:
                bonus = 6;
                break;
            case 24: case 25:
                bonus = 7;
                break;
            case 26: case 27:
                bonus = 8;
                break;
            case 28: case 29:
                bonus = 9;
                break;
            case 30:
                bonus = 10;
                break;
        }
        return bonus;
    }

    // Used to calculate the difficulty of the battle
    public int CrToXp(double challenge_rating){
        int xp = 0;
        switch (Double.toString(challenge_rating)){
            case "0":
                xp = 10;
                break;
            case "0.125":
                xp = 25;
                break;
            case "0.25":
                xp = 50;
                break;
            case "0.5":
                xp = 100;
                break;
            case "1.0":
                xp = 200;
                break;
            case "2.0":
                xp = 450;
                break;
            case "3.0":
                xp = 700;
                break;
            case "4.0":
                xp = 1100;
                break;
            case "5.0":
                xp = 1800;
                break;
            case "6.0":
                xp = 2300;
                break;
            case "7.0":
                xp = 2900;
                break;
            case "8.0":
                xp = 3900;
                break;
            case "9.0":
                xp = 5000;
                break;
            case "10.0":
                xp = 5900;
                break;
            case "11.0":
                xp = 7200;
                break;
            case "12.0":
                xp = 8400;
                break;
            case "13.0":
                xp = 10000;
                break;
            case "14.0":
                xp = 11500;
                break;
            case "15.0":
                xp = 13000;
                break;
            case "16.0":
                xp = 15000;
                break;
            case "17.0":
                xp = 18000;
                break;
            case "18.0":
                xp = 20000;
                break;
            case "19.0":
                xp = 22000;
                break;
            case "20.0":
                xp = 25000;
                break;
            case "21.0":
                xp = 33000;
                break;
            case "22.0":
                xp = 41000;
                break;
            case "23.0":
                xp = 50000;
                break;
            case "24.0":
                xp = 62000;
                break;
            case "30.0":
                xp = 155000;
                break;
            default:
                System.out.println("No xp set");
                break;
        }
        return xp;
    }
}
