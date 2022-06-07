package com.techelevator;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inputArg = new Scanner(System.in);
		System.out.print("Please input a file path to import: ");
		String scanInput = inputArg.nextLine();
		System.out.println(scanInput);
		File inputFile = new File(scanInput);

		try (Scanner input = new Scanner(inputFile)) {
//					while (input.hasNextLine()) {
//						String lineFromFile = input.nextLine();
//						System.out.println(lineFromFile);
//					}
//
//				}
		} catch (FileNotFoundException exception) {
			System.out.println("File not found.");
		}

		System.out.print("Please input a word to search: ");
		String scanInput2 = inputArg.nextLine();
		System.out.println(scanInput2);
		System.out.print("Should the search be case-sensitive? (Y/N) ");
		String scanInput3 = inputArg.nextLine();

		if (scanInput3.equals("N")) {
			try (Scanner input = new Scanner(inputFile)) {
				int i = 0;
				while (input.hasNextLine()) {
					i++;
					String lineOfInput = input.nextLine();
					if (lineOfInput.toLowerCase().contains(scanInput2.toLowerCase())) {
						System.out.println(i + " " + lineOfInput);
					}
				}

			}

		} else {
			try (Scanner input = new Scanner(inputFile)) {
				int i = 0;
				while (input.hasNextLine()) {
					i++;
					String lineOfInput = input.nextLine();
					if (lineOfInput.contains(scanInput2)) {
						System.out.println(i + " " + lineOfInput);
					}
				}
			}
		}
	}
}