package src.MartinAndVictorMP;

import org.json.JSONException;
import java.io.IOException;
import java.util.Random;

public class Encounter {

    private int numberOfPlayers;
    private int levelOfPlayers;
    private int minMonsters;
    private int maxMonsters;
    private String difficulty;

    private int partyXpThreshold;
    private int[] shuffledOrder;

    private int monstersInEncounter;
    private float accuracy;

    /*
    The only reason why I changed static variables and functions to non-static, is cause Im more familiar with having it like this
    and for me it's more flexible to work with.. to have individual encounter objects that represent individual encounters.
    */

    Encounter(int numberOfPlayers_, int levelOfPlayers_, int minMonsters_, int maxMonsters_, String difficulty_) {
        numberOfPlayers = numberOfPlayers_;
        levelOfPlayers = levelOfPlayers_;
        minMonsters = minMonsters_;
        maxMonsters = maxMonsters_;
        difficulty = difficulty_;

        partyXpThreshold = getPartyXpThreshold();

        monstersInEncounter = 0;
        accuracy = 0.0f;
    }

    /*
    I don't think we need these setters and getters (even though it's a good convention to have them, in this case it really seems redundant, since we set the values from outside anyway)
    public void setLevelOfPlayers(int levelOfPlayers_) {
        levelOfPlayers = levelOfPlayers_;
    }

    public void setNumberOfPlayers(int numberOfPlayers_) {
        numberOfPlayers = numberOfPlayers_;
    }

    public void setMinMonsters(int minMonsters_) {
        minMonsters = minMonsters_;
    }

    public void setMaxMonsters(int maxMonsters_) {
        maxMonsters = maxMonsters_;
    }

    public void setDifficulty(String difficulty_) {
        difficulty = difficulty_;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public String getDifficulty() {
        return difficulty;
    }

    */

    public void setMonstersInEncounter(int monstersInEncounter_) {
        monstersInEncounter = monstersInEncounter_;
    }

    public int getMonstersInEncounter() {
        return monstersInEncounter;
    }

    public void setAccuracy(float accuracy_) {
        accuracy = accuracy_;
    }

    public float getAccuracy() {
        return accuracy;
    }

