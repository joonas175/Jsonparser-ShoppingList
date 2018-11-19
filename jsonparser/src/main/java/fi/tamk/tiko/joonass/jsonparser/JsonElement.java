package fi.tamk.tiko.joonass.jsonparser;

public abstract class JsonElement<T>{

    T value;

    public JsonElement(){
        this.value = null;
    }

    public JsonElement(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public abstract String toString();

    public static JsonElement createElementFromObj(Object obj){
        JsonElement returnVal;
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
        return returnVal;
    }
}
