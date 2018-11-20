package fi.tamk.tiko.joonass.jsonparser;

/**
 * Class for number type Json objects (Integer, Double)
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
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
