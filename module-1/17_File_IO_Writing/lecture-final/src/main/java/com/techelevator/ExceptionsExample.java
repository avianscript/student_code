package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionsExample {

    public static void main(String[] args)  {

        Scanner keyboard = new Scanner(System.in);

//        try {
//            creatingAFile(keyboard);
//        } catch (IOException ex) {
//            System.out.println("I/O Exception: " + ex.getMessage());
//        }
//

        try {
            demoExceptionPolymorphism(keyboard);
            System.out.println("All done");
        } catch (FileNotFoundException ex) {
            System.out.printf(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Ooops... something went wrong: " + ex.getMessage());
        } finally {
            System.out.println("Finally!");
        }


    }

    public static void demoExceptionPolymorphism(Scanner userInput) throws IOException {

        System.out.print("Type something: ");
        String input = userInput.nextLine();

        if (input.equals("I/O")) {

            // this will simulate an IOException happening.
            // (you can always throw exceptions available in Java yourself)

            throw new IOException("Demo threw I/O Exception");
        } else if (input.equals("file")) {

             throw new FileNotFoundException("Demo threw FileNotFoundException");
        } else if (input.equals("null")) {
            String dummy = null;

            // this will cause a NullPointerException
            if (dummy.equals(input)) {
                System.out.println("dummy is equal to input");
            }
        } else {
            System.out.println("You typed: " + input);
        }

    }



    public static String creatingAFile(Scanner userInput)  throws IOException  {
        System.out.println();
        System.out.println("Now let's put a file in the directory.");
        System.out.print("Enter a name for the new file >>> ");
        String fileName = userInput.nextLine();

        File newFile = new File(fileName);

//        try {
        newFile.createNewFile();
        System.out.println();
        System.out.println("name: " + newFile.getName());
        System.out.println("absolutePath: " + newFile.getAbsolutePath());
        System.out.println("size : " + newFile.length());
//        } catch (IOException ex) {
//            System.out.println("Error creating " + newFile.getAbsolutePath() + ": " + ex.getMessage());
//        }

        return fileName;
    }
}
