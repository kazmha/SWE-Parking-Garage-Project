package com.example.parkinggaragemanagementsystem;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
    @FXML private Label carSpotLabel;
    @FXML private Label currentProfitLabel;
    @FXML private Label currentRevenueLabel;
    @FXML private Label currentTimeLabel;
    @FXML private Button editButton;
    @FXML private Button exitButton;
    @FXML private Button historyButton;
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

    public Image loadImage() {
        Image image = new Image(getClass().getResource("/com/example/images/carPlaceHolderImage.png").toExternalForm());
        return image;
    }

    public Label getCurrentTimeLabel() {
        return currentTimeLabel;
    }

    public void updateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("K:mm a");
        currentTimeLabel.setText(LocalTime.now().format(formatter));
    }

    public void displayLabels(String spotId) {
        Car car = ParkingManager.getInstance().getCar(spotId);

        if (car != null) {
            spotStatusLabel.setText(car.getId());
            spotLicensePlateLabel.setText(car.getLicensePlateNumber());
            spotTimeFrameLabel.setText(car.getTime());
            spotVehicleTypeLabel.setText(car.getType());
        }
    }

    public void displayImage(String spotId) {

    }

    @FXML
    public void initialize() {
        buttonA1.setOnAction(e -> displayLabels("A1"));
        buttonA2.setOnAction(e -> displayLabels("A2"));
        buttonA3.setOnAction(e -> displayLabels("A3"));
        buttonB1.setOnAction(e -> displayLabels("B1"));
        buttonB2.setOnAction(e -> displayLabels("B2"));
        buttonB3.setOnAction(e -> displayLabels("B3"));
        buttonC1.setOnAction(e -> displayLabels("C1"));
        buttonC2.setOnAction(e -> displayLabels("C2"));
        buttonC3.setOnAction(e -> displayLabels("C3"));
        buttonD1.setOnAction(e -> displayLabels("D1"));
        buttonD2.setOnAction(e -> displayLabels("D2"));
        buttonD3.setOnAction(e -> displayLabels("D3"));
        buttonE1.setOnAction(e -> displayLabels("E1"));
        buttonE2.setOnAction(e -> displayLabels("E2"));
        buttonE3.setOnAction(e -> displayLabels("E3"));

        addCarButton.setOnAction(e -> openAddCarWindow());
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

    @FXML
    public void openAddCarWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("addCar.fxml"));
            Parent root = loader.load();
            addCarController addCarController = loader.getController();
            Stage stage = new Stage();
            stage.setTitle("Add Car");
            stage.setScene(new Scene(root));
            addCarController.setStage(stage);
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}