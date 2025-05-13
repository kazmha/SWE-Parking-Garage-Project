package com.example.parkinggaragemanagementsystem;

public class HourlyRates {
    private double hours;
    private double rate;

    public HourlyRates(double hours, double rate) {
        this.hours = hours;
        this.rate = rate;
    }

    public HourlyRates() {
        hours = 0;
        rate = 0;
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
        if (this.hours <= 0)
            return 0;
        else if (this.hours <= 1)
            return 9.25;
        else if (this.hours <= 2)
            return 15.95;
        else if (this.hours <= 4)
            return 24.95;
        else if (this.hours <= 8)
            return 60.95;
        else if (this.hours <= 12)
            return 84.95;
        else
            return 149.95;
    }
}
