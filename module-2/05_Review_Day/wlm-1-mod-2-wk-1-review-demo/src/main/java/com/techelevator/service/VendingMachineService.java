package com.techelevator.service;

import com.techelevator.Logger;

public class VendingMachineService {

    private Logger logger = new Logger("log.txt");
    private MessageGeneratorService messageGeneratorService = new MessageGeneratorService();
    private int balance = 5;


    public void feedMoney() {

    }

    public void maskePurchase() {

    }

    public String makeChange() {
        return "Your change is: ";
    }

    public void logMessage() {
        logger.logMessage(
                messageGeneratorService.getMessage(MessageGeneratorService.FEED_MONEY, 5, 100)
        );
        balance += 10;
    }


//        String msg = messageGeneratorService.getMessage(MessageGeneratorService.FEED_MONEY, 5, 100);
//        logger.logMessage(msg);
}
