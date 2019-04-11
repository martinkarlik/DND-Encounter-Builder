package src.MarinAndVictorMP;

import org.json.JSONException;
import java.io.IOException;
import java.net.MalformedURLException;


public class JSONAPITEST {

  public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
      Monsters dragon = new Monsters("http://www.dnd5eapi.co/api/monsters/57/");
      System.out.println("Name of the Monster: " + dragon.name);
      System.out.println("AC: " + dragon.AC);
      System.out.println("Saving throws: " +dragon.savingThrows);
      System.out.println("CR: " + dragon.challenge_rating);
      System.out.println("XP: " +dragon.CrToXp(dragon.challenge_rating));
      System.out.println(dragon.alignment);
      dragon.GetStats();
      System.out.println(dragon.subtype);
      System.out.println(dragon.senses);
      System.out.println(dragon.damage_immunities);

  }
}
