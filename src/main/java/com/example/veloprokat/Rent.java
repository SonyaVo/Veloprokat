package com.example.veloprokat;

import java.io.IOException;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ArrayList;
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

public class Rent {
    final String nameFile = "rent.fxml";


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnNotPay;

    @FXML
    private Button btnPay;

    @FXML
    private Label errorText;

    @FXML
    private TextField numBook;

    @FXML
    private TextField phone;

    @FXML
    private Label textOrders;
    private static int id_book;
    private Bookings_SQL books;
    private Rent_SQL rents;

    public Rent(){
        List.add(nameFile);
        books = Bookings_SQL.getInstance();
        rents = Rent_SQL.getInstance();


    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toPay(ActionEvent event)  throws IOException {
        id_book = Integer.parseInt(numBook.getText());

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
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("pay.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
        else {
            errorText.setText("бронь не найдена");
        }

    }

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void toNotPay(ActionEvent event) throws IOException {

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
            btnPay.setDisable(true);
            btnNotPay.setDisable(true);
            id_book = Integer.parseInt(numBook.getText());
            boolean res = rents.addRent(id_book,"не оплачено");
            if (res)
                errorText.setText("УСПЕШНО");
            else
                errorText.setText("попробуйте снова");
        }
        else {
            errorText.setText("бронь не найдена");
        }


    }

    public static int getId_book() {
        return id_book;
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'rent.fxml'.";
        assert btnNotPay != null : "fx:id=\"btnNotPay\" was not injected: check your FXML file 'rent.fxml'.";
        assert btnPay != null : "fx:id=\"btnPay\" was not injected: check your FXML file 'rent.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'rent.fxml'.";
        assert numBook != null : "fx:id=\"numBook\" was not injected: check your FXML file 'rent.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'rent.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'rent.fxml'.";

    }

}
