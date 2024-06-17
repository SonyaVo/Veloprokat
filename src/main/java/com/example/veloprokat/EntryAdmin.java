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
public class EntryAdmin {
    final String nameFile = "entry_admin.fxml";
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
    public EntryAdmin(){
        List.add(nameFile);
    }




    @FXML
    void toBackEntr(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toEntr(ActionEvent event) throws IOException {
        if (login.getText().isEmpty() | password.getText().isEmpty()) {
            errorText.setText("не все поля заполнены");
        } else {
            if (login.getText().equals("admin") & password.getText().equals("admin")) {
                Stage stage = (Stage) btnNext.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice_admin.fxml")));
                stage.setTitle("dddd");
                stage.setScene(new Scene(root, 700, 600));
                stage.show();
            } else {
                errorText.setText("неправильный логин или пароль");
            }
        }
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