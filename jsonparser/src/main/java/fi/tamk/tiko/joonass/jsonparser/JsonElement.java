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
        if(obj instanceof String){
            returnVal = new JsonStringElement(obj.toString());
        } else if(obj instanceof Integer){
            returnVal = new JsonNumberElement((Integer) obj);
        } else if(obj instanceof Double){
            returnVal = new JsonNumberElement((Double) obj);
        } else {
            return null;
        }
        return returnVal;
    }
}
