package fi.tamk.tiko.joonass;

import fi.tamk.tiko.joonass.jsonparser.JsonArray;
import fi.tamk.tiko.joonass.jsonparser.JsonFileWriter;
import fi.tamk.tiko.joonass.jsonparser.JsonStringBuilder;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fi.tamk.tiko.joonass.jsonparser.JsonObject;

/**
 * Class for saving the shopping list in JSON format in a text file
 *
 * Currently supports only JSON format as a txt file.
 *
 * @author Joonas Salojarvi
 * @version 2018.12.04
 * @since 1.8
 */
public class SavingUtil {

    /**
     * Method for saving shopping list as a txt file in JSON format.
     *
     * @param file File to be saved
     * @param shoppingList The shopping list to be saved
     */
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

    /**
     * Writes an .slf file out of the given shopping list.
     *
     * @param file File to be saved as
     * @param shoppingList Shopping list to be saved
     */
    public static void saveShoppingList(File file, ObservableList<ShoppingListItem> shoppingList) {
        String toBeSaved = "";
        for(ShoppingListItem item : shoppingList){
            toBeSaved += item.getAmount() + ":" + item.getItemName() + "\n";
        }

        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(toBeSaved);
            writer.close();
        } catch (IOException e){
            System.out.println("Could not write to file:");
            e.printStackTrace();
        }

    }

}
