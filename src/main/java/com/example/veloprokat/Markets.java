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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Markets {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void toMarkets(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnNext.getScene().getWindow();
        stage.close();
        Stage p = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bikes_kashirka.fxml")));
        p.setTitle("dddd");
        p.setScene(new Scene(root, 600, 400));
        p.show();
    }

    @FXML
    void initialize() {
        assert btnKashirskya != null : "fx:id=\"btnKashirskya\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnNikitskya != null : "fx:id=\"btnNikitskya\" was not injected: check your FXML file 'markets.fxml'.";
        assert btnSemenovskya != null : "fx:id=\"btnSemenovskya\" was not injected: check your FXML file 'markets.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'markets.fxml'.";

    }

}
