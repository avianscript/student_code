package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws FileNotFoundException {
Scanner userInput = new Scanner(System.in);

		System.out.println("Please input a destination file path: ");
		String destinationFile = userInput.nextLine();

		try (PrintWriter fizzBuzz = new PrintWriter(destinationFile)) {
			int i = 0;
			while (i < 300) {
				i++;
				if (i % 3 == 0 && i % 5 == 0) {
					fizzBuzz.println("FizzBuzz");
				} else if (i % 3 == 0) {
					fizzBuzz.println("Fizz");
				} else if (i % 5 == 0) {
					fizzBuzz.println("Buzz");
				} else {
					fizzBuzz.println(i);
				}
			}
		}
		catch (FileNotFoundException exception) {
			System.out.println("File does not exist");
		}

	}

}
