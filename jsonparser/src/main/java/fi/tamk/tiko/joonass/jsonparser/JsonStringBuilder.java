package fi.tamk.tiko.joonass.jsonparser;


public class JsonStringBuilder {

    public static String build(JsonObject obj){
        String json = "";
        int indent = 0;
        char[] chars = obj.toString().toCharArray();
        for(char nextChar : chars){
            switch(nextChar) {
                case '{':
                    json += nextChar + "\n";
                    indent += 2;
                    json += addTabs(indent);
                    break;

                case '}':
                    indent -= 2;
                    json += "\n" + addTabs(indent) + nextChar;
                    break;

                case ',':
                    json += nextChar + "\n" + addTabs(indent);
                    break;

                case '[':
                    indent += 2;
                    json +=  nextChar + "\n" + addTabs(indent);
                    break;

                case ']':
                    indent -= 2;
                    json += "\n" + addTabs(indent) + nextChar;
                    break;

                case ':':
                    json += nextChar + " ";
                    break;

                default:
                    json += nextChar;
                    break;
            }
        }

        return json;
    }



    private static String addTabs(int tabs) {
        String returnVal = "";
        for(int i = 0; i < tabs; i++){
            returnVal += " ";
        }
        return returnVal;
    }

}
