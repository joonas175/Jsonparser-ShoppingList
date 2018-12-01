package fi.tamk.tiko.joonass.jsonparser;

public class JsonParser {


    public static JsonObject parseObjectFromString(String source){
        source = source.trim().replace("\n","");


        JsonObject parentJsonObj = new JsonObject();

        if(source.charAt(0) != '{'){
            InvalidJsonFormatException e = new InvalidJsonFormatException("Invalid start of JsonObject");
            throw e;
        }
        if(source.charAt(source.length() - 1) != '}'){
            InvalidJsonFormatException e = new InvalidJsonFormatException("JsonObject: missing or invalid end character");
            throw e;
        }
        for(int i = 1; source.charAt(i) != '}'; i++){
            int nextStart;
            int nextEnd;
        }

        return parentJsonObj;
    }


}
