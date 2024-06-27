package com.example.veloprokat;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class StartSceneApplication extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));

        Scene scene = new Scene(root, 701, 601);
        stage.setScene(scene);
        stage.show();

        ImageView imageView = (ImageView) root.lookup("#myImageView");
        if (imageView != null) {
            Image image = new Image(getClass().getResourceAsStream("/Bike.png"));
            imageView.setImage(image);
        }

    }


    public static void main(String[] args) {
        launch();
    }

}
