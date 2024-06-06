package com.example.veloprokat;

import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Markets  {
    final String nameFile = "markets.fxml";
    @FXML
    private RadioButton btnKashirskya;

    @FXML
    private Button btnNext;

    @FXML
    private RadioButton btnNikitskya;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnProfile;

    @FXML
    private RadioButton btnSemenovskya;

    @FXML
    private Label errorText;

    @FXML
    private ToggleGroup marketGroup;

    public Markets(){
        List.add(nameFile);
    }

    @FXML
    void toOrders(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnProfile.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("orders.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnProfile.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }



    @FXML
    void toMarkets(ActionEvent event) throws IOException {
        if (btnKashirskya.isSelected()) {
            Stage stage = (Stage) btnNext.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bikes_kashirka.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 715, 600));
            stage.show();
        }

        if (btnSemenovskya.isSelected()) {
            Stage stage = (Stage) btnNext.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bikes_semenovskaya.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 715, 600));
            stage.show();
        }

        if (btnNikitskya.isSelected()) {
            Stage stage = (Stage) btnNext.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bikes_nikitskaya.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 715, 600));
            stage.show();
        }

    }


    @FXML
    void initialize() {
        assert btnKashirskya != null : "fx:id=\"btnKashirskya\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnNikitskya != null : "fx:id=\"btnNikitskya\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnOrders != null : "fx:id=\"btnOrders\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnProfile != null : "fx:id=\"btnProfile\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnSemenovskya != null : "fx:id=\"btnSemenovskya\" was not injected: check your FXML file 'markets.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'markets.fxml'.";

        marketGroup = new ToggleGroup();
        btnNikitskya.setToggleGroup(marketGroup);
        btnSemenovskya.setToggleGroup(marketGroup);
        btnKashirskya.setToggleGroup(marketGroup);

    }

}
