package fi.tamk.tiko.joonass;

import fi.tamk.tiko.joonass.jsonparser.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Main class for UI of ShoppingList app
 *
 * This class handles the creation and launch of the UI
 * @author Joonas Salojarvi
 * @version 2018.11.20
 * @since 1.8
 */
public class App extends Application
{
    /**
     * The shopping list itself
     */
    TableView<ShoppingListItem> tableView;

    ObservableList<ShoppingListItem> shoppingList;

    /**
     * Pane for handling the place of elements on the app
     */
    BorderPane mainPane;

    /**
     * Main scene
     */
    Scene scene;


    /**
     * Main method for starting the JavaFX Application
     * @param args Launch arguments
     */
    public static void main( String[] args )
    {
        System.out.println("Author: Joonas Salojarvi");
        JsonObject obj = new JsonObject();
        //For testing dependency
        obj.put("Stringi:", "asd");
        Application.launch(args);
    
    }

    /**
     * Method to be called when starting the application.
     *
     * Handles calling other methods for JavaFX object creation.
     * Sets up the scene.
     * @param stage Primary window
     */
    public void start(Stage stage) {
        scene = createMainScene();
        initializeShoppingList();
        initializeButtons();

        stage.setTitle("Shopping list app");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Sets up buttons on the window.
     */
    private void initializeButtons() {
        VBox vbox = new VBox();


        Button add = new Button("Add");
        vbox.getChildren().add(add);

        Button modify = new Button("Modify");
        vbox.getChildren().add(modify);

        Button remove = new Button("Remove");
        vbox.getChildren().add(remove);

        mainPane.setRight(vbox);
    }

    /**
     * Removes item from the shopping list.
     */
    /*private void removeItem() {
        listView.getItems().remove(listView.getFocusModel().getFocusedItem());
    }*/

    /**
     * Creates the shopping list
     *
     * Initializes the JavaFX list view used as a shopping list.
     */
    private void initializeShoppingList() {
        tableView = new TableView();
        tableView.setMaxWidth(300);
        tableView.setEditable(true);

        mainPane.setCenter(tableView);
        mainPane.setAlignment(tableView, Pos.CENTER_LEFT);

        TableColumn amountColumn = new TableColumn("Amount");
        amountColumn.setMinWidth(tableView.getMaxWidth() / 5);
        TableColumn itemColumn = new TableColumn("Item");
        itemColumn.setMinWidth((tableView.getMaxWidth() * 4) / 5);


        amountColumn.setCellValueFactory(new PropertyValueFactory<ShoppingListItem,String>("amount"));
        itemColumn.setCellValueFactory(new PropertyValueFactory<ShoppingListItem,String>("itemName"));

        shoppingList = FXCollections.observableArrayList();
        tableView.setItems(shoppingList);

        tableView.getColumns().addAll(amountColumn, itemColumn);


    }

    /**
     * Initializes the main scene
     *
     * Creates the core elements of the main scene, like BorderPane
     * @return The scene that was created in this method
     */
    public Scene createMainScene(){
        mainPane = new BorderPane();
        mainPane.setTop(createMenuBar());
        Scene scene = new Scene(mainPane, 400, 400);
        return scene;
    }

    /**
     * Initializes the menu bar
     *
     * Adds needed elements for menu bar
     * @return Menubar that was created in this method
     */
    private MenuBar createMenuBar() {
        MenuBar menubar = new MenuBar();

        Menu file = new Menu("File");
        menubar.getMenus().add(file);

        Menu save = new Menu("Save");
        menubar.getMenus().add(save);


        MenuItem saveToTXT = new MenuItem("Save to .txt");
        save.getItems().add(saveToTXT);

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> Platform.exit());
        file.getItems().add(exit);


        return menubar;
    }

}
