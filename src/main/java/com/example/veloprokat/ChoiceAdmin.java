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

public class ChoiceAdmin {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnInfo;

    @FXML
    private Button btnOut;

    @FXML
    private Button btnPay;

    @FXML
    private Button btnRent;

    @FXML
    private Label errorText;
    final String nameFile = "choice_admin.fxml";

    public ChoiceAdmin(){
        List.add(nameFile);
    }

    @FXML
    void toOut(ActionEvent event)throws IOException {
        Stage stage = (Stage) btnOut.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void toCancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cancel_order_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toPay(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("not_pay.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toRent(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("rent.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toInfo(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inf_book.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
    @FXML
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'choice_admin.fxml'.";
        assert btnPay != null : "fx:id=\"btnPay\" was not injected: check your FXML file 'choice_admin.fxml'.";
        assert btnRent != null : "fx:id=\"btnRent\" was not injected: check your FXML file 'choice_admin.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'choice_admin.fxml'.";
        assert btnOut != null : "fx:id=\"btnOut\" was not injected: check your FXML file 'choice_admin.fxml'.";
        assert btnInfo != null : "fx:id=\"btnInfo\" was not injected: check your FXML file 'choice_admin.fxml'.";

    }

}
