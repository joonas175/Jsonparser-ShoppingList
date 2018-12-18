package fi.tamk.tiko.joonass.jsonparser;

/**
 * Class used by all Json datatypes.
 *
 * All Json elements extend from this method. This method also handles creating Json objects from applicable regular
 * Java objects.
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public abstract class JsonElement<T>{

    /**
     * Json element's value
     */
    T value;

    public JsonElement(){
        this.value = null;
    }

    public JsonElement(T value){
        this.value = value;
    }

    /**
     * Returns value of this element
     * @return value
     */
    public T getValue(){
        return value;
    }

    /**
     * Sets a new value for this element
     * @param value new value
     */
    public void setValue(T value){
        this.value = value;
    }

    /**
     * All JsonElements must implement this method.
     *
     * Return value of JsonElement in correct format.
     * @return String representation of value
     */
    public abstract String toString();

    /**
     * Static method for creating new JsonElements from given objects.
     *
     * Supports string, numbers, other JsonObjects, JsonArrays and boolean values.
     * @param obj Object
     * @return JsonElement
     */
    public static JsonElement createElementFromObj(Object obj){
        JsonElement returnVal;
        if(obj instanceof String){
            returnVal = new JsonStringElement(obj.toString());
        } else if(obj instanceof Integer){
            returnVal = new JsonNumberElement((Integer) obj);
        } else if(obj instanceof Double){
            returnVal = new JsonNumberElement((Double) obj);
        } else if (obj instanceof JsonObject){
            returnVal = (JsonObject) obj;
        } else if (obj instanceof JsonArray){
            returnVal = (JsonArray) obj;
        } else if(obj instanceof Boolean){
            returnVal = new JsonBooleanElement((Boolean) obj);
        } else {
            return null;
        }
        return returnVal;
    }
}
