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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Registration {

    @FXML
    private TextField adress;

    @FXML
    private RadioButton agree;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Label errorText;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordAg;

    @FXML
    private TextField phone;
    @FXML
    void toBackReg(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage p = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene.fxml")));
        p.setTitle("dddd");
        p.setScene(new Scene(root, 600, 400));
        p.show();
    }

    @FXML
    void toNextReg(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.close();
        Stage p = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene.fxml")));
        p.setTitle("dddd");
        p.setScene(new Scene(root, 600, 400));
        p.show();
    }

    @FXML
    void initialize() {
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file 'registration.fxml'.";
        assert agree != null : "fx:id=\"agree\" was not injected: check your FXML file 'registration.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'registration.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'registration.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'registration.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'registration.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'registration.fxml'.";
        assert passwordAg != null : "fx:id=\"passwordAg\" was not injected: check your FXML file 'registration.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'registration.fxml'.";

    }
}
