package com.example.appventadecochesvisual;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Camilo Martinez
 */

public class VentaApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(VentaApplication.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 440);
        stage.setTitle("Coches.ct");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.show();
    }
}