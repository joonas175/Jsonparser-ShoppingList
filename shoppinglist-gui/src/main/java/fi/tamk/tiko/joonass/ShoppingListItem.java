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

    /**
     * Amount of the item
     */
    private final SimpleStringProperty amount;

    /**
     * Name of the item
     */
    private final SimpleStringProperty itemName;

    /**
     * Main constructor for new item
     * @param amount Amount of item
     * @param itemName Name of item
     */
    public ShoppingListItem(String amount, String itemName){
        this.amount = new SimpleStringProperty(amount);
        this.itemName = new SimpleStringProperty(itemName);
    }

    /**
     * Return amount of the item
     * @return amount
     */
    public String getAmount(){
        return amount.get();
    }

    /**
     * Returns name of the item
     * @return name
     */
    public String getItemName(){
        return itemName.get();
    }

    /**
     * Set a new amount for the item
     * @param amount new amount
     */
    public void setAmount(String amount){
        this.amount.set(amount);
    }

    /**
     * Sets a new name for the item
     * @param itemName new name
     */
    public void setItemName(String itemName){
        this.itemName.set(itemName);
    }
}
