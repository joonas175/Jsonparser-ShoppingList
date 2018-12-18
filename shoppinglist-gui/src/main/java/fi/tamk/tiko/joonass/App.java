package fi.tamk.tiko.joonass;

import fi.tamk.tiko.joonass.jsonparser.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;

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

    Stage stage;

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
        this.stage = stage;
        scene = createMainScene();
        initializeShoppingList();
        initializeButtons();
        initializeBottomRow();

        stage.setTitle("Shopping list app");
        stage.setScene(scene);
        stage.show();
    }

    private void initializeBottomRow() {
        HBox bottomRow = new HBox();
        mainPane.setBottom(bottomRow);
        TextField amountInput = new TextField("Amount");
        amountInput.setMaxWidth(tableView.getMaxWidth() / 5);

        TextField nameInput = new TextField("Item");
        nameInput.setMaxWidth((tableView.getMaxWidth() * 4) / 5);
        bottomRow.getChildren().addAll(amountInput, nameInput);

        Button addButton = new Button("Add");
        bottomRow.getChildren().add(addButton);

        for(Node node : bottomRow.getChildren()){
            bottomRow.setMargin(node, new Insets(3,10,3,2));
        }

        addButton.setDefaultButton(true);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!(nameInput.getText().equals(""))){
                    shoppingList.add(new ShoppingListItem(amountInput.getText(), nameInput.getText()));
                    amountInput.setText("");
                    nameInput.setText("");
                }
            }
        });


    }


    /**
     * Sets up buttons on the window.
     */
    private void initializeButtons() {
        VBox vbox = new VBox();



        Button remove = new Button("Remove selected");
        vbox.getChildren().add(remove);
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shoppingList.remove(tableView.getSelectionModel().getSelectedItem());
            }
        });

        vbox.setPadding(new Insets(6));
        mainPane.setRight(vbox);
    }

    /**
     * Removes item from the shopping list.
     */

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

        amountColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        amountColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ShoppingListItem, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ShoppingListItem, String> t) {
                        ((ShoppingListItem) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setAmount(t.getNewValue());
                    }
                }
        );
        itemColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        itemColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ShoppingListItem, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ShoppingListItem, String> t) {
                        ((ShoppingListItem) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setItemName(t.getNewValue());
                    }
                }
        );



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


        MenuItem saveShoppingList = new MenuItem("Save shopping list");
        file.getItems().add(saveShoppingList);
        saveShoppingList.setOnAction((e) -> saveShoppingListEvent());

        /*MenuItem saveToTXT = new MenuItem("Save to .txt as JSON");
        save.getItems().add(saveToTXT);
        saveToTXT.setOnAction((e) -> saveToTXTEvent());*/

        MenuItem openFile = new MenuItem("Open shopping list");
        file.getItems().add(openFile);
        openFile.setOnAction((e) -> openFileEvent());

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> Platform.exit());
        file.getItems().add(exit);


        return menubar;
    }

    private void openFileEvent() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open .slf");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Shopping list file (.slf)", "*.slf"));
        File file = fileChooser.showOpenDialog(stage);
        shoppingList = OpenFileUtil.openShoppingList(file);
        tableView.setItems(shoppingList);
    }

    private void saveShoppingListEvent() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save as shopping list file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Shopping list file (.slf)", "*.slf"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON (.txt)", "*.txt"));
        File file = fileChooser.showSaveDialog(stage);
        System.out.println(file.getAbsolutePath());
        if(file.getAbsolutePath().endsWith(".txt")){
            SavingUtil.saveAsJSON(file, shoppingList);
        } else if(file.getAbsolutePath().endsWith(".slf")){
            SavingUtil.saveShoppingList(file, shoppingList);
        }

    }

}

