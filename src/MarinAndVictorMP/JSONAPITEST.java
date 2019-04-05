package src.MarinAndVictorMP;

import org.json.JSONException;
import java.io.IOException;
import java.net.MalformedURLException;


public class JSONAPITEST {

  public static void main(String[] args) throws MalformedURLException, IOException, JSONException {
      Monsters dragon = new Monsters("http://www.dnd5eapi.co/api/monsters/3/");
      System.out.println("Name of the Monster: " + dragon.name);
      System.out.println("AC: " + dragon.AC);
      System.out.println("Saving throws: " +dragon.savingThrows);
  }
}
