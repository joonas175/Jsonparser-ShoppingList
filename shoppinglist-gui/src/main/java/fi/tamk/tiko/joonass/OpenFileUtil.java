package fi.tamk.tiko.joonass;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that handles opening shopping list files.
 *
 * Has only one method, which parses through a shopping list file and creates a new
 * shopping list out of it.
 * @author Joonas Salojarvi
 * @version 2018.12.18
 * @since 1.8
 */
public class OpenFileUtil {

    /**
     * Parses through given file and creates a new ObservableList out of it.
     *
     * Only supports this app's own format .slf
     *
     * @param file File to be opened
     * @return Shopping list as an ObservableList
     */
    public static ObservableList<ShoppingListItem> openShoppingList(File file) {
        ObservableList<ShoppingListItem> list = FXCollections.observableArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            while ((str = reader.readLine()) != null) {
                String[] temp = str.split(":");
                ShoppingListItem tempItem = new ShoppingListItem(temp[0],temp[1]);
                list.add(tempItem);
            }
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unable to open file");
            alert.setHeaderText("Unable to open file");
        }

        return list;
    }
}
