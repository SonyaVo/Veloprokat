package com.example.veloprokat;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class StartSceneApplication extends Application {

    //public ArrayList<String> list = new ArrayList<String>();


    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));

        Scene scene = new Scene(root, 701, 601);
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }

}
