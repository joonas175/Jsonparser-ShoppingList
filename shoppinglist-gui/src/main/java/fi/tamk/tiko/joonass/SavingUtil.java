package fi.tamk.tiko.joonass;

import fi.tamk.tiko.joonass.jsonparser.JsonArray;
import fi.tamk.tiko.joonass.jsonparser.JsonFileWriter;
import javafx.collections.ObservableList;

import java.io.File;
import fi.tamk.tiko.joonass.jsonparser.JsonObject;

public class SavingUtil {
    public static void saveAsJSON(File file, ObservableList<ShoppingListItem> shoppingList) {
        JsonObject parent = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for(ShoppingListItem item : shoppingList){
            JsonObject temp = new JsonObject();
            temp.put("itemName", item.getItemName());
            temp.put("amount", item.getAmount());
            jsonArray.addToArray(temp);
        }
        parent.put("shoppingList", jsonArray);

        JsonFileWriter fileWriter = new JsonFileWriter(file);
        fileWriter.write(parent ,false);

    }
}
