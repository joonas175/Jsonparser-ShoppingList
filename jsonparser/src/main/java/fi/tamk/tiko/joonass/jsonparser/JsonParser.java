package fi.tamk.tiko.joonass.jsonparser;

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
        //parse key
        String key = "";
        iterator++;
        while(source.charAt(iterator) != '"'){
            key += source.charAt(iterator);
            iterator++;
        }
        return key;
    }


}