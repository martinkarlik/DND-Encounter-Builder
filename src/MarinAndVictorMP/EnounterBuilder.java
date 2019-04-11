package src.MarinAndVictorMP;

public class EnounterBuilder {
    int numberOfMonsters;
    int numberOfPlayers;
    // TODO needs the challenge difficulty
    // TODO take the player levels into account
    // TODO take the number of players into account
    // TODO Find the amount of exp given by the encounter

    public double EncounterMultiplier(int numberOfMonsters, int numberOfPlayers){
        double multiplier;
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
                multiplier = 0;
                break;
        }
        return multiplier;
    }

    public int PartyXpThreshold(int numberOfPlayers, int levelOfPlayers, String difficulty){
        int partyXpThreshold = 0;
        switch (difficulty){
            case "easy":
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
                break;
            case "medium":
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
                        System.out.println("got here");
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
            case "hard":
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
                break;
            case "deadly":
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
                break;
            default:
                System.out.println("Something went wrong with the party xp threshold");
                break;
        }
        return partyXpThreshold;
    }

}
