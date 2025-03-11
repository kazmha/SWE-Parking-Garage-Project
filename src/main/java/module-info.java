module com.example.parkinggaragemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.parkinggaragemanagementsystem to javafx.fxml;
    exports com.example.parkinggaragemanagementsystem;
}