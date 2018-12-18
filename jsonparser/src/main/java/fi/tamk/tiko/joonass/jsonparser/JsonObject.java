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
    /**
     * Hashmap of all the elements contained in this object.
     */
    LinkedHashMap<String,JsonElement> map;

    public JsonObject(){
        map = new LinkedHashMap<String, JsonElement>();
    }

    /**
     * Adds a new element inside this object.
     *
     * Calls JsonElements static method to create a new JsonElement from given object.
     * @param key key
     * @param value value to be converted into JsonElement
     */
    public void put(String key, Object value){

        if(value instanceof JsonObject) {
            map.put(key, (JsonObject) value);
        } else {
            map.put(key, JsonElement.createElementFromObj(value));
        }
    }


    /**
     * Adds a series of values into this object as an array.
     *
     * Creates a new JsonArray.
     *
     * @param key key
     * @param values All objects to be added as an array
     */
    public void putArray(String key, Object... values){
        JsonArray array = new JsonArray();
        for (Object element : values) {
            array.addToArray(JsonElement.createElementFromObj(element));
        }
        map.put(key, array);

    }

    /**
     * Returns this JsonObject as a string, in correct JSON format.
     *
     * @return This object as JSON
     */
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

    /**
     * Returns all keys in this object's hashmap as a set.
     * @return keyset
     */
    public Set getSet(){
        return map.keySet();
    }

    /**
     * Returns whole hashmap of this object
     * @return hashmap
     */
    public Map getMap(){
        return map;
    }
}