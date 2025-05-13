package com.example.parkinggaragemanagementsystem;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryLogger {
    private static final String LOG_FILE = "program_actions.log";

    public static void logAction(String action) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String logEntry = String.format("[%s] %s%n", timestamp, action);
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("Failed to log action: " + e.getMessage());
        }
    }
}
