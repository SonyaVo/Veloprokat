package com.example.veloprokat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelOrderUser {

    final String nameFile = "cancel_order_user.fxml";
    @FXML
    private Button btnBack;

    @FXML
    private Button btnCancel;

    @FXML
    private Label errorText;

    @FXML
    private TextField numBook;

    @FXML
    private Label textOrders;

    public CancelOrderUser(){
        List.add(nameFile);
    }

    public String getNameFile() {
        return nameFile;
    }

    @FXML
    void toBack(ActionEvent event) throws IOException {
        if (!List.list.isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(List.get(List.list.size() - 2))));
            stage.setTitle("");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
    }

    @FXML
    void toCancel(ActionEvent event) throws IOException {
        Bookings_SQL book = new Bookings_SQL();
        ArrayList<Integer> list = book.bookingsForUser(EntryUser.getLogin());
        boolean flag = false;
        if (!numBook.getText().isEmpty()){
            for (int i=0;i<list.size();i++){
                if (Integer.parseInt(numBook.getText()) == list.get(i)){
                    flag = true;
                }
            }

        }
        if (flag) {
            book.deleteBooking(Integer.parseInt(numBook.getText()));
            btnCancel.setDisable(true);
            errorText.setText("УСПЕШНО");
        }
        else {
            errorText.setText("бронь не найдена");
        }

    }

    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'cancel_order_user.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'cancel_order_user.fxml'.";
        assert errorText != null : "fx:id=\"errorText\" was not injected: check your FXML file 'cancel_order_user.fxml'.";
        assert numBook != null : "fx:id=\"numBook\" was not injected: check your FXML file 'cancel_order_user.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'cancel_order_user.fxml'.";


    }

}
