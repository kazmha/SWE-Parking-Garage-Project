package com.example.parkinggaragemanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Objects;

public class addCarController {

    private ParkingGarageController pgc;

    public void setMainController(ParkingGarageController mainController) {
        this.pgc = mainController;
    }

    private HashMap<String, Car> parkingSpots = ParkingManager.getInstance().getParkingSpots();
    private Stage stage;

    @FXML
    private Label errorLabel;

    @FXML
    private Button addCarButton;

    @FXML
    private Button removeCarButton;

    @FXML
    private Button updateCarButton;

    @FXML
    private TextField name_input;

    @FXML
    private TextField spotId_input;

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
    void addCar() {
        String spotId = spotId_input.getText().toUpperCase();
        Car car = parkingSpots.get(spotId);
        if (spotId_input.getText().isEmpty()) {
            errorLabel.setText("Enter Spot ID!");
        }
        else {
            try {
                if (car != null) {
                    if (Objects.equals(car.getId(), spotId)) {
                        errorLabel.setText("Car already exists!");
                        spotId_input.setText("");
                    }
                    else if (timeEntered_input.getText().isEmpty()) {
                        errorLabel.setText("Enter a number for hours!");
                    }
                    else {
                        car.setId(spotId);
                        car.setLicensePlateNumber(name_input.getText());
                        car.setTime(timeEntered_input.getText());
                        car.setType(typeOfVehicle_input.getText());
                        pgc.calculateSpotButton.setDisable(false);
                        pgc.displayImageOccupied(spotId);
                        pgc.carsEntered++;
                        pgc.carSpots--;
                        pgc.occupiedSpots++;
                        pgc.counter();
                        HistoryLogger.logAction("Added Car in " + spotId + " to Parking Garage");
                        stage.close();
                    }
                }
                else {
                    errorLabel.setText("Spot ID doesn't exist!");
                    spotId_input.setText("");
                }

            }
            catch (NumberFormatException e) {
                errorLabel.setText("Enter a number for hours!");
                timeEntered_input.setText("");
            }
        }
    }

    @FXML
    void removeCar() {
        String spotId = spotId_input.getText().toUpperCase();
        Car car = parkingSpots.get(spotId);
        if (spotId_input.getText().isEmpty()) {
            errorLabel.setText("Enter Spot ID!");
        }
        else {
            if (car != null && !car.getId().isEmpty()) {
                parkingSpots.put(spotId, new Car());
                pgc.displayImageUnoccupied(spotId);
                pgc.carsExited++;
                pgc.occupiedSpots--;
                pgc.carSpots++;
                pgc.counter();
                HistoryLogger.logAction("Removed Car in " + spotId + " from Parking Garage");
                stage.close();
            }
            else
                errorLabel.setText("Spot is unoccupied!");
        }
    }

    @FXML
    public void initialize() {
        timeEntered_input.setTextFormatter(formatter);

        addCarButton.setOnAction(e -> addCar());
        removeCarButton.setOnAction(e -> removeCar());
    }
}

