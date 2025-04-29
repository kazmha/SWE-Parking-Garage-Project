package com.example.parkinggaragemanagementsystem;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingGarageApplicationTest {

    @Test
    void updateTimeTest() {
        ParkingGarageController pgc = new ParkingGarageController();
        pgc.updateTime();

        String labelText = pgc.getCurrentTimeLabel().getText();
        assertNotNull(labelText);
        assertTrue(labelText.matches("\\d{1,2}:\\d{2} [AP]M")); // Matches time pattern
    }
}