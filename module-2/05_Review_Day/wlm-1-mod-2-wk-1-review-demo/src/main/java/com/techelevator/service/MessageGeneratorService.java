package com.techelevator.service;

public class MessageGeneratorService {

    public static final String FEED_MONEY = "FEED_MONEY";
    public static final String PURCHASE = "Purchase";
    public static final String MAKE_CHANGE = "GIVE_CHANGE";


    public String getMessage(String msgType, int startBalance, int endBalance) {

        String msg = "";

        if (msgType.equals(FEED_MONEY)) {
            return "FEED MONEY: $" + startBalance + " $" + endBalance;
        } else if (msg.equals("PURCHASE")) {
            return "Crunchie B4 $" + startBalance + " $" + endBalance;
        } else if (msg.equals(MAKE_CHANGE)) {
            return "GOVE CHANGE: $" + startBalance + " $" + endBalance;
        }


        return msg;

    }

}
