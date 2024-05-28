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
import javafx.scene.control.Spinner;
import javafx.stage.Stage;

public class BikesKashirka {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Spinner<?> countAddict;

    @FXML
    private Spinner<?> countAltair;

    @FXML
    private Spinner<?> countFormat;

    @FXML
    private Spinner<?> countMaxit;

    @FXML
    private Spinner<?> countTWISTER;

    @FXML
    private Spinner<?> countWelt;

    @FXML
    private Label errorTextAddict;

    @FXML
    private Label errorTextAltair;

    @FXML
    private Label errorTextFromat;

    @FXML
    private Label errorTextMaxit;

    @FXML
    private Label errorTextTwister;

    @FXML
    private Label errorTextWelt;

    @FXML
    private Button profile;


    @FXML
    void toProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.close();
        Stage p = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        p.setTitle("dddd");
        p.setScene(new Scene(root, 600, 600));
        p.show();
    }

    @FXML
    void toFinish(ActionEvent event) throws IOException {
//        Stage stage = (Stage) btnNext.getScene().getWindow();
//        stage.close();
//        Stage p = new Stage();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(".fxml")));
//        p.setTitle("dddd");
//        p.setScene(new Scene(root, 600, 400));
//        p.show();
    }

    @FXML
    void toMarkets(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        Stage p = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("markets.fxml")));
        p.setTitle("dddd");
        p.setScene(new Scene(root, 600, 400));
        p.show();
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert countAddict != null : "fx:id=\"countAddict\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert countAltair != null : "fx:id=\"countAltair\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert countFormat != null : "fx:id=\"countFormat\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert countMaxit != null : "fx:id=\"countMaxit\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert countTWISTER != null : "fx:id=\"countTWISTER\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert countWelt != null : "fx:id=\"countWelt\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextAddict != null : "fx:id=\"errorTextAddict\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextAltair != null : "fx:id=\"errorTextAltair\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextFromat != null : "fx:id=\"errorTextFromat\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextMaxit != null : "fx:id=\"errorTextMaxit\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextTwister != null : "fx:id=\"errorTextTwister\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextWelt != null : "fx:id=\"errorTextWelt\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert profile != null : "fx:id=\"profile\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";

    }

}
