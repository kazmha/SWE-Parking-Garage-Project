package com.example.parkinggaragemanagementsystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Car {
    private StringProperty id;
    private StringProperty licensePlateNumber;
    private StringProperty time;
    private StringProperty type;

    public Car(StringProperty id, StringProperty licensePlateNumber, StringProperty time, StringProperty type) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.time = time;
        this.type = type;
    }

    public Car() {
        id = new SimpleStringProperty("Unoccupied");
        licensePlateNumber = new SimpleStringProperty("N/A");
        time = new SimpleStringProperty("0");
        type = new SimpleStringProperty("N/A");
    }

    public String getId() {
        return id.get();
    }
    public void setId(String id) {
        this.id.set(id);
    }
    public StringProperty idProperty() {
        return id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber.get();
    }
    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber.set(licensePlateNumber);
    }
    public StringProperty licensePlateNumberProperty() {
        return licensePlateNumber;
    }

    public String getTime() {
        return time.get();
    }
    public void setTime(String time) {
        this.time.set(time);
    }
    public StringProperty timeProperty() {
        return time;
    }

    public String getType() {
        return type.get();
    }
    public void setType(String type) {
        this.type.set(type);
    }
    public StringProperty typeProperty() {
        return type;
    }

}
