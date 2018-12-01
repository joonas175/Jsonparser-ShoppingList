package fi.tamk.tiko.joonass.jsonparser;

public class InvalidJsonFormatException extends RuntimeException{
    public InvalidJsonFormatException(String e){
        super(e);
    }

}
