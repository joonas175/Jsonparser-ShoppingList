package fi.tamk.tiko.joonass;

import javafx.beans.property.SimpleStringProperty;

/**
 * Class for shopping list items
 *
 * These objects are used by the main shopping list class. This class contains the amount and name of
 * shopping list item.
 *
 * @author Joonas Salojarvi
 * @version 2018.12.04
 * @since 1.8
 */
public class ShoppingListItem {
    private final SimpleStringProperty amount;

    private final SimpleStringProperty itemName;

    public ShoppingListItem(String amount, String itemName){
        this.amount = new SimpleStringProperty(amount);
        this.itemName = new SimpleStringProperty(itemName);
    }

    public String getAmount(){
        return amount.get();
    }

    public String getItemName(){
        return itemName.get();
    }

    public void setAmount(String amount){
        this.amount.set(amount);
    }

    public void setItemName(String itemName){
        this.itemName.set(itemName);
    }
}
