module com.example.activities {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.activities to javafx.fxml;
    exports com.example.activities;
}