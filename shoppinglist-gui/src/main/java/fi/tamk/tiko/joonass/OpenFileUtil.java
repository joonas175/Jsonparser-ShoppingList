package fi.tamk.tiko.joonass;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OpenFileUtil {

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
