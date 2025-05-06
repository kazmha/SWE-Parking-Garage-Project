package com.example.parkinggaragemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.HashMap;

public class addCarController {

    private ParkingGarageController pgc;

    public void setMainController(ParkingGarageController mainController) {
        this.pgc = mainController;
    }

    private HashMap<String, Car> parkingSpots = ParkingManager.getInstance().getParkingSpots();
    private Stage stage;

    @FXML
    private Button addCarButton;

    @FXML
    private Button removeCarButton;

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

    @FXML
    void addCar() {
        String spotId = spotId_input.getText();
        Car car = parkingSpots.get(spotId);
        if (car != null) {
            car.setId(spotId);
            car.setLicensePlateNumber(name_input.getText());
            car.setTime(timeEntered_input.getText());
            car.setType(typeOfVehicle_input.getText());
            pgc.displayImageOccupied(spotId);
            pgc.carsEntered++;
            pgc.carSpots--;
            pgc.occupiedSpots++;
        }
    }

    @FXML
    void removeCar() {
        String spotId = spotId_input.getText();
        Car car = parkingSpots.get(spotId);
        if (car != null) {
            parkingSpots.put(spotId, new Car());
            pgc.displayImageUnoccupied(spotId);
            pgc.carsExited++;
            pgc.occupiedSpots--;
            pgc.carSpots++;
        }
    }

    @FXML
    public void initialize() {
        addCarButton.setOnAction(e -> {
            addCar();
            pgc.counter();
            stage.close();
        });
        removeCarButton.setOnAction(e -> {
            removeCar();
            pgc.counter();
            stage.close();
        });
    }
}

