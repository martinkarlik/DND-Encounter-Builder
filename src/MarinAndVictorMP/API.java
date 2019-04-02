package MarinAndVictorMP;

import netscape.javascript.JSObject;
import java.net.*;
import java.io.*;

public class API {

    JSObject json;

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://dnd5eapi.co/api/");
        String query = "Monsters/268";


        URL urlQuery = new URL(url + query);
        URLConnection urlc = urlQuery.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(urlc.getInputStream()));
        String l;
        while ((l=br.readLine())!=null){
            System.out.println(l);

        }
        br.close();

    }
}

<<<<<<< HEAD:src/API.java

=======
//adding a comment
// adding another comment
>>>>>>> e4d3808b3916f9ff19a22824986e09e44c8eca48:src/MarinAndVictorMP/API.java
