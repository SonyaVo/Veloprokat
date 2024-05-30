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

public class Result {
    final String nameFile = "result.fxml";


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBook;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnProfile;

    @FXML
    private Button btnBack;

    @FXML
    private Label numberBook;

    public Result(){
        List.add(nameFile);
    }

    @FXML
    void toBook(ActionEvent event) {
        // Set the text of the label to "1234"
        numberBook.setText("1234");
    }

    @FXML
    void toMarkets(ActionEvent event) throws IOException {
        if (!List.list.isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(List.get(List.list.size() - 2))));
            stage.setTitle("Markets");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
    }

    @FXML
    void toOrders(ActionEvent event) {
        // Implement the logic for orders button click if needed
    }

    @FXML
    void toProfile(ActionEvent event) throws IOException {
        // Load the profile.fxml and switch to the new scene
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        stage.setTitle("Profile");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    void initialize() {
        assert btnBook != null : "fx:id=\"btnBook\" was not injected: check your FXML file 'result.fxml'.";
        assert btnOrders != null : "fx:id=\"btnOrders\" was not injected: check your FXML file 'result.fxml'.";
        assert btnProfile != null : "fx:id=\"btnProfile\" was not injected: check your FXML file 'result.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'result.fxml'.";
        assert numberBook != null : "fx:id=\"numberBook\" was not injected: check your FXML file 'result.fxml'.";
    }
}
