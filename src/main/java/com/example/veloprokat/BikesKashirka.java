package com.example.veloprokat;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.time.LocalDate;

public class BikesKashirka{
    final String nameFile = "bikes_kashirka.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private RadioButton btn1DayAddict;

    @FXML
    private RadioButton btn1DayAltair;

    @FXML
    private RadioButton btn1DayFormat;

    @FXML
    private RadioButton btn1DayMaxit;

    @FXML
    private RadioButton btn1DayTwister;

    @FXML
    private RadioButton btn1DayWelt;

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
    private RadioButton btn3DayAddict;

    @FXML
    private RadioButton btn3DayAltair;

    @FXML
    private RadioButton btn3DayFormat;

    @FXML
    private RadioButton btn3DayMaxit;

    @FXML
    private RadioButton btn3DayTwister;

    @FXML
    private RadioButton btn3DayWelt;

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
    private ImageView i;


    @FXML
    private Label errorTextMaxit;

    @FXML
    private Label errorTextTwister;
    @FXML
    private Label errorText;

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

    private Bikes_SQL bikes;
    @FXML
    private ImageView img;



    private static String[] choice = new String[3];

    public BikesKashirka(){
        //choice = new String[3];
         bikes = Bikes_SQL.getInstance();
        List.add(nameFile);
    }



