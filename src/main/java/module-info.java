module com.example.parkinggaragemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.parkinggaragemanagementsystem to javafx.fxml;
    exports com.example.parkinggaragemanagementsystem;
}