package com.example.veloprokat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class InfBook {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnFind;

    @FXML
    private Label date;

    @FXML
    private Label errorText;

    @FXML
    private Label model;

    @FXML
    private TextField numBook;

    @FXML
    private TextField phone;

    @FXML
    private Label sum;

    @FXML
    private Label textOrders;
    private Bookings_SQL books;
    private Tariff_SQL tariffs;

    public  InfBook(){
        books = Bookings_SQL.getInstance();
        tariffs = Tariff_SQL.getInstance();


    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
    private String[] getPeriod(String date_start, String date_finish){
        // Парсер для исходного формата даты
        DateTimeFormatter input = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Форматтер для целевого формата даты
        DateTimeFormatter output = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Преобразование строки в LocalDate
        LocalDate localDateStart = LocalDate.parse(date_start, input);
        LocalDate localDateFinish = LocalDate.parse(date_finish, input);
        int days = Period.between(localDateStart, localDateFinish).getDays();

        String dateFinish  = localDateFinish.format(output);
        String dateStart = localDateStart.format(output);

        // Преобразование LocalDate в строку целевого формата
        String[] period = new String[3];
        period[0] = dateStart;
        period[1] = dateFinish;
        period[2] = String.valueOf(days);


        return period;

    }

    @FXML
    void toFind(ActionEvent event) {


        ArrayList<Integer> list = books.bookingsForUser(phone.getText());
        boolean flag = false;
        if (!numBook.getText().isEmpty()){
            for (int i=0;i<list.size();i++){
                if (Integer.parseInt(numBook.getText()) == list.get(i)){
                    flag = true;
                }
            }

        }
        if (flag) {
            String[] info = books.getInfo(Integer.parseInt(numBook.getText()));

            model.setText("Модель: "+info[0]);
            String[] period_k = getPeriod(info[1],info[2]);

            date.setText("Период: " + period_k[0] + " - " + period_k[1]);
            int id_type = books.getTypeInBook(Integer.parseInt(numBook.getText()));
            int days = books.getDaysForBook(Integer.parseInt(numBook.getText()));
            sum.setText("Сумма: " + tariffs.getPrice(id_type, Integer.parseInt(period_k[2])));
            errorText.setText("");

        }
        else {
            sum.setText("");
            model.setText("");
            date.setText("");
            errorText.setText("бронь не найдена");
        }
    }
    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert btnFind != null : "fx:id=\"btnFind\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert model != null : "fx:id=\"model\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert numBook != null : "fx:id=\"numBook\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert phone!= null : "fx:id=\"phone\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert sum != null : "fx:id=\"sum\" was not injected: check your FXML file 'inf_book.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'inf_book.fxml'.";

    }


}
