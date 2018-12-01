package fi.tamk.tiko.joonass.jsonparser;

public class JsonParser {

    public static int iterator;

    public JsonObject parseObjectFromString(String source){
        source = source.trim().replace("\n","");


        JsonObject parentJsonObj = new JsonObject();

        if(source.charAt(0) != '{'){
            InvalidJsonFormatException e = new InvalidJsonFormatException("JsonObject: invalid start of JsonObject");
            throw e;
        }
        if(source.charAt(source.length() - 1) != '}'){
            InvalidJsonFormatException e = new InvalidJsonFormatException("JsonObject: missing or invalid end character");
            throw e;
        }

        iterator = 1;

        while(iterator < source.length()){
            if(source.charAt(iterator) == '"'){
                iterator++;
                String nextKey = parseKey(source);
                String nextElement = parseElement(source);
                parentJsonObj.put(nextKey, nextElement);
            } else {
                iterator++;
            }

        }

        return parentJsonObj;
    }



    private static String parseKey(String source) {
        String ret = "";
        for(int i = iterator; source.charAt(i) != '"'; i++){
            ret += source.charAt(i);
            iterator++;
        }
        iterator++;
        return ret;
    }

    private static String parseElement(String source){
        String retString = "";
        if(source.charAt(iterator) != ':'){
            InvalidJsonFormatException e = new InvalidJsonFormatException("");
            throw e;
        } else {
            iterator++;
        }

        if(source.charAt(iterator) == '{'){
            retString += "{";
            int inception = 1;
            while(inception > 0){
                if(source.charAt(iterator) == '{'){
                    inception++;
                } else if (source.charAt(iterator) == '}'){
                    inception--;
                }
                retString += source.charAt(iterator);
                iterator++;
            }

        } else if (source.charAt(iterator) == '['){

        } else {
            while(source.charAt(iterator) != ',' && source.charAt(iterator) != '}'){
                retString += source.charAt(iterator);
                iterator++;
            }
        }
        return retString;
    }



}
