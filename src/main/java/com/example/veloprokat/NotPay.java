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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NotPay {
    final String nameFile = "not_pay.fxml";

    @FXML
    private Button btnBack;

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

    @FXML
    private Label textOrders1;

    private static int id_book=0;


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
        //Bookings_SQL book = new Bookings_SQL();
        Rent_SQL rent = new Rent_SQL();
        ArrayList<Integer> list = rent.getRentsFor(phone.getText());
        String flag = "не найдена";
        if (!numBook.getText().isEmpty()){
            for (int i=0;i<list.size();i++){
                if (Integer.parseInt(numBook.getText()) == list.get(i)){
                    if (rent.getStatus(Integer.parseInt(numBook.getText())).equals("не оплачено"))
                        flag = "не оплачено";
                    else
                        flag = "оплачено";
                }
            }

        }
        if (flag.equals("не оплачено")) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("set_pay.fxml")));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
        if (flag.equals("оплачено")) {
            errorText.setText("аренда уже оплачена");
        }
        else {
            errorText.setText("аренда не найдена");
        }
    }

    public static int getId_book() {
        return id_book;
    }

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert btnPay != null : "fx:id=\"btnPay\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert numBook != null : "fx:id=\"numBook\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'not_pay.fxml'.";
        assert textOrders1 != null : "fx:id=\"textOrders1\" was not injected: check your FXML file 'not_pay.fxml'.";

    }

}
