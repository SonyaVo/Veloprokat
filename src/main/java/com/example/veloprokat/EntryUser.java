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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EntryUser {
    final String nameFile = "entry_user.fxml";
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Label errorText;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    private static String varLogin;
    private static String varPassword;
    private Users_SQL users;


    public EntryUser(){
        List.add(nameFile);
        users = Users_SQL.getInstance();

    }



    @FXML
    void toBackEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toMarketsEntr(ActionEvent event) throws IOException {
        varLogin = login.getText();
        varPassword = password.getText();
        if (!login.getText().isEmpty() && !password.getText().isEmpty()) {
            String flag = users.isUsers(login.getText(), password.getText());

            if (flag.equals("существует")) {
                Stage stage = (Stage) btnNext.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("markets_user.fxml")));
                stage.setTitle("dddd");
                stage.setScene(new Scene(root, 700, 600));
                stage.show();
            }
            if (flag.equals("не существует")) {
                errorText.setText("логин введен неправильно");
            }
            else
                errorText.setText(flag);



        }
        else {
            errorText.setText("заполните все поля");
        }
    }

    public static String getLogin() {
        return varLogin;
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'entry_user.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'entry_user.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'entry_user.fxml'.";
        assert login != null : "fx:id=\"login\" was not injected: check your FXML file 'entry_user.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'entry_user.fxml'.";

    }


}
