package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            Scene scene = new Scene(root);

            // FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1.fxml"));
            // Controller controller = loader.getController(); // This line of code gives me acces to all what's inside the controller class

            stage.setTitle("JavaFX Controls");
            stage.setScene(scene);
            stage.show();
            stage.toFront();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}