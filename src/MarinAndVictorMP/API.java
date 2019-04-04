package src.MarinAndVictorMP;

import java.net.*;
import java.io.*;

public class API {


    public static void main(String[] args) throws IOException {
        URL url = new URL("http://dnd5eapi.co/api/");
        String query = "Monsters/325";


        URL urlQuery = new URL(url + query);
        URLConnection urlc = urlQuery.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        String l;
        while ((l = br.readLine()) != null){
            System.out.println(l);

        }
        br.close();



    }
}

