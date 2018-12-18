package fi.tamk.tiko.joonass.jsonparser;

/**
 * WIP of JsonParser
 *
 * Doesn't work
 * @author Joonas Salojarvi
 * @version 2018.12.18
 * @since 1.8
 */
public class JsonParser {

    public int iterator;

    public String source;

    public JsonObject parseObjectFromString(String source) {
        this.source = source.trim().replace("\n", "");
        JsonObject parent = new JsonObject();
        while(iterator < source.length()){
            switch(source.charAt(iterator)){
                case '"': parent.put(parseKey(),"temp");

            }
            iterator++;
        }
        return parent;
    }

    private String parseKey(){
        String key = "";
        iterator++;
        while(source.charAt(iterator) != '"'){
            key += source.charAt(iterator);
            iterator++;
        }
        return key;
    }


}