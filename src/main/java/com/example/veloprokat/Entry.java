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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Entry {
    final String nameFile = "entry.fxml";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Label errorText;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    public Entry(){
        List.add(nameFile);
    }



    @FXML
    void toBackEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    void toMarketsEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnNext.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("markets.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'entry.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'entry.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'entry.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'entry.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'entry.fxml'.";

    }


}
