package fi.tamk.tiko.joonass.jsonparser;

public class JsonNumberElement extends JsonElement<Number>{
    public JsonNumberElement(Integer value){
        super(value);
    }
    public JsonNumberElement(Double value){
        super(value);
    }

    public String toString(){
        return value.toString();
    }
}
