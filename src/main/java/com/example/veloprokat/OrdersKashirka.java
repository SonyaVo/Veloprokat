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
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class OrdersKashirka {
    final String nameFile = "orders_kashirka.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> booking;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBikes;

    @FXML
    private Button btnClients;

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 715, 600));
        stage.show();
    }

    @FXML
    void toBikes(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bikes_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 715, 600));
        stage.show();
    }

    @FXML
    void toClients(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("clients_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 715, 600));
        stage.show();
    }

    @FXML
    void initialize() {
        assert booking != null : "fx:id=\"booking\" was not injected: check your FXML file 'orders_kashirka.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'orders_kashirka.fxml'.";
        assert btnBikes != null : "fx:id=\"btnBikes\" was not injected: check your FXML file 'orders_kashirka.fxml'.";
        assert btnClients != null : "fx:id=\"btnClients\" was not injected: check your FXML file 'orders_kashirka.fxml'.";

    }

}
