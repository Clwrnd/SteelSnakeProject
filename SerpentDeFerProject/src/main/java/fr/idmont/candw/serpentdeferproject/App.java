package fr.idmont.candw.serpentdeferproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
    Scene scene = new Scene(new InterfaceBody(stage), 500, 500);
    stage.setScene(scene);
    stage.setTitle("Serpent de Fer");
    stage.show();  
    }

    public static void main(String[] args) {
        launch();
    }

}