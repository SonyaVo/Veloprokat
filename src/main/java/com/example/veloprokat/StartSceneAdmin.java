package com.example.veloprokat;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartSceneAdmin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnEntr;

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEntr.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("entry_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'start_scene_admin.fxml'.";
        assert btnEntr != null : "fx:id=\"btnEntr\" was not injected: check your FXML file 'start_scene_admin.fxml'.";

    }

}
