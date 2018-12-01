package fi.tamk.tiko.joonass.jsonparser;

public class JsonParser {

    public int iterator;

    public JsonObject parseObjectFromString(String source) {
        source = source.trim().replace("\n", "");

        return new JsonObject();
    }

}