package com.example.veloprokat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;

public class BikesAdmin {
    final String nameFile = "bikes_admin.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> booking;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClients;

    @FXML
    private Button btnMarkets;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void toBack(ActionEvent event) {

    }

    @FXML
    void toClients(ActionEvent event) {

    }

    @FXML
    void toMarkets(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert booking != null : "fx:id=\"booking\" was not injected: check your FXML file 'bikes_admin.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'bikes_admin.fxml'.";
        assert btnClients != null : "fx:id=\"btnClients\" was not injected: check your FXML file 'bikes_admin.fxml'.";
        assert btnMarkets != null : "fx:id=\"btnMarkets\" was not injected: check your FXML file 'bikes_admin.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'bikes_admin.fxml'.";

    }

}
