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

public class ProfileToChange   {
    final String nameFile = "profile_to_change.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField adress;

    @FXML
    private Button btnSave;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private TextField phone;

    public ProfileToChange(){
        List.add(nameFile);
    }


    @FXML
    void toSave(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnSave.getScene().getWindow();


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    void initialize() {
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'profile_to_change.fxml'.";

    }

}
