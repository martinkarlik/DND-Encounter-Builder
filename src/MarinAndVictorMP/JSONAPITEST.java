package src.MarinAndVictorMP;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class JSONAPITEST {



  public static void main(String[] args) throws MalformedURLException, IOException, JSONException {

      URL url = new URL("http://www.dnd5eapi.co/api/monsters/7");
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
          while((inputLine = in.readLine()) != null){
              response.append(inputLine);
          } in.close();

          //System.out.println(response.toString());

          JSONObject jsonObject = new JSONObject(response.toString());
          System.out.println("After reading JSON response");
          System.out.println("Name: " + jsonObject.getString("name"));
          System.out.println("Size: " + jsonObject.getString("size"));
          System.out.println("type: " + jsonObject.getString("type"));
          System.out.println("AC: " + jsonObject.getInt("armor_class"));
          System.out.println("HP: " + jsonObject.getInt("hit_points"));
          System.out.println("Speed: " + jsonObject.getString("speed"));
          System.out.println("Strength: " + jsonObject.getInt("strength"));
          System.out.println("Dexterity: " + jsonObject.getInt("dexterity"));
          System.out.println("Constitution: " + jsonObject.getInt("constitution"));
          System.out.println("Intelligence: " + jsonObject.getInt("intelligence"));
          System.out.println("Wisdom: " + jsonObject.getInt("wisdom"));
          System.out.println("Charisma: " + jsonObject.getInt("charisma"));

      }
  }
}
