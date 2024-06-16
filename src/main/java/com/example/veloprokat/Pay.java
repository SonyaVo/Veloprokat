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

public class Pay {

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
    public Pay(){
        List.add(nameFile);
    }

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void isPay(ActionEvent event) {
        Bookings_SQL book = new Bookings_SQL();
        Rent_SQL rent = new Rent_SQL();

        rent.addRent(Rent.getId_book(),"оплачено");
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

        numBook.setText(""+Rent.getId_book());
        Bikes_SQL bike = new Bikes_SQL();
        Tariff_SQL t = new Tariff_SQL();
        Bookings_SQL b = new Bookings_SQL();
        int id_type = bike.getTypeInBook(Rent.getId_book());
        int days = b.getDaysForBook(Rent.getId_book());
        sum.setText(""+t.getPrice(id_type,days));

    }

}
