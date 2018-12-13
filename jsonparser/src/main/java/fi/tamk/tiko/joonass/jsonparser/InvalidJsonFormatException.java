package fi.tamk.tiko.joonass.jsonparser;


/**
 * Exception to be thrown when Jsonparser can't parse  a string.
 *
 * @author Joonas Salojarvi
 * @version 2018.12.04
 * @since 1.8
 */
public class InvalidJsonFormatException extends RuntimeException{
    public InvalidJsonFormatException(String e){
        super(e);
    }

}
