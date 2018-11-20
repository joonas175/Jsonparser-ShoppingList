package fi.tamk.tiko.joonass.jsonparser;



import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Json object class, which contains keys and elements linked together.
 *
 * Utilizes LinkedHashMap to connect key and element. All element types in this package are supported, even
 * other Json objects.
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public class JsonObject extends JsonElement<LinkedHashMap>{
    LinkedHashMap<String,JsonElement> map;

    public JsonObject(){
        map = new LinkedHashMap<String, JsonElement>();
    }

    public void put(String key, Object value){
        /*if(value instanceof String){
            map.put(key, new JsonStringElement(value.toString()));
        } else if(value instanceof Integer){
            map.put(key, new JsonNumberElement((Integer) value));
        } else if(value instanceof Double){
            map.put(key, new JsonNumberElement((Double) value));
        } if(value instanceof JsonObject) {
            map.put(key, (JsonObject) value);
        } if(value == null){
            map.put(key, null);
        }*/

        if(value instanceof JsonObject) {
            map.put(key, (JsonObject) value);
        } else {
            map.put(key, JsonElement.createElementFromObj(value));
        }
    }

    public void putArray(String key, Object... values){
        JsonArray array = new JsonArray();
        for (Object element : values) {
            array.addToArray(JsonElement.createElementFromObj(element));
        }
        map.put(key, array);

    }

    public String toString(){
        String ret = "{";
        for(int i = 0; i < map.keySet().size(); i++){
            ret += "\"" + map.keySet().toArray()[i] + "\":" + map.get(map.keySet().toArray()[i]);
            if(i < map.keySet().size() - 1){
                ret += ",";
            }
        }
        ret += "}";
        return ret;
    }

    public Set getSet(){
        return map.keySet();
    }
    public Map getMap(){
        return map;
    }
}