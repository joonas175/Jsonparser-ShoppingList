package fi.tamk.tiko.joonass.jsonparser;

/**
 * Json element for String datatype
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public class JsonStringElement extends JsonElement<String>{
    public JsonStringElement(String value){
        super(value);
    }

    public String toString(){
        return "\"" + value + "\"";
    }
}
