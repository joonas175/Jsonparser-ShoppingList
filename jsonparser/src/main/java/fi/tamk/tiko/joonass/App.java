package fi.tamk.tiko.joonass;

import fi.tamk.tiko.joonass.jsonparser.JsonArray;
import fi.tamk.tiko.joonass.jsonparser.JsonFileWriter;
import fi.tamk.tiko.joonass.jsonparser.JsonObject;
import fi.tamk.tiko.joonass.jsonparser.JsonStringBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JsonObject obj = new JsonObject();
        obj.put("Name", "Jaska");
        obj.put("Ikä", 6);
        obj.put("Kikkelinpituus", 0.2);
        obj.put("Mies", true);
        JsonObject obj2 = new JsonObject();
        obj2.put("Name", "Jaska");
        obj2.put("Ikä", 6);
        obj2.put("Kikkelinpituus", 0.2);
        JsonObject obj3 = new JsonObject();
        obj3.put("Name", "Jaska");
        obj3.put("Ikä", 6);
        obj3.put("Kikkelinpituus", 0.2);
        obj2.put("kolmasjaska", obj3);
        obj.put("ToinenJaska", obj2);
        obj.put("Nulliarvo", null);
        JsonArray array = new JsonArray("asd", 1, 5, 1, true);
        obj.putArray("Taulukko", "asd", array);
        //System.out.println(JsonStringBuilder.build(obj));
        System.out.println(obj.toString());
        System.out.println(JsonStringBuilder.build(obj));
        JsonFileWriter writer = new JsonFileWriter("test.txt");
        writer.write(obj,false);
    }
}
