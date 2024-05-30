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

public class Profile {
    final String nameFile = "profile.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label adress;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChange;

    @FXML
    private Label name;

    @FXML
    private Label passport;

    @FXML
    private Label phone;

    public Profile(){
        List.add(nameFile);
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        if (!List.list.isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(List.get(List.list.size() - 2))));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        }
    }

    @FXML
    void toChange(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile_to_change.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();

    }

    @FXML
    void initialize() {
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file 'profile.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'profile.fxml'.";
        assert btnChange != null : "fx:id=\"btnChange\" was not injected: check your FXML file 'profile.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'profile.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'profile.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'profile.fxml'.";

    }


}