    @FXML
    void toProfile(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnProfile.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("profile.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
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
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toDate(ActionEvent event) {
        errorTextFromat.setText("");
        errorTextWelt.setText("");
        errorTextAddict.setText("");
        errorTextAltair.setText("");
        errorTextTwister.setText("");
        errorTextMaxit.setText("");

        btn1DayAddict.setDisable(false);
        btn3DayAddict.setDisable(false);
        btn1WeekAddict.setDisable(false);
        btn1DayAltair.setDisable(false);
        btn3DayAltair.setDisable(false);
        btn1WeekAltair.setDisable(false);
        btn1DayFormat.setDisable(false);
        btn3DayFormat.setDisable(false);
        btn1WeekFormat.setDisable(false);
        btn1DayMaxit.setDisable(false);
        btn3DayMaxit.setDisable(false);
        btn1WeekMaxit.setDisable(false);
        btn1DayWelt.setDisable(false);
        btn3DayWelt.setDisable(false);
        btn1WeekWelt.setDisable(false);
        btn1DayTwister.setDisable(false);
        btn3DayTwister.setDisable(false);
        btn1WeekTwister.setDisable(false);
        btnTwister.setDisable(false);
        btnAddict.setDisable(false);
        btnAltair.setDisable(false);
        btnFormat.setDisable(false);
        btnMaxit.setDisable(false);
        btnWelt.setDisable(false);

        LocalDate selectedDate = date.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date_format = selectedDate.format(formatter);


        if(!bikes.inStock("MAXIT D060",1, date_format)){
            errorTextMaxit.setText("нет в наличии");
            btnMaxit.setDisable(true);
            btn1DayMaxit.setDisable(true);
            btn3DayMaxit.setDisable(true);
            btn1WeekMaxit.setDisable(true);
        }
        if(!bikes.inStock("FORMAT 7733",1, date_format)){
            errorTextFromat.setText("нет в наличии");
            btnFormat.setDisable(true);
            btn1DayFormat.setDisable(true);
            btn3DayFormat.setDisable(true);
            btn1WeekFormat.setDisable(true);
        } if(!bikes.inStock("WELT R90",1, date_format)){
            errorTextWelt.setText("нет в наличии");
            btnWelt.setDisable(true);
            btn1DayWelt.setDisable(true);
            btn3DayWelt.setDisable(true);
            btn1WeekWelt.setDisable(true);
        } if(!bikes.inStock("ADDICT RC15",1, date_format)){
            errorTextAddict.setText("нет в наличии");
            btnAddict.setDisable(true);
            btn1DayAddict.setDisable(true);
            btn3DayAddict.setDisable(true);
            btn1WeekAddict.setDisable(true);
        } if(!bikes.inStock("ALTAIR AL29D",1, date_format)){
            errorTextAltair.setText("нет в наличии");
            btnAltair.setDisable(true);
            btn1DayAltair.setDisable(true);
            btn3DayAltair.setDisable(true);
            btn1WeekAltair.setDisable(true);
        } if(!bikes.inStock("TWISTER 26",1, date_format)){
            errorTextTwister.setText("нет в наличии");
            btnTwister.setDisable(true);
            btn1DayTwister.setDisable(true);
            btn3DayTwister.setDisable(true);
            btn1WeekTwister.setDisable(true);
        }

    }

    @FXML
    void toFinish(ActionEvent event) throws IOException {
        choice[0] = date.getValue() +"";
        if (btnAddict.isSelected()){
            if (btn1DayAddict.isSelected()){
                choice[1] = "ADDICT RC15";
                choice[2] = "1";
            }
            if(btn3DayAddict.isSelected()){
                choice[1] = "ADDICT RC15";
                choice[2] = "3";

            }
            if (btn1WeekAddict.isSelected()){
                choice[1] = "ADDICT RC15";
                choice[2] = "7";

            }
        }

        if (btnAltair.isSelected()){
            if (btn1DayAltair.isSelected()){
                choice[1] = "ALTAIR AL29D";
                choice[2] = "1";
            }
            if(btn3DayAltair.isSelected()){
                choice[1] = "ALTAIR AL29D";
                choice[2] = "3";

            }
            if (btn1WeekAltair.isSelected()){
                choice[1] = "ALTAIR AL29D";
                choice[2] = "7";

            }
        }

        if (btnFormat.isSelected()){
            if (btn1DayFormat.isSelected()){
                choice[1] = "FORMAT 7733";
                choice[2] = "1";
            }
            if(btn3DayFormat.isSelected()){
                choice[1] = "FORMAT 7733";
                choice[2] = "3";

            }
            if (btn1WeekFormat.isSelected()){
                choice[1] = "FORMAT 7733";
                choice[2] = "7";

            }
        }

        if (btnMaxit.isSelected()){
            if (btn1DayMaxit.isSelected()){
                choice[1] = "MAXIT D060";
                choice[2] = "1";
            }
            if(btn3DayMaxit.isSelected()){
                choice[1] = "MAXIT D060";
                choice[2] = "3";

            }
            if (btn1WeekMaxit.isSelected()){
                choice[1] = "MAXIT D060";
                choice[2] = "7";

            }
        }

        if (btnTwister.isSelected()){
            if (btn1DayTwister.isSelected()){
                choice[1] = "TWISTER 26";
                choice[2] = "1";            }
            if(btn3DayTwister.isSelected()){
                choice[1] = "TWISTER 26";
                choice[2] = "3";
            }
            if (btn1WeekTwister.isSelected()){
                choice[1] = "TWISTER 26";
                choice[2] = "7";
            }
        }

        if (btnWelt.isSelected()){
            if (btn1DayWelt.isSelected()){
                choice[1] = "WELT R90";
                choice[2] = "1";
            }
            if(btn3DayWelt.isSelected()){
                choice[1] = "WELT R90";
                choice[2] = "3";

            }
            if (btn1WeekWelt.isSelected()){
                choice[1] = "WELT R90";
                choice[2] = "7";

            }
        }
        LocalDate currentDate = LocalDate.now();
        if ((choice[1] != null) & (date.getValue().isAfter(currentDate) | date.getValue().isEqual(currentDate))){
            Stage stage = (Stage) btnNext.getScene().getWindow();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("result.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }

        if (!(date.getValue().isAfter(currentDate) | date.getValue().isEqual(currentDate))){
            errorText.setText("дата некорректна");

        }
        else {
            errorText.setText("выберите модель и время");
        }


    }

    @FXML
    void toMarkets(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("markets_user.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    public static String[] getChoice() {
        return choice;
    }
    @FXML
    void initialize() {
        assert btn1DayAddict != null : "fx:id=\"btn1HourAddict\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1DayAltair != null : "fx:id=\"btn1HourAltair\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1DayFormat != null : "fx:id=\"btn1HourFormat\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1DayMaxit != null : "fx:id=\"btn1HourMaxit\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1DayTwister != null : "fx:id=\"btn1HourTwister\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1DayWelt != null : "fx:id=\"btn1HourWelt\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1WeekAddict != null : "fx:id=\"btn1WeekAddict\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1WeekAltair != null : "fx:id=\"btn1WeekAltair\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1WeekFormat != null : "fx:id=\"btn1WeekFormat\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1WeekMaxit != null : "fx:id=\"btn1WeekMaxit\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1WeekTwister != null : "fx:id=\"btn1WeekTwister\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn1WeekWelt != null : "fx:id=\"btn1WeekWelt\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn3DayAddict != null : "fx:id=\"btn3HourAddict\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn3DayAltair != null : "fx:id=\"btn3HourAltair\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn3DayFormat != null : "fx:id=\"btn3HourFormat\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn3DayMaxit != null : "fx:id=\"btn3HourMaxit\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn3DayTwister != null : "fx:id=\"btn3HourTwister\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btn3DayWelt != null : "fx:id=\"btn3HourWelt\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnAddict != null : "fx:id=\"btnAddict\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnAltair != null : "fx:id=\"btnAltair\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnFormat != null : "fx:id=\"btnFormat\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnMaxit != null : "fx:id=\"btnMaxit\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnNext != null : "fx:id=\"btnNext\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnOrders != null : "fx:id=\"btnOrders\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnProfile != null : "fx:id=\"btnProfile\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnTwister != null : "fx:id=\"btnTwister\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert btnWelt != null : "fx:id=\"btnWelt\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextAddict != null : "fx:id=\"errorTextAddict\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextAltair != null : "fx:id=\"errorTextAltair\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextDate != null : "fx:id=\"errorTextDate\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextFromat != null : "fx:id=\"errorTextFromat\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextMaxit != null : "fx:id=\"errorTextMaxit\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextTwister != null : "fx:id=\"errorTextTwister\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert errorTextWelt != null : "fx:id=\"errorTextWelt\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert img != null : "fx:id=\"img\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        assert i != null : "fx:id=\"i\" was not injected: check your FXML file 'bikes_kashirka.fxml'.";
        Image image = new Image(getClass().getResourceAsStream("/Bike.png"));
        i.setImage(image);


        if (choice[1] != null) {
            DateTimeFormatter input = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Форматтер для целевого формата даты
            DateTimeFormatter output = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            // Преобразование строки в LocalDate
            LocalDate _date = LocalDate.parse(choice[0], input);
            date.setValue(_date);

            if (choice[1].equals("ALTAIR AL29D")) {
                btnAltair.setSelected(true);
                if (choice[2].equals("1")) {
                    btn1DayAltair.setSelected(true);
                }
                if (choice[2].equals("3")) {
                    btn3DayAltair.setSelected(true);
                }
                if (choice[2].equals("7")) {
                    btn1WeekAltair.setSelected(true);
                }
            }
            if (choice[1].equals("ADDICT RC15")) {
                btnAddict.setSelected(true);

                if (choice[2].equals("1")) {
                    btn1DayAddict.setSelected(true);
                }
                if (choice[2].equals("3")) {
                    btn3DayAddict.setSelected(true);
                }
                if (choice[2].equals("7")) {
                    btn1WeekAddict.setSelected(true);
                }
            }

            if (choice[1].equals("FORMAT 7733")) {
                btnFormat.setSelected(true);

                if (choice[2].equals("1")) {
                    btn1DayFormat.setSelected(true);
                }
                if (choice[2].equals("3")) {
                    btn3DayFormat.setSelected(true);
                }
                if (choice[2].equals("7")) {
                    btn1WeekFormat.setSelected(true);
                }
            }

            if (choice[1].equals("TWISTER 26")) {
                btnTwister.setSelected(true);

                if (choice[2].equals("1")) {
                    btn1DayTwister.setSelected(true);
                }
                if (choice[2].equals("3")) {
                    btn3DayTwister.setSelected(true);
                }
                if (choice[2].equals("7")) {
                    btn1WeekTwister.setSelected(true);
                }
            }
            if (choice[1].equals("MAXIT D060")) {
                btnMaxit.setSelected(true);

                if (choice[2].equals("1")) {
                    btn1DayMaxit.setSelected(true);
                }
                if (choice[2].equals("3")) {
                    btn3DayMaxit.setSelected(true);
                }
                if (choice[2].equals("7")) {
                    btn1WeekMaxit.setSelected(true);
                }
            }
            if (choice[1].equals("WELT R90")) {
                btnWelt.setSelected(true);

                if (choice[2].equals("1")) {
                    btn1DayWelt.setSelected(true);
                }
                if (choice[2].equals("3")) {
                    btn3DayWelt.setSelected(true);
                }
                if (choice[2].equals("7")) {
                    btn1WeekWelt.setSelected(true);
                }
            }
        }
        else {
            LocalDate currentDate = LocalDate.now();
            date.setValue(currentDate);
        }



        LocalDate selectedDate = date.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date_format = selectedDate.format(formatter);

        //String c_d = currentDate.getYear() + "-" + currentDate.getMonth()+"-" + currentDate.getDayOfMonth();

        if(!bikes.inStock("MAXIT D060",1, date_format)){
            errorTextMaxit.setText("нет в наличии");
            btnMaxit.setDisable(true);
            btn1DayMaxit.setDisable(true);
            btn3DayMaxit.setDisable(true);
            btn1WeekMaxit.setDisable(true);
        }
        if(!bikes.inStock("FORMAT 7733",1, date_format)){
            errorTextFromat.setText("нет в наличии");
            btnFormat.setDisable(true);
            btn1DayFormat.setDisable(true);
            btn3DayFormat.setDisable(true);
            btn1WeekFormat.setDisable(true);
        } if(!bikes.inStock("WELT R90",1, date_format)){
            errorTextWelt.setText("нет в наличии");
            btnWelt.setDisable(true);
            btn1DayWelt.setDisable(true);
            btn3DayWelt.setDisable(true);
            btn1WeekWelt.setDisable(true);
        } if(!bikes.inStock("ADDICT RC15",1, date_format)){
            errorTextAddict.setText("нет в наличии");
            btnAddict.setDisable(true);
            btn1DayAddict.setDisable(true);
            btn3DayAddict.setDisable(true);
            btn1WeekAddict.setDisable(true);
        } if(!bikes.inStock("ALTAIR AL29D",1, date_format)){
            errorTextAltair.setText("нет в наличии");
            btnAltair.setDisable(true);
            btn1DayAltair.setDisable(true);
            btn3DayAltair.setDisable(true);
            btn1WeekAltair.setDisable(true);
        } if(!bikes.inStock("TWISTER 26",1, date_format)){
            errorTextTwister.setText("нет в наличии");
            btnTwister.setDisable(true);
            btn1DayTwister.setDisable(true);
            btn3DayTwister.setDisable(true);
            btn1WeekTwister.setDisable(true);
        }

        Platform.runLater(() -> {
            scrollPane.setVvalue(0);
            scrollPane.setHvalue(0);
        });

//        if (choice.isEmpty()) {
//            while (date.getValue() == null) {
//                btn1HourAddict.setSelected(false);
//                btn3HourAddict.setSelected(false);
//                btn1WeekAddict.setSelected(false);
//                btn1HourAltair.setSelected(false);
//                btn3HourAltair.setSelected(false);
//                btn1WeekAltair.setSelected(false);
//                btn1HourFormat.setSelected(false);
//                btn3HourFormat.setSelected(false);
//                btn1WeekFormat.setSelected(false);
//                btn1HourMaxit.setSelected(false);
//                btn3HourMaxit.setSelected(false);
//                btn1WeekMaxit.setSelected(false);
//                btn1HourWelt.setSelected(false);
//                btn3HourWelt.setSelected(false);
//                btn1WeekWelt.setSelected(false);
//                btn1HourTwister.setSelected(false);
//                btn3HourTwister.setSelected(false);
//                btn1WeekTwister.setSelected(false);
//            }
//        }



        groupAddict = new ToggleGroup();
        btn1DayAddict.setToggleGroup(groupAddict);
        btn3DayAddict.setToggleGroup(groupAddict);
        btn1WeekAddict.setToggleGroup(groupAddict);
        btn1DayAltair.setToggleGroup(groupAddict);
        btn3DayAltair.setToggleGroup(groupAddict);
        btn1WeekAltair.setToggleGroup(groupAddict);
        btn1DayFormat.setToggleGroup(groupAddict);
        btn3DayFormat.setToggleGroup(groupAddict);
        btn1WeekFormat.setToggleGroup(groupAddict);
        btn1DayMaxit.setToggleGroup(groupAddict);
        btn3DayMaxit.setToggleGroup(groupAddict);
        btn1WeekMaxit.setToggleGroup(groupAddict);
        btn1DayWelt.setToggleGroup(groupAddict);
        btn3DayWelt.setToggleGroup(groupAddict);
        btn1WeekWelt.setToggleGroup(groupAddict);
        btn1DayTwister.setToggleGroup(groupAddict);
        btn3DayTwister.setToggleGroup(groupAddict);
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
