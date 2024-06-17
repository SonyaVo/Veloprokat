package com.example.veloprokat;

import java.io.IOException;
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
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label res;

    @FXML
    private Button btnBook;


    @FXML
    private Button btnBack;

    @FXML
    private Label numberBook;

    private String choice = "";

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
    }

    @FXML
    void toBook(ActionEvent event) {
        // Set the text of the label to "1234"
        numberBook.setText("1234");
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




    @FXML
    void initialize() {
        assert btnBook != null : "fx:id=\"btnBook\" was not injected: check your FXML file 'result.fxml'.";
        assert btnBack != null : "fx:id=\"btnBack\" was not injected: check your FXML file 'result.fxml'.";
        assert numberBook != null : "fx:id=\"numberBook\" was not injected: check your FXML file 'result.fxml'.";
        assert res != null : "fx:id=\"res\" was not injected: check your FXML file 'result.fxml'.";


        res.setText(choice);





    }
}
