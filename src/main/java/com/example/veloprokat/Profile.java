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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Profile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adress;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnChange;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private TextField phone;

    @FXML
    void toBack(ActionEvent event) throws IOException {

//        Stage stage = (Stage) btnBack.getScene().getWindow();
//        stage.close();
//        Stage p = new Stage();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bikes_kashirka.fxml")));
//        p.setTitle("dddd");
//        p.setScene(new Scene(root, 600, 400));
//        p.show();
    }

    @FXML
    void toChange(ActionEvent event) {

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
