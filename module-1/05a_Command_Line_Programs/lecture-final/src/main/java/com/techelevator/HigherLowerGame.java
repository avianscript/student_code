package com.techelevator;

import org.w3c.dom.ls.LSOutput;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class HigherLowerGame {

    public static void main(String[] args) {

        HigherLowerGame higherLower = new HigherLowerGame();
        higherLower.run();
    }



    public void run() {

        // Create a Scanner to use for input
        Scanner userInput = new Scanner(System.in);

        // Get a string with the name of players
        System.out.print("Enter names of players separated by spaces: ");

        //TODO
        // Read the input into a String
        String playersString = userInput.nextLine();

        //TODO
        // Split the String into qn array of Strings
        String [] players = playersString.split(" ");

        //TODO
        // get a value to guess for each player (the param is the number of players)
        int [] gameValues = getGameValues(players.length);

        //TODO
        // Iterate through the players
        for (int i = 0; i < players.length; i++) {

            System.out.println();

            System.out.println(players[i] + "'s Turn: ");

            // call the play method for this player
            //
            //TODO
            // pass the value that player will try to guess and the Scanner, returns the number of attempts
            int attempts = play(gameValues[i], userInput);


            //TODO
            // Print number of tries the player took
//             System.out.println(players[i]);
            System.out.println("" + players[i] + " took " + attempts + " guesses.");
        }
    }

    public int play(int value, Scanner userInput) {

        // variable to indicate if the round has been won yet
        boolean isRoundWon = false;

        int tries = 1;

        // loop as long as the round hasn't been won
        while (!isRoundWon) {

            // get a guess from the user
            int guess = getGuess(userInput);

            // check if the guess is correct and get message to print
            String resultMsg = checkGuess(value, guess);

            // print the message
            System.out.println(resultMsg);

            // if the message is the winning message, end the round
            if (resultMsg.equals("You got it!!!")) {
                //TODO
                // update isRoundWon so the round stops
                isRoundWon = true;
            } else {
                //TODO
                // increment the number of tries
                tries += 1;
            }
        }
        return tries;
    }

    public String checkGuess(int value, int guess) {

        //TODO
        // if the guess matches the value to guess return "You got it!!!"
        //
        //TODO
        // if the guess is lower than the value, return "Guess higher..."
        //
        //TODO
        // if the guess is higher than the value, return "Guess lower..."

        if (value == guess) {
            return  "You got it!!!";
        } else if (guess < value) {
            return "Guess higher...";
        } else {
            return "Guess lower...";
        }

    }

    public int getGuess(Scanner userInput) {
        // prompt for a message
        System.out.print("Enter guess: ");

        //TODO
        // read the input
        String guessString = userInput.nextLine();

        // return the number value of it
        return Integer.parseInt(guessString);
    }

    public int[] getGameValues(int players) {

        // constant to indicate highest number
        final int MAX_NUMBER = 100;

        //TODO
        // each player will play a round
        // create an array with a slot for each player - the slot will hold the number
        // each player will be trying to guess in their round
        int [] gameValues = new int[players];


        // this gets a random number generator
        Random random = getRandom();

        // Loop for each round, call the method to get a random number
        // for each round and store it in the values array for that round
        for (int i = 0; i < players; i++) {
            int value = getRandomNumber(random, MAX_NUMBER);

            //TODO
            // store the value in the array of values tp guess for each player's round
            gameValues[i] = value;

        }

        //TODO
        // return the array
        return gameValues;
    }


    /*
        These methods are used to generate a random number.  You are not
        expected to understand how these work right now.
     */


    public Random getRandom() {
        Random random = new Random(getSeed());
        return random;
    }

    public int getRandomNumber(Random random, int max) {
        return random.nextInt(max) + 1;
    }

    public long getSeed() {
        Date now = new Date();
        return now.getTime();
    }


}
