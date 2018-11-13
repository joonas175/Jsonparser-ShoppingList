package fi.tamk.tiko.joonass.jsonparser;

public class JsonStringElement extends JsonElement<String>{
    public JsonStringElement(String value){
        super(value);
    }

    public String toString(){
        return "\"" + value + "\"";
    }
}
