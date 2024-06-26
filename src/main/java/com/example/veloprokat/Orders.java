package com.example.veloprokat;

import java.io.IOException;
import java.io.InterruptedIOException;
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
public class Orders {
    final String nameFile = "orders.fxml";
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Button btnCancel;
    @FXML
    private Button btnBack;
    @FXML
    private Label textOrders;
    private Bookings_SQL books;
    private Rent_SQL rents;

    public Orders(){
        //List.add(nameFile);
        books = Bookings_SQL.getInstance();
        rents = Rent_SQL.getInstance();

    }
    @FXML
    void toBack(ActionEvent event) throws IOException {
        if (!List.list.isEmpty()) {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(List.get(List.list.size() - 1))));
            stage.setTitle("dddd");
            stage.setScene(new Scene(root, 700, 600));
            stage.show();
        }
    }
    @FXML
    void toCancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cancel_order_user.fxml")));
        stage.setTitle("dddd");
        stage.setScene(new Scene(root, 700, 600));
        stage.show();
    }
    @FXML
    void initialize() {
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'orders.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'orders.fxml'.";
        assert textOrders != null : "fx:id=\"textOrders\" was not injected: check your FXML file 'orders.fxml'.";

        ArrayList<Integer> bookings = books.bookingsForUser(EntryUser.getLogin());

        String text = "";
        for (int i =0; i < bookings.size(); i++ ){
            if (!rents.isInRent(bookings.get(i))) {
                text += bookings.get(i) + "\n";
            }
        }

        textOrders.setText(text);

    }
}