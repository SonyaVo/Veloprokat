package com.example.veloprokat;

import java.io.IOException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Registration {
    final String nameFile = "registration.fxml";

    @FXML
    private TextField adress;

    @FXML
    private RadioButton agree;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNext;

    @FXML
    private Label errorText;

    @FXML
    private TextField name;

    @FXML
    private TextField passport;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordAg;

    @FXML
    private TextField phone;

    private static String varName;
    private static String varPhone;
    private static String varPassport;
    private static String varAdress;

    private static String varPassword;
    private static String varPassword2;



    public Registration(){
        List.add(nameFile);
    }
    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();

    }

    @FXML
    void toEntry(ActionEvent event) throws IOException {

        varName = name.getText();
        varPassport = passport.getText();
        varPhone = phone.getText();
        varAdress = adress.getText();
        //String n = name.getText();
        //System.out.println(name);

//        String lastName = name.getText().split(" ")[0];
//        System.out.println(lastName);
//        String firstName = name.getText().split(" ")[1];
//        System.out.println(firstName);
//        String patronymic = name.getText().split(" ")[2];
//        System.out.println(patronymic);

//
//        String p = passport.getText();
//        System.out.println(p);
//        String adr = adress.getText();
//        System.out.println(adr);
//        String ph = phone.getText();
//        System.out.println(ph);

        varPassword = password.getText();
        varPassword2 = passwordAg.getText();

        if (name.getText().isEmpty()|| passport.getText().isEmpty() ||  adress.getText().isEmpty() ||  phone.getText().isEmpty() ||  password.getText().isEmpty() ||  passwordAg.getText().isEmpty() ){
            errorText.setText("Не все поля заполнены");
        }


        else {
            errorText.setText("");
            if (!varPassword.equals(varPassword2)){
                errorText.setText("Пароль введен неправильно");
            }
            else {
                errorText.setText("");
                if (agree.isSelected()) {
                    Stage stage = (Stage) btnNext.getScene().getWindow();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
                    stage.setTitle("dddd");
                    stage.setScene(new Scene(root, 700, 600));
                    stage.show();
                }
                else {
                    agree.setStyle("-fx-text-fill: red;");
                }
            }
        }
    }

    public static String getVarAdress() {
        return varAdress;
    }

    public static String getVarPassport() {
        return varPassport;
    }

    public static String getVarName() {
        return varName;
    }

    public static String getVarPhone() {
        return varPhone;
    }

    @FXML
    void initialize() {
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file 'registration.fxml'.";
        assert agree != null : "fx:id=\"agree\" was not injected: check your FXML file 'registration.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'registration.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'registration.fxml'.";
        assert name != null : "fx:id=\"name\" was not injected: check your FXML file 'registration.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'registration.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'registration.fxml'.";
        assert passwordAg != null : "fx:id=\"passwordAg\" was not injected: check your FXML file 'registration.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'registration.fxml'.";

    }
}
