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

public class CancelOrder {

    final String nameFile = "cancel_order.fxml";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCancel;

    @FXML
    private Label textOrders;
    public CancelOrder(){
        List.add(nameFile);
    }

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        if (!List.list.isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(List.get(List.list.size() - 2))));
            stage.setTitle("");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
    }

    @FXML
    void toCancel(ActionEvent event) throws IOException {

        // ДОПИСАТЬ УДАЛЕНИЕ БРОНИ

        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(".fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'cancel_order.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'cancel_order.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'cancel_order.fxml'.";

    }

}
