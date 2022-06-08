package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner scannerInput = new Scanner(System.in);


        System.out.print("Please input a word to search for: ");
        String inputSearchWord = scannerInput.nextLine();
        System.out.print("Please input a replacement word: ");
        String inputReplacementWord = scannerInput.nextLine();
        System.out.print("Please input a file path to import: ");
        String inputLocation = scannerInput.nextLine();
        System.out.print("Please input a destination file path: ");
        String inputDestination = scannerInput.nextLine();
        File inputFile = new File(inputLocation);
        try (
                Scanner dataInput = new Scanner(inputFile);
                PrintWriter dataOutput = new PrintWriter(inputDestination)
        ) {
            while (dataInput.hasNextLine()) {
                String lineOfInput = dataInput.nextLine();
//                System.out.println(lineOfInput);
                if (lineOfInput.contains(inputSearchWord)) {
                    dataOutput.println(lineOfInput.replace(inputSearchWord, inputReplacementWord));
                } else {
                    dataOutput.println(lineOfInput);
                }
            }
        }

         catch (FileNotFoundException exception) {
            System.err.println("Cannot open the file for writing.");
        }

    }
}


