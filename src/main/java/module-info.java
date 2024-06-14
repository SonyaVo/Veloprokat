module com.example.veloprokat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.veloprokat to javafx.fxml;
    exports com.example.veloprokat;
}