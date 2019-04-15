package src.MartinAndVictorMP;

import org.json.JSONException;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class EncounterBuilder {

    private static int numberOfMonsters;
    private static int numberOfPlayers;
    private static int levelOfPlayers;
    private static int minMonsters;
    private static int maxMonsters;
    private static String difficulty;
    private static int partyXpThreshold;

    private static double multiplier;


    // Getters and setters

    public static void setLevelOfPlayers(int levelOfPlayers) {
        EncounterBuilder.levelOfPlayers = levelOfPlayers;
    }


    public static void setMinMonsters(int minMonsters) {
        EncounterBuilder.minMonsters = minMonsters;
    }


    public static void setMaxMonsters(int mm) {
        maxMonsters = mm;
    }

    public static int getNumberOfMonsters(){
        return numberOfMonsters;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static void setNumberOfPlayers(int np) {
        numberOfPlayers = np;
    }

    public static String getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(String dc) {
        difficulty = dc;
    }

    public static void NumberOfMonsters(){
        numberOfMonsters = ThreadLocalRandom.current().nextInt(minMonsters, maxMonsters + 1);
    }


    // Gets the different multipliers that are required if there are more than one monster
    public static double EncounterMultiplier(){
        if (numberOfPlayers < 6 && numberOfPlayers > 2){
            switch (numberOfMonsters){
                case 1:
                    multiplier = 1;
                    break;
                case 2:
                    multiplier = 1.5;
                    break;
                case 3: case 4: case 5: case 6:
                    multiplier = 2;
                    break;
                case 7: case 8: case 9: case 10:
                    multiplier = 2.5;
                    break;
                case 11: case 12: case 13: case 14:
                    multiplier = 3;
                    break;
                case 15:
                    multiplier = 4;
                    break;
            }
        } else if (numberOfPlayers < 3 && numberOfPlayers > 0){
            switch (numberOfMonsters){
                case 1:
                    multiplier = 1.5;
                    break;
                case 2:
                    multiplier = 2;
                    break;
                case 3: case 4: case 5: case 6:
                    multiplier = 2.5;
                    break;
                case 7: case 8: case 9: case 10:
                    multiplier = 3;
                    break;
                case 11: case 12: case 13: case 14:
                    multiplier = 4;
                    break;
                case 15:
                    multiplier = 5;
                    break;
                default:
                    multiplier = 1;
                    break;
            }
        } else if(numberOfPlayers > 5){
            switch (numberOfMonsters){
                case 1:
                    multiplier = 0.5;
                    break;
                case 3: case 4: case 5: case 6:
                    multiplier = 1.5;
                    break;
                case 7: case 8: case 9: case 10:
                    multiplier = 2;
                    break;
                case 11: case 12: case 13: case 14:
                    multiplier = 2.5;
                    break;
                case 15:
                    multiplier = 3;
                    break;
                case 2:
                default:
                    multiplier = 1;
                    break;
            }
        }
        return multiplier;
    }

    // The actual xp that the encounter gives, takes monster xp and amount of monsters and multiplier into account
    // This is the number that should match closely up with the table for encounters. Page 82 in the DM's guide
    public static int GivenEncounterXp(){
        int monsterXp = Monsters.CrToXp();
        NumberOfMonsters();
        double mp = EncounterMultiplier();
        int encounterXp = (int) ((monsterXp * mp) * numberOfMonsters);
        return encounterXp;
    }

    // Gets the party xp threshold by getting the number of players and taking into account the difficulty
    // This is the number that the monsters xp should be as close to as possible.
    public static int PartyXpThreshold() throws NullPointerException{
        System.out.println("difficulty: " + difficulty);
        try {
            switch (difficulty) {
                case "easy":
                    NestedEasy();
                    break;
                case "medium":
                    NestedMedium();
                    break;
                case "hard":
                    NestedHard();
                    break;
                case "deadly":
                    NestedDeadly();
                    break;
                default:
                    System.out.println("Something went wrong with the party xp threshold");
                    break;
            }
        } catch (NullPointerException e){
            difficulty = "easy";
        }
        return partyXpThreshold;
    }

    // This is done for readability
    private static void NestedEasy() {
        switch (levelOfPlayers){
            case 1:
                partyXpThreshold = (25 * numberOfPlayers);
                break;
            case 2:
                partyXpThreshold = (50 * numberOfPlayers);
                break;
            case 3:
                partyXpThreshold = (75 * numberOfPlayers);
                break;
            case 4:
                partyXpThreshold = (125 * numberOfPlayers);
                break;
            case 5:
                partyXpThreshold = (250 * numberOfPlayers);
                break;
            case 6:
                partyXpThreshold = (300 * numberOfPlayers);
                break;
            case 7:
                partyXpThreshold = (350 * numberOfPlayers);
                break;
            case 8:
                partyXpThreshold = (450 * numberOfPlayers);
                break;
            case 9:
                partyXpThreshold = (550 * numberOfPlayers);
                break;
            case 10:
                partyXpThreshold = (600 * numberOfPlayers);
                break;
            case 11:
                partyXpThreshold = (800 * numberOfPlayers);
                break;
            case 12:
                partyXpThreshold = (1000 * numberOfPlayers);
                break;
            case 13:
                partyXpThreshold = (1100 * numberOfPlayers);
                break;
            case 14:
                partyXpThreshold = (1250 * numberOfPlayers);
                break;
            case 15:
                partyXpThreshold = (1400 * numberOfPlayers);
                break;
            case 16:
                partyXpThreshold = (1600 * numberOfPlayers);
                break;
            case 17:
                partyXpThreshold = (2000 * numberOfPlayers);
                break;
            case 18:
                partyXpThreshold = (2100 * numberOfPlayers);
                break;
            case 19:
                partyXpThreshold = (2400 * numberOfPlayers);
                break;
            case 20:
                partyXpThreshold = (2800 * numberOfPlayers);
                break;
            default:
                System.out.println("Error in easy party xp threshold");
                break;
        }
    }

    private static void NestedMedium() {
        switch (levelOfPlayers) {
            case 1:
                partyXpThreshold = (50 * numberOfPlayers);
                break;
            case 2:
                partyXpThreshold = (100 * numberOfPlayers);
                break;
            case 3:
                partyXpThreshold = (150 * numberOfPlayers);
                break;
            case 4:
                partyXpThreshold = (250 * numberOfPlayers);
                break;
            case 5:
                partyXpThreshold = (500 * numberOfPlayers);
                break;
            case 6:
                partyXpThreshold = 600 * numberOfPlayers;
                break;
            case 7:
                partyXpThreshold = (750 * numberOfPlayers);
                break;
            case 8:
                partyXpThreshold = (900 * numberOfPlayers);
                break;
            case 9:
                partyXpThreshold = (1100 * numberOfPlayers);
                break;
            case 10:
                partyXpThreshold = (1200 * numberOfPlayers);
                break;
            case 11:
                partyXpThreshold = (1600 * numberOfPlayers);
                break;
            case 12:
                partyXpThreshold = (2000 * numberOfPlayers);
                break;
            case 13:
                partyXpThreshold = (2200 * numberOfPlayers);
                break;
            case 14:
                partyXpThreshold = (2500 * numberOfPlayers);
                break;
            case 15:
                partyXpThreshold = (2800 * numberOfPlayers);
                break;
            case 16:
                partyXpThreshold = (3200 * numberOfPlayers);
                break;
            case 17:
                partyXpThreshold = (3900 * numberOfPlayers);
                break;
            case 18:
                partyXpThreshold = (4200 * numberOfPlayers);
                break;
            case 19:
                partyXpThreshold = (4900 * numberOfPlayers);
                break;
            case 20:
                partyXpThreshold = (5700 * numberOfPlayers);
                break;
            default:
                System.out.println("Error in medium case party xp threshold");
                break;
        }
    }

    private static void NestedHard() {
        switch (levelOfPlayers) {
            case 1:
                partyXpThreshold = (75 * numberOfPlayers);
                break;
            case 2:
                partyXpThreshold = (150 * numberOfPlayers);
                break;
            case 3:
                partyXpThreshold = (225 * numberOfPlayers);
                break;
            case 4:
                partyXpThreshold = (375 * numberOfPlayers);
                break;
            case 5:
                partyXpThreshold = (750 * numberOfPlayers);
                break;
            case 6:
                partyXpThreshold = (900 * numberOfPlayers);
                break;
            case 7:
                partyXpThreshold = (1100 * numberOfPlayers);
                break;
            case 8:
                partyXpThreshold = (1400 * numberOfPlayers);
                break;
            case 9:
                partyXpThreshold = (1600 * numberOfPlayers);
                break;
            case 10:
                partyXpThreshold = (1900 * numberOfPlayers);
                break;
            case 11:
                partyXpThreshold = (2400 * numberOfPlayers);
                break;
            case 12:
                partyXpThreshold = (3000 * numberOfPlayers);
                break;
            case 13:
                partyXpThreshold = (3400 * numberOfPlayers);
                break;
            case 14:
                partyXpThreshold = (3800 * numberOfPlayers);
                break;
            case 15:
                partyXpThreshold = (4300 * numberOfPlayers);
                break;
            case 16:
                partyXpThreshold = (4800 * numberOfPlayers);
                break;
            case 17:
                partyXpThreshold = (5900 * numberOfPlayers);
                break;
            case 18:
                partyXpThreshold = (6300 * numberOfPlayers);
                break;
            case 19:
                partyXpThreshold = (7300 * numberOfPlayers);
                break;
            case 20:
                partyXpThreshold = (8500 * numberOfPlayers);
                break;
            default:
                System.out.println("Error in hard case party xp threshold");
                break;
        }
    }

    private static void NestedDeadly() {
        switch (levelOfPlayers) {
            case 1:
                partyXpThreshold = (50 * numberOfPlayers);
                break;
            case 2:
                partyXpThreshold = (100 * numberOfPlayers);
                break;
            case 3:
                partyXpThreshold = (150 * numberOfPlayers);
                break;
            case 4:
                partyXpThreshold = (250 * numberOfPlayers);
                break;
            case 5:
                partyXpThreshold = (500 * numberOfPlayers);
                break;
            case 6:
                partyXpThreshold = (600 * numberOfPlayers);
                break;
            case 7:
                partyXpThreshold = (750 * numberOfPlayers);
                break;
            case 8:
                partyXpThreshold = (900 * numberOfPlayers);
                break;
            case 9:
                partyXpThreshold = (1100 * numberOfPlayers);
                break;
            case 10:
                partyXpThreshold = (1200 * numberOfPlayers);
                break;
            case 11:
                partyXpThreshold = (1600 * numberOfPlayers);
                break;
            case 12:
                partyXpThreshold = (2000 * numberOfPlayers);
                break;
            case 13:
                partyXpThreshold = (2200 * numberOfPlayers);
                break;
            case 14:
                partyXpThreshold = (2500 * numberOfPlayers);
                break;
            case 15:
                partyXpThreshold = (2800 * numberOfPlayers);
                break;
            case 16:
                partyXpThreshold = (3200 * numberOfPlayers);
                break;
            case 17:
                partyXpThreshold = (3900 * numberOfPlayers);
                break;
            case 18:
                partyXpThreshold = (4200 * numberOfPlayers);
                break;
            case 19:
                partyXpThreshold = (4900 * numberOfPlayers);
                break;
            case 20:
                partyXpThreshold = (5700 * numberOfPlayers);
                break;
            default:
                System.out.println("Error in deadly case party xp threshold");
                break;
        }
    }

    public static synchronized void BuildEncounter() throws IOException, JSONException {
        // First create the monster
        Monsters.getMonster();

        // Get the name of the monster
        System.out.println(Monsters.getName());

        // Get the stats from the monster
        Monsters.getStats();

        // Get the number of monsters
        // Convert cr to xp
        System.out.println(GivenEncounterXp());

        // Get number of players
        // Get level of players
        // Get difficulty
        // Get party xp threshold
        System.out.println(PartyXpThreshold());

        // TODO make a function/call that compares the party xp to monster xp and generates a new monster as close to the party xp as possible.


    }
}
