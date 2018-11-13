package fi.tamk.tiko.joonass.jsonparser;

import java.util.Set;

public class JsonStringBuilder {

    public static String build(JsonObject obj){
        return "{\n" + build(obj, 0) + "}";
    }

    private static String build(JsonObject obj, int tabs){
        String ret = "";
        Set<String> keySet = obj.getSet();
        for(String key : keySet){
            if(obj.getMap().get(key) instanceof JsonObject){
                ret += addTabs(tabs);
                ret += "  \"" + key + "\": {\n"+ build((JsonObject) obj.getMap().get(key), tabs + 2);
                ret += addTabs(tabs + 2) + "}\n";
            } else {
                ret += addTabs(tabs);
                ret += String.format("  \"%s\": %s,\n", key, (JsonElement) obj.getMap().get(key));

            }
        }

        return ret;
    }

    private static String addTabs(int tabs) {
        String returnVal = "";
        for(int i = 0; i < tabs; i++){
            returnVal += " ";
        }
        return returnVal;
    }

}
