package com.techelevator.file.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileExamples {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        File inputFile = getInputFileFromUser(input);

        readAndOutputFile(inputFile);



        // Read state code/names from file and return as Map
        //Map<String, String> states = getStateMap();

        // Run code to ask for state code and provide state name
        //decodeStateCodes(input, states);

    }

    private static File getInputFileFromUser(Scanner keyboard) {
        System.out.print("Please enter path to input file >>> ");
        String path = keyboard.nextLine();

        File inputFile = new File(path);
        if(inputFile.exists() == false) { // checks for the existence of a file
            System.out.println(path + " does not exist");
            System.exit(1); // Ends the program - avoid this... use normal Java flow!
        } else if(inputFile.isFile() == false) {
            System.out.println(path + " is not a file");
            System.exit(1); // Ends the program - avoid this... use normal Java flow!
        }
        return inputFile;
    }

    private static void readAndOutputFile(File inputFile) {
        // Create Scannner from File
        //
        // Loop and read and output each line in the file
    }

    private static Map<String, String> getStateMap() {
        Map<String, String> stateMap = new HashMap<>();

        // Create a File object for the states.tx file
        File states = new File("states.txt");

        //  Create a Scanner to read from the file
        //
        // then loop through file and:
        //
        // 1) Read line
        // 2) Split the line by comma [ file format is DE,Delaware ]
        // 3) Use the first element as the key and the second one as the value to add to the Map

        return stateMap;
    }

    private static void decodeStateCodes(Scanner keyboard, Map<String, String> stateMap) {
        boolean running = true;

        while (running) {
            System.out.print("Enter a state code or X to exit: ");
            String choice = keyboard.nextLine();
            if (!choice.equalsIgnoreCase("X")) {
                String stateName = stateMap.get(choice);
                System.out.println(stateName != null ? stateName : "Not found");
            } else {
                running = false;
            }
        }
    }


}
