module com.example.veloprokat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.veloprokat to javafx.fxml;
    exports com.example.veloprokat;
}