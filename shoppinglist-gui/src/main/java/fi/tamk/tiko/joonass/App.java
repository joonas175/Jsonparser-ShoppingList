package fi.tamk.tiko.joonass;

import fi.tamk.tiko.joonass.jsonparser.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Application.launch(args);
    
    }
    public void start(Stage stage) {
        Group group = new Group();
        Scene scene = new Scene(group, 400, 300);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }


}
