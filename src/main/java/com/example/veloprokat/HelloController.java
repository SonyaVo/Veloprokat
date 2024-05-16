package com.example.veloprokat;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button mainBtn;

    @FXML
    private Label mainLabel;

    @FXML
    void btnClick(ActionEvent event) {
        mainLabel.setText(mainBtn.getText());

    }

    @FXML
    void initialize() {
        assert mainBtn != null : "fx:id=\"mainBtn\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert mainLabel != null : "fx:id=\"mainLabel\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

}
