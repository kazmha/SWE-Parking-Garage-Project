package com.example.parkinggaragemanagementsystem;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ParkingGarageController {
    @FXML private Button addCarButton;
    @FXML private Button buttonA1;
    @FXML private Button buttonA2;
    @FXML private Button buttonA3;
    @FXML private Button buttonB1;
    @FXML private Button buttonB2;
    @FXML private Button buttonB3;
    @FXML private Button buttonC1;
    @FXML private Button buttonC2;
    @FXML private Button buttonC3;
    @FXML private Button buttonD1;
    @FXML private Button buttonD2;
    @FXML private Button buttonD3;
    @FXML private Button buttonE1;
    @FXML private Button buttonE2;
    @FXML private Button buttonE3;
    @FXML private Button calculateSpotButton;
    @FXML private Label carsEnteredLabel;
    @FXML private Label carsExitedLabel;
    @FXML private Label currentProfitLabel;
    @FXML private Label currentRevenueLabel;
    @FXML private Label currentTimeLabel;
    @FXML private Button editButton;
    @FXML private Button exitButton;
    @FXML private Button historyButton;
    @FXML private Label occupiedSpotsLabel;
    @FXML private Button removeCarButton;
    @FXML private Button resetButton;
    @FXML private Label spotBaseCostLabel;
    @FXML private Label spotLateFeeLabel;
    @FXML private Label spotLicensePlateLabel;
    @FXML private Label spotStatusLabel;
    @FXML private Label spotTaxesLabel;
    @FXML private Label spotTimeFrameLabel;
    @FXML private Label spotTotalCostLabel1;
    @FXML private Label spotVehicleTypeLabel;
    @FXML private Label todaysDateLabel;
    @FXML private Button undoButton;
    @FXML private Label vacantSpotsLabel;

    private Timeline timeline;

    public Label getCurrentTimeLabel() {
        return currentTimeLabel;
    }

    public void updateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("K:mm a");
        currentTimeLabel.setText(LocalTime.now().format(formatter));
    }

    @FXML
    public void initialize() {
        buttonA1.setOnAction(e -> System.out.println("Button A1 was pressed!"));
        buttonA2.setOnAction(e -> System.out.println("Button A2 was pressed!"));
        buttonA3.setOnAction(e -> System.out.println("Button A3 was pressed!"));
        buttonB1.setOnAction(e -> System.out.println("Button B1 was pressed!"));
        buttonB2.setOnAction(e -> System.out.println("Button B2 was pressed!"));
        buttonB3.setOnAction(e -> System.out.println("Button B3 was pressed!"));
        buttonC1.setOnAction(e -> System.out.println("Button C1 was pressed!"));
        buttonC2.setOnAction(e -> System.out.println("Button C2 was pressed!"));
        buttonC3.setOnAction(e -> System.out.println("Button C3 was pressed!"));
        buttonD1.setOnAction(e -> System.out.println("Button D1 was pressed!"));
        buttonD2.setOnAction(e -> System.out.println("Button D2 was pressed!"));
        buttonD3.setOnAction(e -> System.out.println("Button D3 was pressed!"));
        buttonE1.setOnAction(e -> System.out.println("Button E1 was pressed!"));
        buttonE2.setOnAction(e -> System.out.println("Button E2 was pressed!"));
        buttonE3.setOnAction(e -> System.out.println("Button E3 was pressed!"));

        exitButton.setOnAction(e -> System.exit(0));

        updateTime();

        timeline = new Timeline(new KeyFrame(Duration.minutes(1), e -> updateTime()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Thread clock = new Thread() {
            public void run() {
                Calendar calendar = Calendar.getInstance();
                String[] days = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
                String currentDay = days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
                String currentMonth = months[calendar.get(Calendar.MONTH)];
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);int year = calendar.get(Calendar.YEAR);

                todaysDateLabel.setText(" " + currentDay + ", \n" + currentMonth + " " + day + ", " + year);

                }
        };
        clock.start();
    }

}