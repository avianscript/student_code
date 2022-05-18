package com.techelevator;

public class Scratchpad {

    public void examples() {

/*
        boolean isItFall = false;

        if (!isItFall) {
//            System.out.println("It's Fall");
            System.out.println("It's NOT Fall");
        } else {
//            System.out.println("It's NOT Fall");
            System.out.println("It's Fall");
        }
        */

//        doSomeStuff(true);
//        doSomeStuff(false);

//        doSomeStuffWithoutBlock(true);
//        doSomeStuffWithoutBlock(false);
        boolean result = returnTrueWhenGreaterThanFiveInOneLine(9);
        System.out.println(result);

        System.out.println("--------------------------------------");
        int value = 15;

//        if (value >= 10) {
//            System.out.println(">= 10");
//        } else if (value > 6) {
//            System.out.println("> 6");
//        } else if (value == 1) {
//
//        }
//        else {
//            System.out.println("NO MATCH");
//        }

        if (value > 6) {
            System.out.println("> 6");
        } else if (value >= 10) {
            System.out.println(">= 10");
        } else if (value == 1) {

        }
        else {
            System.out.println("NO MATCH");
        }

    }

    public boolean returnTrueWhenGreaterThanFiveInOneLine(int number) {
        return number > 5; // What can we put here that returns a boolean that we want?
    }

    public void doSomeStuff(boolean isComplete) {
        if (isComplete) {
            System.out.println("It's complete");
            System.out.println("Really... it's complete");
        }
        System.out.println("all done");
    }

    public void doSomeStuffWithoutBlock(boolean isComplete) {
        if (isComplete)
            System.out.println("It's complete");
        System.out.println("Really... it's complete");

        System.out.println("all done");
    }


    // don't worry about what this is doing right now

    public static void main(String[] args) {
        Scratchpad pad = new Scratchpad();
        pad.examples();
    }


}
