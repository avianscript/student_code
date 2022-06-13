package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class Scratchpad {

    public static void main(String[] args) {

        Scratchpad pad = new Scratchpad();

        /*
        Scanner keyboard = new Scanner(System.in);

        pad.simpleExample();

        pad.loopTillExit(keyboard);

        pad.loopTillValid(keyboard);

         */

        String message = pad.demoStringFormat("Yoav", 5, 1.25);
        System.out.println(message);

        message = pad.demoStringFormat("Jim", 10, 2.75);
        System.out.println(message);


    }

    public String demoStringFormat(String name, int messageCount, double price) {

//        return name + ", you have " + messageCount + " messages.";

        return String.format("%s, you have %d messages. Price %.2f", name, messageCount, price);

    }

    public void simpleExample() {

        // printFileInfo throws exception so we must wrap in try
        try {

            // this will work and continue
            printFileInfo("src/main/java/com/techelevator/Person.java");

            // this will cause an exception so code will stop and go to catch bloc,
            printFileInfo("src");

            // since exception was thrown we will never get here
            printFileInfo("blah");

        } catch (InvalidFilePathException ex) {
            // if exception occurs, flow will be interrupted and we will get her instead
            System.out.println("Issue with path: " + ex.getMessage());
        }
    }

    public void loopTillExit(Scanner keyboard) {

        boolean done = false;

        // loop as long as we are not done
        while (!done) {

            System.out.print("Enter a path (X to exist): ");
            String path = keyboard.nextLine();

            // do something if user didn't type X
            if (!path.equalsIgnoreCase("X")) {
                try {

                    // print file info
                    printFileInfo(path);

                } catch (InvalidFilePathException ex) {

                    // if invalid path let the use know
                    System.out.println("Issue with path: " + ex.getMessage());
                }
            } else {

                // User typed X... set done to true so loop will stop.
                done = true;
            }
        }

    }

    public void loopTillValid(Scanner keyboard) {
        boolean done = false;

        // loop as long as we are not done
        while (!done) {

            System.out.print("Enter a path: ");
            String path = keyboard.nextLine();

            try {

                // pass the path to the method
                printFileInfo(path);

                // if we get here a valid path was entered and we will set
                // done to true so the loop stops
                done = true;

            } catch (InvalidFilePathException ex) {
                // an invalid path was typed so we will print the message
                // but NOT set done to true we we will continue to
                // loop UNTIL we get a valid path
                System.out.println("Issue with path: " + ex.getMessage());
            }
        }
    }


    public void printFileInfo(String path) throws InvalidFilePathException {

        File file = new File(path);

        if (!file.exists()) {
//            System.out.println("Doesn't exist");
//            System.exit(1);

            // instead of using System.exit [AVOID THAT!!!] we will throw an exception
            throw new InvalidFilePathException(path + " doesn't exists");
        } else if (!file.isFile()) {
//            System.out.println("Not a file");
//            System.exit(1);

            // instead of using System.exit [AVOID THAT!!!] we will throw an exception
            throw new InvalidFilePathException(path + " is not a file");
        } else {
            System.out.println(file.getAbsolutePath());
        }

    }

    public void demoTest() throws MyCheckedException{

        doDemo();

    }



    public void doDemo() throws MyCheckedException {

        // Some code

        throw  new MyCheckedException("Error message");
    }

    public void demoRuntimeExceptionTest() {

        doRuntimeExceptionDemo();

    }

    public void doRuntimeExceptionDemo() throws MyRuntimeException {

        // Some code

        throw  new MyRuntimeException("Error message");
    }

}