    // Gets the different multipliers that are required if there are more than one monster
    private double getEncounterMultiplier(int sizeOfMonsterType){
        double multiplier = 0;
        if (numberOfPlayers < 6 && numberOfPlayers > 2){
            switch (sizeOfMonsterType){
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
            switch (sizeOfMonsterType){
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
            switch (sizeOfMonsterType){
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

    // Gets the party xp threshold by getting the number of players and taking into account the difficulty
    // This is the number that the monsters xp should be as close to as possible.
    private int getPartyXpThreshold() throws NullPointerException{
        try {
            switch (difficulty) {
                case "easy":
                    return nestedEasy();
                case "medium":
                    return nestedMedium();
                case "hard":
                    return nestedHard();
                case "deadly":
                    return nestedDeadly();
                default:
                    System.out.println("Something went wrong with the party xp threshold");
                    return 0;
            }
        } catch (NullPointerException e){
            difficulty = "easy";
            return 0;
        }
    }

    // This is done for readability
    private int nestedEasy() {
        switch (levelOfPlayers){
            case 1:
                return 25 * numberOfPlayers;
            case 2:
                return 50 * numberOfPlayers;
            case 3:
                return 75 * numberOfPlayers;
            case 4:
                return 125 * numberOfPlayers;
            case 5:
                return 250 * numberOfPlayers;
            case 6:
                return 300 * numberOfPlayers;
            case 7:
                return 350 * numberOfPlayers;
            case 8:
                return 450 * numberOfPlayers;
            case 9:
                return 550 * numberOfPlayers;
            case 10:
                return 600 * numberOfPlayers;
            case 11:
                return 800 * numberOfPlayers;
            case 12:
                return 1000 * numberOfPlayers;
            case 13:
                return 1100 * numberOfPlayers;
            case 14:
                return 1250 * numberOfPlayers;
            case 15:
                return 1400 * numberOfPlayers;
            case 16:
                return 1600 * numberOfPlayers;
            case 17:
                return 2000 * numberOfPlayers;
            case 18:
                return 2100 * numberOfPlayers;
            case 19:
                return 2400 * numberOfPlayers;
            case 20:
                return 2800 * numberOfPlayers;
            default:
                System.out.println("Error in easy party xp threshold");
                return 0;
        }
    }

    private int nestedMedium() {
        switch (levelOfPlayers) {
            case 1:
                return 50 * numberOfPlayers;
            case 2:
                return 100 * numberOfPlayers;
            case 3:
                return 150 * numberOfPlayers;
            case 4:
                return 250 * numberOfPlayers;
            case 5:
                return 500 * numberOfPlayers;
            case 6:
                return 600 * numberOfPlayers;
            case 7:
                return 750 * numberOfPlayers;
            case 8:
                return 900 * numberOfPlayers;
            case 9:
                return 1100 * numberOfPlayers;
            case 10:
                return 1200 * numberOfPlayers;
            case 11:
                return 1600 * numberOfPlayers;
            case 12:
                return 2000 * numberOfPlayers;
            case 13:
                return 2200 * numberOfPlayers;
            case 14:
                return 2500 * numberOfPlayers;
            case 15:
                return 2800 * numberOfPlayers;
            case 16:
                return 3200 * numberOfPlayers;
            case 17:
                return 3900 * numberOfPlayers;
            case 18:
                return 4200 * numberOfPlayers;
            case 19:
                return 4900 * numberOfPlayers;
            case 20:
                return 5700 * numberOfPlayers;
            default:
                System.out.println("Error in medium case party xp threshold");
                return 0;
        }
    }

    private int nestedHard() {
        switch (levelOfPlayers) {
            case 1:
                return 75 * numberOfPlayers;
            case 2:
                return 150 * numberOfPlayers;
            case 3:
                return 225 * numberOfPlayers;
            case 4:
                return 375 * numberOfPlayers;
            case 5:
                return 750 * numberOfPlayers;
            case 6:
                return 900 * numberOfPlayers;
            case 7:
                return 1100 * numberOfPlayers;
            case 8:
                return 1400 * numberOfPlayers;
            case 9:
                return 1600 * numberOfPlayers;
            case 10:
                return 1900 * numberOfPlayers;
            case 11:
                return 2400 * numberOfPlayers;
            case 12:
                return 3000 * numberOfPlayers;
            case 13:
                return 3400 * numberOfPlayers;
            case 14:
                return 3800 * numberOfPlayers;
            case 15:
                return 4300 * numberOfPlayers;
            case 16:
                return 4800 * numberOfPlayers;
            case 17:
                return 5900 * numberOfPlayers;
            case 18:
                return 6300 * numberOfPlayers;
            case 19:
                return 7300 * numberOfPlayers;
            case 20:
                return 8500 * numberOfPlayers;
            default:
                System.out.println("Error in hard case party xp threshold");
                return 0;
        }
    }

    private int nestedDeadly() {
        switch (levelOfPlayers) {
            case 1:
                return 50 * numberOfPlayers;
            case 2:
                return 100 * numberOfPlayers;
            case 3:
                return 150 * numberOfPlayers;
            case 4:
                return 250 * numberOfPlayers;
            case 5:
                return 500 * numberOfPlayers;
            case 6:
                return 600 * numberOfPlayers;
            case 7:
                return 750 * numberOfPlayers;
            case 8:
                return 900 * numberOfPlayers;
            case 9:
                return 1100 * numberOfPlayers;
            case 10:
                return 1200 * numberOfPlayers;
            case 11:
                return 1600 * numberOfPlayers;
            case 12:
                return 2000 * numberOfPlayers;
            case 13:
                return 2200 * numberOfPlayers;
            case 14:
                return 2500 * numberOfPlayers;
            case 15:
                return 2800 * numberOfPlayers;
            case 16:
                return 3200 * numberOfPlayers;
            case 17:
                return 3900 * numberOfPlayers;
            case 18:
                return 4200 * numberOfPlayers;
            case 19:
                return 4900 * numberOfPlayers;
            case 20:
                return 5700 * numberOfPlayers;
            default:
                System.out.println("Error in deadly case party xp threshold");
                return 0;
        }
    }

    private static int[] shuffle(int[] order) {
        int[] newOrder = new int[order.length];
        for (int i = 0; i < order.length; i++) {
            int index = new Random().nextInt(order.length - i);
            newOrder[i] = order[index];
            order[index] = order[order.length - i - 1];
        }
        return newOrder;
    }

    public synchronized Monster buildEncounter() throws IOException, JSONException {

        int[] order = new int[325];
        for (int i = 0; i < order.length; order[i] = ++i); // {1, 2, ..., 325}
        shuffledOrder = shuffle(order);

        /*
        To ensure randomness, we'll start looking at the monsters in a random order and return monster as soon as we find an acceptable match.
        Of course we could find the most accurate match every time, but
            a, that would be computively much more expensive, since we'd have to look at ALL the monsters and
            b, certain user inputs would yield repetitive outcomes (same monster all the time - not what we want)
        */
        Monster tempMonster;

        for (int index = 0; index < shuffledOrder.length; index++) {
            tempMonster = new Monster(shuffledOrder[index]); //the next tempMonster will use the memory of current one and after the for loop, garbage collector will get rid of the memory leak anyway
            float tolerableError = ((float) index / (float) shuffledOrder.length); //tolerable error is increasing linearly with every unsuccessful iteration (i.e. when monster does not suit the conditions)
            for (int numOfMonsters = minMonsters; numOfMonsters <= maxMonsters; numOfMonsters++) { //find the amount of monsters that suits (if any)
                double monsterXp = tempMonster.getXp() * getEncounterMultiplier(numOfMonsters) * numOfMonsters; //calculate this encounter's xp
                if (Math.abs(partyXpThreshold - monsterXp) < partyXpThreshold * tolerableError) { //is the encounter close enough with respect to the tolerable error?
                    //if yes, we're done.. just return the found monster type, remember the number of monsters and whatever else we're interested in
                    System.out.println("Monster XP " + monsterXp + " =? Party XP " + partyXpThreshold);
                    System.out.println("Had to check " + index + " monsters.");
                    System.out.println(numOfMonsters + "x " + tempMonster.getName());

                    setMonstersInEncounter(numOfMonsters);
                    setAccuracy(1.0f - (float) Math.abs(partyXpThreshold - monsterXp) / (float) partyXpThreshold);
                    return tempMonster;
                }
            }
        }

        return null; //.. if no monster fits the user's conditions
    }
}
