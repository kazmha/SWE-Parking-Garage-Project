package com.example.parkinggaragemanagementsystem;

public class HourlyRates {
    private double hours;
    private double rate;

    public HourlyRates(double hours, double rate) {
        this.hours = hours;
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double calculateRate() {
        if (hours <= 1)
            return 9.25;
        else if (hours <= 2)
            return 15.95;
        else if (hours <= 4)
            return 24.95;
        else if (hours <= 8)
            return 60.95;
        else if (hours <= 12)
            return 84.95;
        else
            return 149.95;
    }
}
