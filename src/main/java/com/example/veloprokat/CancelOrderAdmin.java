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

public class CancelOrderAdmin {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCancel;

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

    @FXML
    void toBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choice_admin.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }

    @FXML
    void toCancel(ActionEvent event) throws IOException {
        Bookings_SQL book = new Bookings_SQL();
        Rent_SQL rent = new Rent_SQL();
        ArrayList<Integer> list = book.bookingsForUser(phone.getText());
        String flag = "false";
        if (!numBook.getText().isEmpty()){
            for (int i=0;i<list.size();i++){
                if (Integer.parseInt(numBook.getText()) == list.get(i)){
                    if (rent.isInRent(Integer.parseInt(numBook.getText()))){
                        flag = "арендован";
                    }
                    else
                        flag = "true";

                }
            }

        }
        if (flag.equals("true")) {
            book.deleteBooking(Integer.parseInt(numBook.getText()));
            btnCancel.setDisable(true);
            errorText.setText("УСПЕШНО");
        }
        if (flag.equals("арендован")) {
            errorText.setText("находиться в аренде");

        }
        if (flag.equals("false")) {
            errorText.setText("бронь не найдена");
        }
    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'cancel_order_admin.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'cancel_order_admin.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'cancel_order_admin.fxml'.";
        assert numBook != null : "fx:id=\"numBook\" was not injected: check your FXML file 'cancel_order_admin.fxml'.";
        assert phone != null : "fx:id=\"phone\" was not injected: check your FXML file 'cancel_order_admin.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'cancel_order_admin.fxml'.";
        assert textOrders1 != null : "fx:id=\"textOrders1\" was not injected: check your FXML file 'cancel_order_admin.fxml'.";

    }

}
