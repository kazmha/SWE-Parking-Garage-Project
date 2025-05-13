package com.example.parkinggaragemanagementsystem;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Objects;

public class editCarController {

    private ParkingGarageController pgc;
    private boolean isControllerReady = false;

    public void setMainController(ParkingGarageController mainController) {
        this.pgc = mainController;
        this.isControllerReady = true;
        refreshData();
    }

    private HashMap<String, Car> parkingSpots = ParkingManager.getInstance().getParkingSpots();
    private Stage stage;

    @FXML
    private Label spotId_label;

    @FXML
    private Label errorLabel;

    @FXML
    private Button updateCarButton;

    @FXML
    private TextField name_input;

    @FXML
    private TextField timeEntered_input;

    @FXML
    private TextField typeOfVehicle_input;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    TextFormatter<Double> formatter = new TextFormatter<>(change -> {
        if (change.getControlNewText().matches("\\d*\\.?\\d*")) {
            return change;
        }
        return null;
    });

    @FXML
    void updateCar() {
        String spotId = String.valueOf(pgc.getSpotStatusLabel());
        Car car = parkingSpots.get(spotId);
        try {
            if (car != null) {
                if (!timeEntered_input.getText().isEmpty()) {
                    car.setTime(timeEntered_input.getText());
                }
                car.setLicensePlateNumber(name_input.getText());
                car.setType(typeOfVehicle_input.getText());
                HistoryLogger.logAction("Spot " + spotId + " was modified");
                pgc.displayLabels(spotId);
                stage.close();

            }
        }
        catch (NumberFormatException e) {
            errorLabel.setText("Enter a number for hours!");
            timeEntered_input.setText("");
        }
    }

    @FXML
    void initialize() {
        timeEntered_input.setTextFormatter(formatter);
        updateCarButton.setOnAction(e -> updateCar());
    }

    private void refreshData() {
        if (isControllerReady && pgc != null) {
            String spotId = String.valueOf(pgc.getSpotStatusLabel());
            spotId_label.setText(spotId);
        }
    }
}