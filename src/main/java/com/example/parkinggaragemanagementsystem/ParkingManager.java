package com.example.parkinggaragemanagementsystem;

import java.util.HashMap;

public class ParkingManager {
    private static ParkingManager instance;
    private HashMap<String, Car> parkingSpots;

    public void reset() {
        setParkingManager();
    }

    public ParkingManager() {
        setParkingManager();
    }

    private void setParkingManager() {
        parkingSpots = new HashMap<>();
        parkingSpots.put("A1", new Car());
        parkingSpots.put("A2", new Car());
        parkingSpots.put("A3", new Car());
        parkingSpots.put("B1", new Car());
        parkingSpots.put("B2", new Car());
        parkingSpots.put("B3", new Car());
        parkingSpots.put("C1", new Car());
        parkingSpots.put("C2", new Car());
        parkingSpots.put("C3", new Car());
        parkingSpots.put("D1", new Car());
        parkingSpots.put("D2", new Car());
        parkingSpots.put("D3", new Car());
        parkingSpots.put("E1", new Car());
        parkingSpots.put("E2", new Car());
        parkingSpots.put("E3", new Car());
    }

    public static ParkingManager getInstance() {
        if (instance == null) {
            instance = new ParkingManager();
        }
        return instance;
    }

    public HashMap<String, Car> getParkingSpots() {
        return parkingSpots;
    }

    public Car getCar(String spotID) {
        return parkingSpots.get(spotID);
    }

}
