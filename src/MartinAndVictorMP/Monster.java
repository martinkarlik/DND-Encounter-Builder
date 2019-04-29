package src.MartinAndVictorMP;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Monster {

    private double challengeRating;

    private String name;
    private String description;
    private String[] generalInfo = new String[3];
    private String[] attributes = new String[6];
    private ArrayList<String> savingThrows = new ArrayList<String>();
    private ArrayList<String> otherInfo = new ArrayList<String>();
    private ArrayList<String> monsterActions = new ArrayList<String>();

    public Monster(int monsterID) throws IOException, JSONException {

        //each monster has its own url

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

            //organizing the data from jsonObject

            challengeRating = jsonObject.getDouble("challenge_rating");
            name = jsonObject.getString("name");

            description = jsonObject.getString("type");
            if (jsonObject.has("subtype") && jsonObject.getString("subtype").length() > 0) { //sometimes the subtype doesn't exist, sometimes it's an empty string..
                description += " (" + jsonObject.getString("subtype") + ")";
            }
            if (jsonObject.has("alignment")) {
                description += ", " + jsonObject.getString("alignment");
            }

            generalInfo[0] = "Armor class: " + (jsonObject.getInt("armor_class"));
            generalInfo[1] = "Hit points: " + (jsonObject.getInt("hit_points")) + " (" + jsonObject.getString("hit_dice" ) + ")";
            generalInfo[2] = "Speed: " + jsonObject.getString("speed");


            for (int i = 0; i < attributes.length; attributes[i++] = "");

            //some attributes are optional for the monster and require checking whether the jsonObject has them
            if(jsonObject.has("strength")){
                int strength = jsonObject.getInt("strength");
                attributes[0] = "STR: " + strength + " (" + getBonus(strength) + ")";
            }
            if(jsonObject.has("dexterity")){
                int dexterity = jsonObject.getInt("dexterity");
                attributes[1] = "DEX: " + dexterity + " (" + getBonus(dexterity) + ")";
            }
            if(jsonObject.has("constitution")){
                int constitution = jsonObject.getInt("constitution");
                attributes[2] = "CON: " + constitution + " (" + getBonus(constitution) + ")";
            }
            if(jsonObject.has("intelligence")){
                int intelligence = jsonObject.getInt("intelligence");
                attributes[3] = "INT: " + intelligence + " (" + getBonus(intelligence) + ")";
            }
            if(jsonObject.has("wisdom")){
                int wisdom = jsonObject.getInt("wisdom");
                attributes[4] = "WIS: " + wisdom + " (" + getBonus(wisdom) + ")";
            }
            if(jsonObject.has("charisma")){
                int charisma = jsonObject.getInt("charisma");
                attributes[5] = "CHA: " + charisma + " (" + getBonus(charisma) + ")";
            }

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

            otherInfo.add("Challenge rating: " + Double.toString(challengeRating));
            if (jsonObject.has("size")) {
                otherInfo.add("Size: " + jsonObject.getString("size"));
            }
            if(jsonObject.has("languages")){
                otherInfo.add("Languages: " + jsonObject.getString("languages"));
            }
            if(jsonObject.has("senses")){
                otherInfo.add("Senses: " + jsonObject.getString("senses"));
            }
            if(jsonObject.has("damage_vulnerabilities")){
                otherInfo.add("Damage vulnerabilities: " + jsonObject.getString("damage_vulnerabilities"));
            }
            if(jsonObject.has("damage_resistances")){
                otherInfo.add("Damage resistance: " + jsonObject.getString("damage_resistances"));
            }
            if(jsonObject.has("damage_immunities")){
                otherInfo.add("Damage immunities: " + jsonObject.getString("damage_immunities"));
            }
            if(jsonObject.has("stealth")){
                otherInfo.add("Stealth: " + (jsonObject.getInt("stealth")));
            }

            if (jsonObject.has("actions")) {
                JSONArray actions = jsonObject.getJSONArray("actions");
                for (int i = 0; i < actions.length(); i++) {
                    JSONObject action = (JSONObject) actions.get(i);
                    //not every monster has actions, but every action has name and description, so no need to check
                    monsterActions.add(action.getString("name") + ": " + action.getString("desc"));
                }
            }
        }
    }

    private String getBonus(int attribute){
        switch (attribute){
            case 1:
                return "-5";
            case 2: case 3:
                return "-4";
            case 4: case 5:
                return "-3";
            case 6: case 7:
                return "-2";
            case 8: case 9:
                return "-1";
            case 10: case 11:
                return "+0";
            case 12: case 13:
                return "+1";
            case 14: case 15:
                return "+2";
            case 16: case 17:
                return "+3";
            case 18: case 19:
                return "+4";
            case 20: case 21:
                return "+5";
            case 22: case 23:
                return "+6";
            case 24: case 25:
                return "+7";
            case 26: case 27:
                return "+8";
            case 28: case 29:
                return "+9";
            case 30:
                return "+10";
            default:
                return "";
        }
    }

    // Used to calculate the difficulty of the battle
    public int getXp() throws NullPointerException {
        try {
            switch (Double.toString(challengeRating)) {
                case "0.0":
                    return 10;
                case "0.125":
                    return 25;
                case "0.25":
                    return 50;
                case "0.5":
                    return 100;
                case "1.0":
                    return 200;
                case "2.0":
                    return 450;
                case "3.0":
                    return 700;
                case "4.0":
                    return 1100;
                case "5.0":
                    return 1800;
                case "6.0":
                    return 2300;
                case "7.0":
                    return 2900;
                case "8.0":
                    return 3900;
                case "9.0":
                    return 5000;
                case "10.0":
                    return 5900;
                case "11.0":
                    return 7200;
                case "12.0":
                    return 8400;
                case "13.0":
                    return 10000;
                case "14.0":
                    return 11500;
                case "15.0":
                    return 13000;
                case "16.0":
                    return 15000;
                case "17.0":
                    return 18000;
                case "18.0":
                    return 20000;
                case "19.0":
                    return 22000;
                case "20.0":
                    return 25000;
                case "21.0":
                    return 33000;
                case "22.0":
                    return 41000;
                case "23.0":
                    return 50000;
                case "24.0":
                    return 62000;
                case "30.0":
                    return 155000;
                default:
                    System.out.println("No xp set");
                    return 0;
            }
        } catch (NullPointerException e){
            e.printStackTrace();
            return 0;
        }
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String[] getGeneralInfo() {
        return generalInfo;
    }

    public ArrayList<String> getOtherInfo() {
        return otherInfo;
    }

    public ArrayList<String> getSavingThrows() {
        return savingThrows;
    }

    public ArrayList<String> getMonsterActions() {
        return monsterActions;
    }

    public String[] getAttributes() {
        return attributes;
    }



}
