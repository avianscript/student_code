package com.techelevator;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private File outFile;

    public Logger(String filePath) {
        outFile = new File(filePath);
    }

//    public void logFeedMoney(int startBalance, int endBalance) {
//
//        // opem file lo
//        System.out.println(getTimeStamp() + " FEED MONEY: $" + startBalance + " " + endBalance);
//
//    }
//
//    public void puchase(String item, int startBalance, int endBalance) {
//        System.out.println(getTimeStamp());
//    }
//
//    public void makeChange(int startBalance, int endBalance) {
//        System.out.println(getTimeStamp());
//    }

    public void logMessage(String message) {
        System.out.println(getTimeStamp() + " " + message);
    }

    private String getTimeStamp() {
        LocalDateTime time = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        return time.format(formatter);
    }
}
