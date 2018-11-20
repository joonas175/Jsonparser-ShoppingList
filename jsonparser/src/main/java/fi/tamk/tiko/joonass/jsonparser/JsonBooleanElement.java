package fi.tamk.tiko.joonass.jsonparser;

/**
 * Class for boolean datatype Json elements
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public class JsonBooleanElement extends JsonElement<Boolean> {
    public JsonBooleanElement(Boolean value){
        super(value);
    }

    public String toString(){
        return value + "";
    }
}
