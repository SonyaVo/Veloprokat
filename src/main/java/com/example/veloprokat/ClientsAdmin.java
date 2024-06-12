package com.example.veloprokat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;

public class ClientsAdmin {
    final String nameFile = "clients_admin.fxml";


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> booking;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBikes;

    @FXML
    private Button btnClients;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    void toAdd(ActionEvent event) {

    }

    @FXML
    void toBack(ActionEvent event) {

    }

    @FXML
    void toBikes(ActionEvent event) {

    }

    @FXML
    void toClients(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert booking != null : "fx:id=\"booking\" was not injected: check your FXML file 'clients_admin.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'clients_admin.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'clients_admin.fxml'.";
        assert btnBikes != null : "fx:id=\"btnBikes\" was not injected: check your FXML file 'clients_admin.fxml'.";
        assert btnClients != null : "fx:id=\"btnClients\" was not injected: check your FXML file 'clients_admin.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'clients_admin.fxml'.";

    }

}
