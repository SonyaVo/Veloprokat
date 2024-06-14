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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Registration {
    final String nameFile = "registration.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Label errorTextFirstName;

    @FXML
    private Label errorTextPassport;

    @FXML
    private Label errorTextPatronymic;

    @FXML
    private Label errorTextPhone;

    @FXML
    private Label errorTextSecondName;

    @FXML
    private TextField firstName;

    @FXML
    private TextField passport;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordAg;

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
        varFirstName = firstName.getText();
        varSecondName = secondName.getText();
        varPatronymic = patronymic.getText();
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

//        boolean result = true;
//        String nameExp = "";
//        if(varName.length == 3){
//            outLoop:
//            for (int i = 0; i < varName.length;i++){
//                try {
//                    result = varName[i].matches(nameExp);
//                }
//                catch (Exception e){
//                    errorTextName.setText("");
//                }
//            }
//
//
//        }

        errorText.setText(generalError());
        errorTextFirstName.setText(errorFirstName());
        errorTextSecondName.setText(errorSecondName());
        errorTextPatronymic.setText(errorPatronymic());
        errorTextPhone.setText(errorPhone());
        errorTextPassport.setText(errorPassport());

        if (errorText.getText().isEmpty() && errorTextPassport.getText().isEmpty() && errorTextPhone.getText().isEmpty() && errorTextFirstName.getText().isEmpty() && errorTextSecondName.getText().isEmpty() && errorTextPatronymic.getText().isEmpty()) {
            if (agree.isSelected()) {
                Stage stage = (Stage) btnNext.getScene().getWindow();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("start_scene_user.fxml")));
                stage.setTitle("dddd");
                stage.setScene(new Scene(root, 700, 600));
                stage.show();
            } else {
                agree.setStyle("-fx-text-fill: red;");
            }
        }
    }


    private String generalError() {
        if (firstName.getText().isEmpty() || secondName.getText().isEmpty() ||
                passport.getText().isEmpty() || adress.getText().isEmpty() || phone.getText().isEmpty() ||
                password.getText().isEmpty() || passwordAg.getText().isEmpty()) {
            return "Не все поля заполнены";
        }
        if (!varPassword.equals(varPassword2)) {
            return "Пароль введен неправильно";
        }
        return "";
    }
    private String errorSecondName() {
        if (!varSecondName.matches("([А-ЯЁ][а-яё]+)|([а-яё][а-яё]+)")) {
            return "Имя введено неправильно";
        }
        return "";
    }
    private String errorFirstName() {
        if (!varFirstName.matches("([А-ЯЁ][а-яё]+)|([а-яё][а-яё]+)")) {
            return "Фамилия введена неправильно";
        }
        return "";
    }
    private String errorPatronymic() {
        if (!varPatronymic.isEmpty()) {
            if (!varPatronymic.matches("([А-ЯЁ][а-яё]+)|([а-яё][а-яё]+)")) {
                return "Отчество введено неправильно";
            }
        }
        return "";
    }
    private String errorPhone() {
        if (!varPhone.matches("^8\\d{10}$")) {
            return "Телефон введен неправильно";
        }
        return "";
    }

    private String errorPassport() {
        if (!varPassport.matches("^\\d{4}\\d{6}$")) {
            return "Паспорт введен неправильно";
        }
        return "";
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

    public static String getVarFirstName() {
        return varFirstName;
    }

    public static String getVarSecondName() {
        return varSecondName;
    }

    public static String getVarPatronymic() {
        return varPatronymic;
    }

    @FXML
    void initialize() {
        assert adress != null : "fx:id=\"adress\" was not injected: check your FXML file 'registration.fxml'.";
        assert agree != null : "fx:id=\"agree\" was not injected: check your FXML file 'registration.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'registration.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorTextFirstName != null : "fx:id=\"errorTextFirstName\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorTextPassport != null : "fx:id=\"errorTextPassport\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorTextPatronymic != null : "fx:id=\"errorTextPatronymic\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorTextPhone != null : "fx:id=\"errorTextPhone\" was not injected: check your FXML file 'registration.fxml'.";
        assert errorTextSecondName != null : "fx:id=\"errorTextSecondName\" was not injected: check your FXML file 'registration.fxml'.";
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'registration.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'registration.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'registration.fxml'.";
        assert passwordAg != null : "fx:id=\"passwordAg\" was not injected: check your FXML file 'registration.fxml'.";
        assert patronymic != null : "fx:id=\"patronymic\" was not injected: check your FXML file 'registration.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'registration.fxml'.";
        assert secondName != null : "fx:id=\"secondName\" was not injected: check your FXML file 'registration.fxml'.";


    }
}
