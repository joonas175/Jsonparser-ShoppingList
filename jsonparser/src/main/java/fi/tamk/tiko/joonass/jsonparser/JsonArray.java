package fi.tamk.tiko.joonass.jsonparser;

import java.util.ArrayList;

/**
 * Class used for Json arrays.
 *
 * This class handles storing Json arrays. It also returns arrays as Json strings.
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public class JsonArray extends JsonElement {

    /**
     * All JsonElements contained in this class
     */
    ArrayList<JsonElement> values;

    public JsonArray(){
        values = new ArrayList<JsonElement>();
    }

    public JsonArray(Object... objects){
        values = new ArrayList<JsonElement>();
        for(Object obj : objects) {
            addToArray(JsonElement.createElementFromObj(obj));
        }
    }

    /**
     * Adds a new element to the array
     * @param element
     */
    public void addToArray(JsonElement element){
        values.add(element);
    }

    @Override
    public String toString() {
        String ret = "[";
        for(int i = 0; i < values.size(); i++){
            ret += values.get(i).toString();
            if(i < values.size() - 1){
                ret += ",";
            }
        }
        /*for(JsonElement element : values){
            ret += element + ",";
        }*/
        ret += "]";
        return ret;
    }

    /**
     * Returns the array
     * @return Array of JsonElements in this class
     */
    public ArrayList<JsonElement> getArray(){
        return values;
    }


}
