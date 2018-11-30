package fi.tamk.tiko.joonass;

import javafx.beans.property.SimpleStringProperty;

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
