package fi.tamk.tiko.joonass.jsonparser;

public class JsonBooleanElement extends JsonElement<Boolean> {
    public JsonBooleanElement(Boolean value){
        super(value);
    }

    public String toString(){
        return value + "";
    }
}
