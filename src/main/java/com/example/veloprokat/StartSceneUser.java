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
import javafx.stage.Stage;

public class StartSceneUser {
    final String nameFile = "start_scene_user.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnEntr;

    @FXML
    private Button btnReg;



    public StartSceneUser(){
        List.add(nameFile);
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEntr.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 701, 601));
        stage.show();
    }

    @FXML
    void toEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnEntr.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("entry_user.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 701, 601));
        stage.show();

    }

    @FXML
    void toReg(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnReg.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML

    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'start_scene_user.fxml'.";
        assert btnEntr != null : "fx:id=\"btnEntr\" was not injected: check your FXML file 'start_scene_user.fxml'.";
        assert btnReg != null : "fx:id=\"btnReg\" was not injected: check your FXML file 'start_scene_user.fxml'.";

    }

    public String getName() {
        return nameFile;
    }
}

//package com.example.veloprokat;
//
//import java.io.IOException;
//
//import java.net.URL;
//import java.util.Objects;
//import java.util.ResourceBundle;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.stage.Stage;
//
//public class StartScene {
//
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private Button btnEntr;
//
//    @FXML
//    private Button btnReg;
//
//
//    @FXML
//    void toReg(ActionEvent event) throws IOException {
//        Stage stage = (Stage) btnReg.getScene().getWindow();
//        stage.close();
//        Stage p = new Stage();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration.fxml")));
//        p.setTitle("dddd");
//        p.setScene(new Scene(root, 600, 600));
//        p.show();
//    }
//    @FXML
//    void toEntr(ActionEvent event)  throws IOException {
//        Stage stage = (Stage) btnEntr.getScene().getWindow();
//        stage.close();
//        Stage p = new Stage();
//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("entry_user.fxml")));
//        p.setTitle("dddd");
//        p.setScene(new Scene(root, 600, 400));
//        p.show();
//
//    }
//    @FXML
//    void initialize() {
//        assert btnEntr != null : "fx:id=\"btnEntr\" was not injected: check your FXML file 'start_scene_user.fxml'.";
//        assert btnReg != null : "fx:id=\"btnReg\" was not injected: check your FXML file 'start_scene_user.fxml'.";
//
//    }
//
//}
