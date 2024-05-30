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
import javafx.scene.control.*;
import javafx.stage.Stage;

public class BikesKashirka{
    final String nameFile = "bikes_kashirka.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton btn1HourAddict;

    @FXML
    private RadioButton btn1HourAltair;

    @FXML
    private RadioButton btn1HourFormat;

    @FXML
    private RadioButton btn1HourMaxit;

    @FXML
    private RadioButton btn1HourTwister;

    @FXML
    private RadioButton btn1HourWelt;

    @FXML
    private RadioButton btn1WeekAddict;

    @FXML
    private RadioButton btn1WeekAltair;

    @FXML
    private RadioButton btn1WeekFormat;

    @FXML
    private RadioButton btn1WeekMaxit;

    @FXML
    private RadioButton btn1WeekTwister;

    @FXML
    private RadioButton btn1WeekWelt;

    @FXML
    private RadioButton btn3HourAddict;

    @FXML
    private RadioButton btn3HourAltair;

    @FXML
    private RadioButton btn3HourFormat;

    @FXML
    private RadioButton btn3HourMaxit;

    @FXML
    private RadioButton btn3HourTwister;

    @FXML
    private RadioButton btn3HourWelt;

    @FXML
    private RadioButton btnAddict;

    @FXML
    private RadioButton btnAltair;

    @FXML
    private Button btnBack;

    @FXML
    private RadioButton btnFormat;

    @FXML
    private RadioButton btnMaxit;

    @FXML
    private Button btnNext;

    @FXML
    private RadioButton btnTwister;

    @FXML
    private RadioButton btnWelt;

    @FXML
    private DatePicker date;

    @FXML
    private Label errorTextAddict;

    @FXML
    private Label errorTextAltair;

    @FXML
    private Label errorTextDate;

    @FXML
    private Label errorTextFromat;

    @FXML
    private Label errorTextMaxit;

    @FXML
    private Label errorTextTwister;

    @FXML
    private Label errorTextWelt;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnProfile;
    @FXML
    private ToggleGroup groupTime;
    @FXML
    private ToggleGroup groupWelt;
    @FXML
    private ToggleGroup groupTwister;
    @FXML
    private ToggleGroup groupMaxit;
    @FXML
    private ToggleGroup groupFormat;
    @FXML
    private ToggleGroup groupAltair;
    @FXML
    private ToggleGroup groupAddict;
    @FXML
    private ToggleGroup groupBikes;

    public BikesKashirka(){
        List.add(nameFile);
    }



