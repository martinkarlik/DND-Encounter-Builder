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

    String name, size, type, subtype, alignment, speed, damage_vulnerabilities,damage_resistances,
            damage_immunities, senses, languages;

    int AC, HP, strength, dexterity, constitution, intelligence, wisdom, charisma,
            str_save, dex_save, con_save, int_save, wis_save, cha_save, stealth, challenge_rating;

    public Monsters(String id) throws MalformedURLException, IOException, JSONException {
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
            subtype = jsonObject.getString("subtype");
            alignment = jsonObject.getString("alignment");
            AC = jsonObject.getInt("armor_class");
            HP = jsonObject.getInt("hit_points");
            speed = jsonObject.getString("speed");
            strength = jsonObject.getInt("strength");
            dexterity = jsonObject.getInt("dexterity");
            constitution = jsonObject.getInt("constitution");
            intelligence = jsonObject.getInt("intelligence");
            wisdom = jsonObject.getInt("wisdom");
            charisma = jsonObject.getInt("charisma");
            languages = jsonObject.getString("languages");
            senses = jsonObject.getString("senses");
            damage_vulnerabilities = jsonObject.getString("damage_vulnerabilities");
            damage_resistances = jsonObject.getString("damage_resistances");
            damage_immunities = jsonObject.getString("damage_immunities");
            stealth = jsonObject.getInt("stealth");
            challenge_rating = jsonObject.getInt("challenge_rating");

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
}
