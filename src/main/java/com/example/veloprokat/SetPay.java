package com.example.veloprokat;

import java.io.IOException;
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

public class SetPay {

    final String nameFile = "pay.fxml";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnPay;

    @FXML
    private Label numBook;

    @FXML
    private Label status;

    @FXML
    private Label sum;

    @FXML
    private Label textOrders;


    private Bookings_SQL books;
    private Rent_SQL rents;
    private Tariff_SQL tariffs;

    public SetPay(){
        List.add(nameFile);
        books = Bookings_SQL.getInstance();
        rents = Rent_SQL.getInstance();
        tariffs = Tariff_SQL.getInstance();


    }

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void isPay(ActionEvent event) {


        boolean flag = rents.setStaus(Integer.parseInt(numBook.getText()), "оплачено");
        if (flag)
            status.setText("УСПЕШНО");
        btnPay.setDisable(true);


    }

    @FXML
    void toBack(ActionEvent event)  throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'pay.fxml'.";
        assert btnPay != null : "fx:id=\"btnPay\" was not injected: check your FXML file 'pay.fxml'.";
        assert numBook != null : "fx:id=\"numBook\" was not injected: check your FXML file 'pay.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'pay.fxml'.";
        assert sum != null : "fx:id=\"sum\" was not injected: check your FXML file 'pay.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'pay.fxml'.";


        numBook.setText(NotPay.getId_book()+"");
        int id_type = books.getTypeInBook(NotPay.getId_book());
        int days = books.getDaysForBook(NotPay.getId_book());
        sum.setText("" + tariffs.getPrice(id_type, days));


    }

}
