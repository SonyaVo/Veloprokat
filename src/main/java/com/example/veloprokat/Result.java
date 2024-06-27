package com.example.veloprokat;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class Result {
    final String nameFile = "result.fxml";
    @FXML
    private Button btnBack;

    @FXML
    private Button btnBook;

    @FXML
    private Label market;
    private ResourceBundle resources;

    @FXML
    private Label date;

    private URL location;
    @FXML
    private Label model;

    @FXML
    private Label numberBook;


    @FXML
    private Label price;

    private static String[] tariff = new String[2];

    private static String[] choice= new String[3];

    private static String varModel = "";
    private static int varMarket;
    private static LocalDate varDateStart;
    private static LocalDate varDateFinish ;
    private static LocalDate remDateStart;
    @FXML
    private Label errorText;


    private static LocalDate remDateFinish;
    private Bookings_SQL books;


    public Result(){
        List.add(nameFile);
        switch (List.get(List.list.size() - 2)){
            case ("bikes_kashirka.fxml"):
                //choice = BikesKashirka.getChoice();
                break;
            case ("bikes_semenovskaya.fxml"):
                //choice = BikesSemenovskaya.getChoice();
                break;

            case ("bikes_nikitskaya.fxml"):
                //choice = BikesNikitskaya.getChoice();
                break;

        }
        books = Bookings_SQL.getInstance();

    }

    @FXML
    void toBook(ActionEvent event) {
        //Users_SQL user = new Users_SQL();
        if(!books.getBookingForTheDate(EntryUser.getLogin(),varDateStart) ) {
            btnBook.setDisable(false);

            books.addBooking(varModel, EntryUser.getLogin(), varMarket, varDateStart, varDateFinish);

            numberBook.setText(books.getId(EntryUser.getLogin(), varDateStart) + "");
            btnBook.setDisable(true);

            remDateStart = varDateStart;
            choice[1]= null;
            choice[2] = null;
            //errorText.setText("нет броней");
        }
        else {
            btnBook.setDisable(true);
            errorText.setText("на этот день у вас уже забронирован велосипед");

        }
        // Set the text of the label to "1234"
        //numberBook.setText("1234");
    }

    @FXML
    void toMarkets(ActionEvent event) throws IOException {
        if (!List.list.isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(List.get(List.list.size() - 2))));
            stage.setTitle("Markets");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
    }

    private String[] getPeriod(String date, String days){
        // Парсер для исходного формата даты
        DateTimeFormatter input = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Форматтер для целевого формата даты
        DateTimeFormatter output = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Преобразование строки в LocalDate
        LocalDate localDateStart = LocalDate.parse(date, input);

        // Прибавление двух дней
        LocalDate localDateFinish = localDateStart.plusDays(Integer.parseInt(days));

        String dateFinish  = localDateFinish.format(output);
        String dateStart = localDateStart.format(output);

        // Преобразование LocalDate в строку целевого формата
        String[] period = new String[2];
        period[0] = dateStart;
        period[1] = dateFinish;

        varDateStart = localDateStart;
        varDateFinish = localDateFinish;

        return period;

    }

    public static String[] getChoice() {
        return choice;
    }

    private String getFullModel(String bike){
        switch (bike){
            case ("MAXIT D060"):
            case ("FORMAT 7733"):
                tariff[0] = "городской";
                tariff[1] = "2 передачи";
                break;
            case ("WELT R90"):
                tariff[0] = "шоссейный";
                tariff[1] = "20 передач";
                break;
            case ("ADDICT RC15"):
                tariff[0] = "шоссейный";
                tariff[1] = "24 передачи";
                break;
            case ("ALTAIR AL29D"):
                tariff[0] = "горный";
                tariff[1] = "11 передач";
                break;
            case ("TWISTER 26"):
                tariff[0] = "горный";
                tariff[1] = "12 передач";
                break;
        }
        return (bike + ", "+ tariff[0] + ", "+ tariff[1]);
    }

    @FXML
    void initialize() {
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'result.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'result.fxml'.";
        assert btnBook != null : "fx:id=\"btnBook\" was not injected: check your FXML file 'result.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'result.fxml'.";
        assert model != null : "fx:id=\"model\" was not injected: check your FXML file 'result.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'result.fxml'.";
        assert numberBook != null : "fx:id=\"numberBook\" was not injected: check your FXML file 'result.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'result.fxml'.";
        assert market != null : "fx:id=\"market\" was not injected: check your FXML file 'result.fxml'.";


        switch (List.get(List.list.size() - 2)){
            case ("bikes_kashirka.fxml"):

                choice = BikesKashirka.getChoice();

                String[] period_k = getPeriod(choice[0],choice[2]);

                date.setText(period_k[0] + " - " + period_k[1]);

                market.setText("'Крути', Каширская улица, дом 3, корпус 1");

                model.setText(getFullModel(choice[1]));

                switch (tariff[0]) {
                    case ("городской"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("200 руб.");
                                break;
                            case ("3"):
                                price.setText("600 руб.");
                                break;
                            case ("7"):
                                price.setText("1500 руб.");
                                break;
                        }
                        break;
                    case ("шоссейный"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("300 руб.");
                                break;
                            case ("3"):
                                price.setText("900 руб.");
                                break;
                            case ("7"):
                                price.setText("2000 руб.");
                                break;
                        }
                        break;
                    case ("горный"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("400 руб.");
                                break;
                            case ("3"):
                                price.setText("1200 руб.");
                                break;
                            case ("7"):
                                price.setText("2700 руб.");
                                break;
                        }
                        break;
                }
                varMarket = 1;
                varModel = choice[1];
                break;
            case ("bikes_semenovskaya.fxml"):
                choice = BikesSemenovskaya.getChoice();

                String[] period_s = getPeriod(choice[0],choice[2]);

                date.setText(period_s[0] + " - " + period_s[1]);
                //model.setText(getTarrif(choice[1]));
                market.setText("'Мчи', Большая семеновская улица, дом 55");
                model.setText(getFullModel(choice[1]));

                switch (tariff[0]) {
                    case ("городской"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("200 руб.");
                                break;
                            case ("3"):
                                price.setText("600 руб.");
                                break;
                            case ("7"):
                                price.setText("1500 руб.");
                                break;
                        }
                        break;
                    case ("шоссейный"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("300 руб.");
                                break;
                            case ("3"):
                                price.setText("900 руб.");
                                break;
                            case ("7"):
                                price.setText("2000 руб.");
                                break;
                        }
                        break;
                    case ("горный"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("400 руб.");
                                break;
                            case ("3"):
                                price.setText("1200 руб.");
                                break;
                            case ("7"):
                                price.setText("2700 руб.");
                                break;
                        }
                        break;
                }
                varMarket = 3;
                varModel = choice[1];

                break;

            case ("bikes_nikitskaya.fxml"):
                choice = BikesNikitskaya.getChoice();

                String[] period_n = getPeriod(choice[0],choice[2]);

                date.setText(period_n[0] + " - " + period_n[1]);
                //model.setText(getTarrif(choice[1]));
                market.setText("'Велик', Никитская улица, дом 22");
                model.setText(getFullModel(choice[1]));

                switch (tariff[0]) {
                    case ("городской"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("200 руб.");
                                break;
                            case ("3"):
                                price.setText("600 руб.");
                                break;
                            case ("7"):
                                price.setText("1500 руб.");
                                break;
                        }
                        break;
                    case ("шоссейный"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("300 руб.");
                                break;
                            case ("3"):
                                price.setText("900 руб.");
                                break;
                            case ("7"):
                                price.setText("2000 руб.");
                                break;
                        }
                        break;
                    case ("горный"):
                        switch (choice[2]) {
                            case ("1"):
                                price.setText("400 руб.");
                                break;
                            case ("3"):
                                price.setText("1200 руб.");
                                break;
                            case ("7"):
                                price.setText("2700 руб.");
                                break;
                        }
                        break;
                }

                varMarket = 2;
                varModel = choice[1];
                break;

        }


        //res.setText(choice);
        //res.setText(choice);



    }
}