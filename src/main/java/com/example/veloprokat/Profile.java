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
    private Label firstName;

    @FXML
    private Label passport;

    @FXML
    private Label patronymic;

    @FXML
    private Label phone;

    @FXML
    private Label secondName;

    @FXML
    private Button btnOut;

    private static String varFirstName;
    private static String varSecondName;
    private static String varPatronymic;
    private static String varPhone;
    private static String varPassport;
    private static String varAdress;
    private static String user[] = new String[6];

    public Profile(){
        Users_SQL sql = new Users_SQL();
        user = sql.getUser(EntryUser.getLogin());

        //List.add(nameFile);
    }

    @FXML
    void toOut(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_user_or_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
    @FXML
    void toBack(ActionEvent event) throws IOException {
        if (!List.list.isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(List.get(List.list.size() - 1))));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
    }

    @FXML
    void toChange(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile_to_change.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();

    }



    public static String getVarFirstName() {
        return varFirstName;
    }

    public static String getVarSecondName() {
        return varSecondName;
    }

    public static String getVarPatronymic() {
        return varPatronymic;
    }

    public static String getVarAdress() {
        return varAdress;
    }

    public static String getVarPassport() {
        return varPassport;
    }

    public static String getVarPhone() {
        return varPhone;
    }

    public static String getId(){
        return user[0];
    }

    @FXML
    void initialize() {
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file 'profile.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'profile.fxml'.";
        assert btnChange != null : "fx:id=\"btnChange\" was not injected: check your FXML file 'profile.fxml'.";
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'profile.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'profile.fxml'.";
        assert patronymic != null : "fx:id=\"patronomyc\" was not injected: check your FXML file 'profile.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'profile.fxml'.";
        assert secondName != null : "fx:id=\"secondName\" was not injected: check your FXML file 'profile.fxml'.";


       varFirstName = user[1];
        varSecondName = user[2];
        varPatronymic = user[3];
        varPassport = user[4];
        varPhone = EntryUser.getLogin();
        varAdress = user[5];

        firstName.setText(varFirstName);
        secondName.setText(varSecondName);
        patronymic.setText(varPatronymic);
        passport.setText(varPassport);
        phone.setText(varPhone);
        adress.setText(varAdress);
    }


}
