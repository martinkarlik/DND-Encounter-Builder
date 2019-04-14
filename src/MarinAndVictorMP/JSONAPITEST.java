package src.MarinAndVictorMP;

import org.json.JSONException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class JSONAPITEST {


  public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
      URL monstersURL = new URL("http://dnd5eapi.co/api/Monsters/");
      EnounterBuilder enounterBuilder = new EnounterBuilder();
      Monsters.GetMonster(monstersURL + "37/");
      System.out.println("Name of the Monster: " + Monsters.name);
      System.out.println("AC: " + Monsters.AC);
      System.out.println("Saving throws: " +Monsters.savingThrows);
      System.out.println("CR: " + Monsters.challenge_rating);
      System.out.println("XP: " +Monsters.CrToXp(Monsters.challenge_rating));
      System.out.println(Monsters.alignment);
      Monsters.GetStats();
      System.out.println(Monsters.subtype);
      System.out.println(Monsters.senses);
      System.out.println(Monsters.damage_immunities);
      System.out.println(enounterBuilder.PartyXpThreshold(6,6,"medium"));
  }

  public static void BuildTheMonster(){

  }
}
