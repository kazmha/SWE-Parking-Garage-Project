package com.example.parkinggaragemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ParkingGarageApplication extends Application {
    private static Stage primaryStage;

    public static void restart() throws IOException {
        primaryStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(ParkingGarageApplication.class.getResource("ParkingGarageGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Parking Garage Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        restart();
    }

    public static void main(String[] args) {
        HistoryLogger.logAction("Program started");
        launch();
    }

    public static void checkHistory() {
        try {
            File file = new File("program_actions.log");

            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(file); // Opens with the default application
                } else {
                    System.err.println("Desktop is not supported on this platform.");
                }
            } else {
                System.err.println("File not found: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}