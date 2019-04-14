package src.MartinAndVictorMP;

import org.json.JSONException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONAPITEST {
    public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
      URL monstersURL = new URL("http://dnd5eapi.co/api/Monsters/");
      Monsters.GetMonster(monstersURL, "47/");
      Monsters.GetStats();
      System.out.println(EncounterBuilder.PartyXpThreshold("deadly", 6, 4));
  }

  public static void BuildTheMonster(){
        // Maybe not necessary but it might be needed to just do all of the different functions in one call
  }
}
