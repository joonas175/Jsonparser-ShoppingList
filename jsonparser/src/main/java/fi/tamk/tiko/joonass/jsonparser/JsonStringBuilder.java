package fi.tamk.tiko.joonass.jsonparser;

/**
 * Formats given Json string to a more readable format.
 *
 * Adds spaces and newlines etc.
 *
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public class JsonStringBuilder {

    /**
     * Builds a beautiful string of the given JsonObject.
     *
     * Adds indents and line breaks to make the JSON more readable.
     * @param obj JsonObject
     * @return JsonObject in a more beautiful format.
     */
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


    /**
     * Method for adding tabs.
     *
     * To make build method more readable.
     * @param tabs Amount of tabs to be added
     * @return String of tabs
     */
    private static String addTabs(int tabs) {
        String returnVal = "";
        for(int i = 0; i < tabs; i++){
            returnVal += " ";
        }
        return returnVal;
    }

}
