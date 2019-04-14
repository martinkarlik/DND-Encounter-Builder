package src.MarinAndVictorMP;

public class EncounterBuilder {
    // Maybe we should use an ArrayList for the players instead of the Int?
    private int numberOfMonsters;
    private int numberOfPlayers;
    private String difficulty;
    private static int partyXpThreshold;

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }

    public void setNumberOfMonsters(int numberOfMonsters) {
        this.numberOfMonsters = numberOfMonsters;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }


    // Gets the different multipliers that are required if there are more than one monster
    public static double EncounterMultiplier(int numberOfMonsters, int numberOfPlayers){
        double multiplier = 1;
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
                default:
                    multiplier = 1;
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
                case 2:
                    multiplier = 1;
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
                default:
                    multiplier = 1;
                    break;
            }
        }
        return multiplier;
    }

    // The actual xp that the encounter gives, takes monster xp and amount of monsters and multiplier into account
    // This is the number that should match closely up with the table for encounters. Page 82 in the DM's guide
    public static int GivenEncounterXp(int monsterXp, double multiplier, int numberOfMonsters){
        int encounterXp = (int) ((monsterXp * multiplier) * numberOfMonsters);
        return encounterXp;
    }

    // Gets the party xp threshold by getting the number of players and taking into account the difficulty
    // This is the number that the monsters xp should be as close to as possible.
    public static int PartyXpThreshold( String difficulty, int levelOfPlayers, int numberOfPlayers){
        switch (difficulty){
            case "easy":
                NestedEasy(levelOfPlayers, numberOfPlayers);
                break;
            case "medium":
                NestedMedium(levelOfPlayers, numberOfPlayers);
                break;
            case "hard":
                NestedHard(levelOfPlayers, numberOfPlayers);
                break;
            case "deadly":
                NestedDeadly(levelOfPlayers, numberOfPlayers);
                break;
            default:
                System.out.println("Something went wrong with the party xp threshold");
                break;
        }
        return partyXpThreshold;
    }

    // This is done for readability
    private static void NestedEasy(int levelOfPlayers, int numberOfPlayers) {
        switch (levelOfPlayers){
            case 1:
                partyXpThreshold = (25 * numberOfPlayers);
                System.out.println("Got to easy" + partyXpThreshold);
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

    private static void NestedMedium(int levelOfPlayers, int numberOfPlayers) {
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

    private static void NestedHard(int levelOfPlayers, int numberOfPlayers) {
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

    private static void NestedDeadly(int levelOfPlayers, int numberOfPlayers) {
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

    // TODO min max monsters
    // TODO monster type
    // TODO button to build the encounter

}
