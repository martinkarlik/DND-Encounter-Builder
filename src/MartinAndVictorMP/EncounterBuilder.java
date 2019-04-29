package src.MartinAndVictorMP;

import org.json.JSONException;
import java.io.IOException;

public class EncounterBuilder extends Thread {

    Encounter encounter;

    public EncounterBuilder(Encounter encounter) {
        this.encounter = encounter;
    }

    public void run() {
        try {
            encounter.buildEncounter();
            Monster monster = encounter.getMonster();
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public Encounter getEncounter() {
        return encounter;
    }



}
