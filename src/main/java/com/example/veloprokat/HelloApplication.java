package com.example.veloprokat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 612, 200);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        FXMLLoader loader = new FXMLLoader(Bikes.class.getResource("bikes.fxml")); // create and load() view
        stage.show();
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}