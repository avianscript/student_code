package com.techelevator;

public class Scratchpad {

    public void examples() {

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
