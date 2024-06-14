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
    private TextField firstName;

    @FXML
    private TextField passport;

    @FXML
    private TextField patronymic;

    @FXML
    private TextField phone;

    @FXML
    private TextField secondName;


    private static String varFirstName;
    private static String varSecondName;
    private static String varPatronymic;
    private static String varPhone;
    private static String varPassport;
    private static String varAdress;



    public ProfileToChange(){
        //List.add(nameFile);

    }



    @FXML
    void toSave(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnSave.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
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

    @FXML
    void initialize() {
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file 'profile_to_change.fxml'.";

        assert btnSave != null : "fx:id=\"btnChange\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert patronymic != null : "fx:id=\"patronymic\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'profile_to_change.fxml'.";
        assert secondName != null : "fx:id=\"secondName\" was not injected: check your FXML file 'profile_to_change.fxml'.";

        varFirstName = Profile.getVarFirstName();
        varSecondName = Profile.getVarSecondName();
        varPatronymic = Profile.getVarPatronymic();

        varPassport = Profile.getVarPassport();
        varPhone = Profile.getVarPhone();
        varAdress = Profile.getVarAdress();

        firstName.setText(varFirstName);
        secondName.setText(varSecondName);
        patronymic.setText(varPatronymic);
        passport.setText(varPassport);
        phone.setText(varPhone);
        adress.setText(varAdress);
    }

}
