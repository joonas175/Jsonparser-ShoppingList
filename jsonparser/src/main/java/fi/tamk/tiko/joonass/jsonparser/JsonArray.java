package fi.tamk.tiko.joonass.jsonparser;

import java.util.ArrayList;

public class JsonArray extends JsonElement {

    ArrayList<Object> values;

    public JsonArray(){
        values = new ArrayList<Object>();
    }

    public void addToArray(Object element){
        values.add(element);
    }

    @Override
    public String toString() {
        return null;
    }
}
