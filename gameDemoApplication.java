/**
 * ==============================================================================================
 * PROGRAM PURPOSE: Create the game application
 * ===============================================================================================
 */
package com.example.gamedemo;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class gameDemoApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        // set Parent root to game fxml.
        Parent root = FXMLLoader.load(getClass().getResource("gameTest2.fxml"));

        // set scene to root, set stage, and show.
        Scene scene = new Scene(root);
        stage.setTitle("Game Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
