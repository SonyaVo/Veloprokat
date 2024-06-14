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
import javafx.stage.Stage;

public class NotPay {
    final String nameFile = "not_pay.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label errorText;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPay;

    @FXML
    private Label status;

    @FXML
    private Label sum;

    @FXML
    private Label textOrders;

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toPay(ActionEvent event)  throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pay.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert btnPay != null : "fx:id=\"btnPay\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert sum != null : "fx:id=\"sum\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'not_pay.fxml'.";
    }

}
