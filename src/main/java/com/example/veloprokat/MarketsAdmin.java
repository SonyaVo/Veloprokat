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

public class MarketsAdmin {
    final String nameFile = "markets_admin.fxml";

    @FXML
    private RadioButton btnKashirskya;

    @FXML
    private Button btnNext;

    @FXML
    private RadioButton btnNikitskya;




    @FXML
    private RadioButton btnSemenovskya;

    @FXML
    private Label errorText;

    @FXML
    private ToggleGroup marketGroup;

    public MarketsAdmin(){
        List.add(nameFile);
    }







    @FXML
    void toMarkets(ActionEvent event) throws IOException {
        if (btnKashirskya.isSelected()) {
            Stage stage = (Stage) btnNext.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("orders_kashirka.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 715, 600));
            stage.show();
        }

        if (btnSemenovskya.isSelected()) {
            Stage stage = (Stage) btnNext.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("orders_semenovskaya.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 715, 600));
            stage.show();
        }

        if (btnNikitskya.isSelected()) {
            Stage stage = (Stage) btnNext.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("orders_nikitskaya.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 715, 600));
            stage.show();
        }

    }


    @FXML
    void initialize() {
        assert btnKashirskya != null : "fx:id=\"btnKashirskya\" was not injected: check your FXML file 'markets_user.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'markets_user.fxml'.";
        assert btnNikitskya != null : "fx:id=\"btnNikitskya\" was not injected: check your FXML file 'markets_user.fxml'.";
        assert btnSemenovskya != null : "fx:id=\"btnSemenovskya\" was not injected: check your FXML file 'markets_user.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'markets_user.fxml'.";

        marketGroup = new ToggleGroup();
        btnNikitskya.setToggleGroup(marketGroup);
        btnSemenovskya.setToggleGroup(marketGroup);
        btnKashirskya.setToggleGroup(marketGroup);

    }

}