    @FXML
    void toProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnProfile.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    public String getNameFile() {
        return nameFile;
    }
    @FXML
    void toOrders(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnNext.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("orders.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();
    }

    @FXML
    void toFinish(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnNext.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("result.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    void toMarkets(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("markets.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    @FXML
    void initialize() {
        assert btn1HourAddict != null : "fx:id=\"btn1HourAddict\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1HourAltair != null : "fx:id=\"btn1HourAltair\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1HourFormat != null : "fx:id=\"btn1HourFormat\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1HourMaxit != null : "fx:id=\"btn1HourMaxit\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1HourTwister != null : "fx:id=\"btn1HourTwister\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1HourWelt != null : "fx:id=\"btn1HourWelt\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1WeekAddict != null : "fx:id=\"btn1WeekAddict\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1WeekAltair != null : "fx:id=\"btn1WeekAltair\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1WeekFormat != null : "fx:id=\"btn1WeekFormat\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1WeekMaxit != null : "fx:id=\"btn1WeekMaxit\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1WeekTwister != null : "fx:id=\"btn1WeekTwister\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn1WeekWelt != null : "fx:id=\"btn1WeekWelt\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn3HourAddict != null : "fx:id=\"btn3HourAddict\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn3HourAltair != null : "fx:id=\"btn3HourAltair\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn3HourFormat != null : "fx:id=\"btn3HourFormat\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn3HourMaxit != null : "fx:id=\"btn3HourMaxit\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn3HourTwister != null : "fx:id=\"btn3HourTwister\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btn3HourWelt != null : "fx:id=\"btn3HourWelt\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnAddict != null : "fx:id=\"btnAddict\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnAltair != null : "fx:id=\"btnAltair\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnFormat != null : "fx:id=\"btnFormat\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnMaxit != null : "fx:id=\"btnMaxit\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnTwister != null : "fx:id=\"btnTwister\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnWelt != null : "fx:id=\"btnWelt\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert errorTextAddict != null : "fx:id=\"errorTextAddict\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert errorTextAltair != null : "fx:id=\"errorTextAltair\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert errorTextDate != null : "fx:id=\"errorTextDate\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert errorTextFromat != null : "fx:id=\"errorTextFromat\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert errorTextMaxit != null : "fx:id=\"errorTextMaxit\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert errorTextTwister != null : "fx:id=\"errorTextTwister\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert errorTextWelt != null : "fx:id=\"errorTextWelt\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnOrders != null : "fx:id=\"orders\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";
        assert btnProfile != null : "fx:id=\"profile\" was not injected: check your FXML file 'bikes_semenovskaya.fxml'.";


        groupAddict = new ToggleGroup();
        btn1HourAddict.setToggleGroup(groupAddict);
        btn3HourAddict.setToggleGroup(groupAddict);
        btn1WeekAddict.setToggleGroup(groupAddict);
        btn1HourAltair.setToggleGroup(groupAddict);
        btn3HourAltair.setToggleGroup(groupAddict);
        btn1WeekAltair.setToggleGroup(groupAddict);
        btn1HourFormat.setToggleGroup(groupAddict);
        btn3HourFormat.setToggleGroup(groupAddict);
        btn1WeekFormat.setToggleGroup(groupAddict);
        btn1HourMaxit.setToggleGroup(groupAddict);
        btn3HourMaxit.setToggleGroup(groupAddict);
        btn1WeekMaxit.setToggleGroup(groupAddict);
        btn1HourWelt.setToggleGroup(groupAddict);
        btn3HourWelt.setToggleGroup(groupAddict);
        btn1WeekWelt.setToggleGroup(groupAddict);
        btn1HourTwister.setToggleGroup(groupAddict);
        btn3HourTwister.setToggleGroup(groupAddict);
        btn1WeekTwister.setToggleGroup(groupAddict);
//        groupAddict = new ToggleGroup();
//        btn1HourAddict.setToggleGroup(groupAddict);
//        btn3HourAddict.setToggleGroup(groupAddict);
//        btn1WeekAddict.setToggleGroup(groupAddict);
//
//        groupAltair = new ToggleGroup();
//        btn1HourAltair.setToggleGroup(groupAltair);
//        btn3HourAltair.setToggleGroup(groupAltair);
//        btn1WeekAltair.setToggleGroup(groupAltair);
//
//        groupFormat = new ToggleGroup();
//        btn1HourFormat.setToggleGroup(groupFormat);
//        btn3HourFormat.setToggleGroup(groupFormat);
//        btn1WeekFormat.setToggleGroup(groupFormat);
//
//        groupMaxit = new ToggleGroup();
//        btn1HourMaxit.setToggleGroup(groupMaxit);
//        btn3HourMaxit.setToggleGroup(groupMaxit);
//        btn1WeekMaxit.setToggleGroup(groupMaxit);
//
//        groupWelt = new ToggleGroup();
//        btn1HourWelt.setToggleGroup(groupWelt);
//        btn3HourWelt.setToggleGroup(groupWelt);
//        btn1WeekWelt.setToggleGroup(groupWelt);
//
//        groupTwister = new ToggleGroup();
//        btn1HourTwister.setToggleGroup(groupTwister);
//        btn3HourTwister.setToggleGroup(groupTwister);
//        btn1WeekTwister.setToggleGroup(groupTwister);

        groupBikes = new ToggleGroup();
        btnTwister.setToggleGroup(groupBikes);
        btnAddict.setToggleGroup(groupBikes);
        btnAltair.setToggleGroup(groupBikes);
        btnFormat.setToggleGroup(groupBikes);
        btnMaxit.setToggleGroup(groupBikes);
        btnWelt.setToggleGroup(groupBikes);

    }

}
