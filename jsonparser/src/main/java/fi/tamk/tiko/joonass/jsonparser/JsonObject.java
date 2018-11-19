package fi.tamk.tiko.joonass.jsonparser;



import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JsonObject extends JsonElement<LinkedHashMap>{
    LinkedHashMap<String,JsonElement> map;

    public JsonObject(){
        map = new LinkedHashMap<String, JsonElement>();
    }

    public void put(String key, Object value){
        if(value instanceof String){
            map.put(key, new JsonStringElement(value.toString()));
        } else if(value instanceof Integer){
            map.put(key, new JsonNumberElement((Integer) value));
        } else if(value instanceof Double){
            map.put(key, new JsonNumberElement((Double) value));
        } if(value instanceof JsonObject) {
            map.put(key, (JsonObject) value);
        } if(value == null){
            map.put(key, null);
        }
    }

    public String toString(){
        return JsonStringBuilder.build(this);
    }

    public Set getSet(){
        return map.keySet();
    }
    public Map getMap(){
        return map;
    }
}