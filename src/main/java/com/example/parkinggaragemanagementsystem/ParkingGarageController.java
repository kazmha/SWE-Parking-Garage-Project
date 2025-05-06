package com.example.parkinggaragemanagementsystem;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javafx.scene.image.ImageView;


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
    @FXML private Label carSpotLabel;
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
    @FXML private ImageView imageA1;
    @FXML private ImageView imageA2;
    @FXML private ImageView imageA3;
    @FXML private ImageView imageB1;
    @FXML private ImageView imageB2;
    @FXML private ImageView imageB3;
    @FXML private ImageView imageC1;
    @FXML private ImageView imageC2;
    @FXML private ImageView imageC3;
    @FXML private ImageView imageD1;
    @FXML private ImageView imageD2;
    @FXML private ImageView imageD3;
    @FXML private ImageView imageE1;
    @FXML private ImageView imageE2;
    @FXML private ImageView imageE3;
    @FXML private ImageView image;


    private Timeline timeline;

    public Label getCurrentTimeLabel() {
        return currentTimeLabel;
    }

    public void changeImage() {
// todo set up way to change vacant image to the other image (with red car) when spot is currently occupied
    }

    public void updateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("K:mm a");
        currentTimeLabel.setText(LocalTime.now().format(formatter));
    }

    @FXML
    public void initialize() {
        buttonA1.setOnAction(e -> carSpotLabel.setText("A1:"));
        buttonA2.setOnAction(e -> carSpotLabel.setText("A2:"));
        buttonA3.setOnAction(e -> carSpotLabel.setText("A3:"));
        buttonB1.setOnAction(e -> carSpotLabel.setText("B1:"));
        buttonB2.setOnAction(e -> carSpotLabel.setText("B2:"));
        buttonB3.setOnAction(e -> carSpotLabel.setText("B3:"));
        buttonC1.setOnAction(e -> carSpotLabel.setText("C1:"));
        buttonC2.setOnAction(e -> carSpotLabel.setText("C2:"));
        buttonC3.setOnAction(e -> carSpotLabel.setText("C3:"));
        buttonD1.setOnAction(e -> carSpotLabel.setText("D1:"));
        buttonD2.setOnAction(e -> carSpotLabel.setText("D2:"));
        buttonD3.setOnAction(e -> carSpotLabel.setText("D3:"));
        buttonE1.setOnAction(e -> carSpotLabel.setText("E1:"));
        buttonE2.setOnAction(e -> carSpotLabel.setText("E2:"));
        buttonE3.setOnAction(e -> carSpotLabel.setText("E3:"));

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
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                todaysDateLabel.setText(" " + currentDay + ", \n" + currentMonth + " " + day + ", " + year);

                }
        };
        clock.start();
    }

}