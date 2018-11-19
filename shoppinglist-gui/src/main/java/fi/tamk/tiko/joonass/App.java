package fi.tamk.tiko.joonass;

import fi.tamk.tiko.joonass.jsonparser.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    ListView listView;
    BorderPane mainPane;
    Scene scene;


    public static void main( String[] args )
    {
        System.out.println( "" );
        Application.launch(args);
    
    }
    public void start(Stage stage) {
        scene = createMainScene();
        initializeShoppingList();
        initializeButtons();

        stage.setTitle("Shopping list app");
        stage.setScene(scene);
        stage.show();
    }

    private void initializeButtons() {
        VBox vbox = new VBox();


        Button add = new Button("Add");
        vbox.getChildren().add(add);

        Button modify = new Button("Modify");
        vbox.getChildren().add(modify);

        Button remove = new Button("Remove");
        remove.setOnAction((e) -> removeItem());
        vbox.getChildren().add(remove);

        mainPane.setRight(vbox);
    }

    private void removeItem() {
        listView.getItems().remove(listView.getFocusModel().getFocusedItem());
    }

    private void initializeShoppingList() {
        listView = new ListView();
        listView.setMaxWidth(300);

        mainPane.setCenter(listView);
        mainPane.setAlignment(listView, Pos.CENTER_LEFT);
        listView.getItems().add(new Text("Test"));
        listView.getItems().add(new Text("Test"));



    }

    public Scene createMainScene(){
        mainPane = new BorderPane();
        mainPane.setTop(createMenuBar());
        Scene scene = new Scene(mainPane, 400, 400);
        return scene;
    }

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
