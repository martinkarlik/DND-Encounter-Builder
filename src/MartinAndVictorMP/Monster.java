package src.MartinAndVictorMP;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Monster {

    private ArrayList<String> savingThrows = new ArrayList<>();
    private ArrayList<String> attributes = new ArrayList<>();
    private double challengeRating;

    private String name;
    private String description;
    private String[] generalInfo = new String[3];
    private String[] attributes = new String[6];
    private String[] otherInfo = new



    public Monster(int monsterID) throws IOException, JSONException {

        URL url = new URL("http://dnd5eapi.co/api/monsters/" + monsterID + "/");
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

            challengeRating = jsonObject.getDouble("challenge_rating");
            name = jsonObject.getString("name");

            attributes.add("Size: " + jsonObject.getString("size"));
            attributes.add("Type: " + jsonObject.getString("type"));
            attributes.add("Armor class: " + Integer.toString(jsonObject.getInt("armor_class")));
            attributes.add("Hit points: " + Integer.toString(jsonObject.getInt("hit_points")));
            attributes.add("Hit dice: " + jsonObject.getString("hit_dice"));
            attributes.add("Speed: " + jsonObject.getString("speed"));

            // Uncommon attributes
            if(jsonObject.has("strength")){
                attributes.add(""); //if these attributes are present, display empty line first  them

                int strength = jsonObject.getInt("strength");
                attributes.add("Strength: " + strength + " " + getBonus(strength));
            }
            if(jsonObject.has("dexterity")){
                int dexterity = jsonObject.getInt("dexterity");
                attributes.add("Dexterity: " + dexterity + " " + getBonus(dexterity));
            }
            if(jsonObject.has("constitution")){
                int constitution = jsonObject.getInt("constitution");
                attributes.add("Dexterity: " + constitution + " " + getBonus(constitution));
            }
            if(jsonObject.has("intelligence")){
                int intelligence = jsonObject.getInt("intelligence");
                attributes.add("Intelligence: " + intelligence + " " + getBonus(intelligence));
            }
            if(jsonObject.has("wisdom")){
                int wisdom = jsonObject.getInt("wisdom");
                attributes.add("Wisdom: " + wisdom + " " + getBonus(wisdom));
            }
            if(jsonObject.has("charisma")){
                int charisma = jsonObject.getInt("charisma");
                attributes.add("Charisma: " + charisma + " " + getBonus(charisma));
            }
            if(jsonObject.has("languages")){
                attributes.add("Languages: " + jsonObject.getString("languages"));
            }
            if(jsonObject.has("senses")){
                attributes.add("Senses: " + jsonObject.getString("senses"));
            }
            if(jsonObject.has("damage_vulnerabilities")){
                attributes.add("Damage vulnerabilities: " + jsonObject.getString("damage_vulnerabilities"));
            }
            if(jsonObject.has("damage_resistances")){
                attributes.add("Damage resistance: " + jsonObject.getString("damage_resistances"));
            }
            if(jsonObject.has("damage_immunities")){
                attributes.add("Damage immunities: " + jsonObject.getString("damage_immunities"));
            }
            if(jsonObject.has("subtype")){
                attributes.add("Subtype: " + jsonObject.getString("subtype"));
            }
            if(jsonObject.has("alignment")){
                attributes.add("Alignment: " + jsonObject.getString("alignment"));
            }
            if(jsonObject.has("stealth")){
                attributes.add("Stealth: " + Integer.toString(jsonObject.getInt("stealth")));
            }


            // Saving throws
            if(jsonObject.has("strength_save")){
                savingThrows.add("STR + " + jsonObject.getInt("strength_save"));
            }
            if(jsonObject.has("dexterity_save")){
                savingThrows.add("DEX + " + jsonObject.getInt("dexterity_save"));
            }
            if(jsonObject.has("constitution_save")){
                savingThrows.add("CON + " + jsonObject.getInt("constitution_save"));
            }
            if(jsonObject.has("intelligence_save")){
                savingThrows.add("INT + " + jsonObject.getInt("intelligence_save"));
            }
            if(jsonObject.has("wisdom_save")){
                savingThrows.add("WIS + " + jsonObject.getInt("wisdom_save"));
            }
            if(jsonObject.has("charisma_save")){
                savingThrows.add("CHA + " + jsonObject.getInt("charisma_save"));
            }
        }
    }

    public String getName() {
        return name;
    }

    // Calculates the number bonus from the stats
    private String getBonus(int attribute){
        String bonus;
        switch (attribute){
            case 1:
                bonus = "-5";
                break;
            case 2: case 3:
                bonus = "-4";
                break;
            case 4: case 5:
                bonus = "-3";
                break;
            case 6: case 7:
                bonus = "-2";
                break;
            case 8: case 9:
                bonus = "-1";
                break;
            case 10: case 11:
                bonus = "0";
                break;
            case 12: case 13:
                bonus = "+1";
                break;
            case 14: case 15:
                bonus = "+2";
                break;
            case 16: case 17:
                bonus = "+3";
                break;
            case 18: case 19:
                bonus = "+4";
                break;
            case 20: case 21:
                bonus = "+5";
                break;
            case 22: case 23:
                bonus = "+6";
                break;
            case 24: case 25:
                bonus = "+7";
                break;
            case 26: case 27:
                bonus = "+8";
                break;
            case 28: case 29:
                bonus = "+9";
                break;
            case 30:
                bonus = "+10";
                break;
            default:
                bonus = "";
                break;
        }
        return bonus;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public ArrayList<String> getSavingThrows() {
        return savingThrows;
    }

    // Used to calculate the difficulty of the battle
    public int getXp() throws NullPointerException {
        try {
            int xp = 0;
            switch (Double.toString(challengeRating)) {
                case "0.0":
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
        } catch (NullPointerException e){
            e.printStackTrace();
            return 0;
        }
    }
}
