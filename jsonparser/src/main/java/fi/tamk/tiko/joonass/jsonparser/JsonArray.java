package fi.tamk.tiko.joonass.jsonparser;

import java.util.ArrayList;

public class JsonArray extends JsonElement {

    ArrayList<JsonElement> values;

    public JsonArray(){
        values = new ArrayList<JsonElement>();
    }

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

    public ArrayList<JsonElement> getArray(){
        return values;
    }


}
