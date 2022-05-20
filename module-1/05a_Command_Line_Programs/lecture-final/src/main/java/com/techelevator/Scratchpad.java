package com.techelevator;

import java.util.Scanner;

public class Scratchpad {

    public static void main(String[] args) {
        Scratchpad pad = new Scratchpad();
        pad.run();
    }

    public void run() {


        // demo break in loop (works for all types of loops)

        // break NOT interrupt outer loop.. only loop that
        // break was in

        /*
        for (int outer = 1; outer <=5; outer++) {
            System.out.println("Outer: " + outer);
            for (int i = 1; i <= 10; i++) {
                System.out.println("i is " + i);
                if (i == 5) {
                    System.out.println("STOPPING");
                    // code will stop
                    break;
                }
            }
        }

        // demo break in loop (works for all types of loops)
        for (int num = 1; num <= 10 ; num++) {
            if (num % 2 == 0) {
                // will interrupt current iteration and move on to next one
                continue;
            }
            System.out.println("index is " + num);
        }

        System.out.println("All done!");
        */

        Scanner input = new Scanner(System.in);

//        getInput(input);
        readMultipleNames(input);

    }

    public void getInput(Scanner input) {
        input = new Scanner(System.in);

        System.out.print("Enter name: ");

        String name = input.nextLine();

        System.out.println("Hello " + name + "!");

        System.out.print("Number 1: ");
        int result = input.nextInt();
        System.out.println("Number 1: " + result);

        /*
        String resultString = input.nextLine();
        int result = Integer.parseInt(resultString);
        System.out.println(result);
        */


        System.out.print("Type something else: ");
        String typed = input.nextLine();
        System.out.println("You typed: " + typed);

//        System.out.print("Type a boolean: ");
//        String boolResult = input.nextLine();
//        boolean value = Boolean.parseBoolean(boolResult);
//        System.out.println(value);

//        System.out.print("Number 2: ");
//        result = input.nextInt();
//        System.out.println("Number " + result + "!");

        System.out.println("All done!");
    }

    public void readMultipleNames(Scanner input) {

        System.out.println("Enter names separated by commas: ");

        String userInput = input.nextLine();

        String [] names = userInput.split(",");
        System.out.println("Name counts: " + names.length);


    }
}
