package com.techelevator;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter the temperature: ");
		String inputTemp = userInput.nextLine();
		double inputTempPrime = Double.parseDouble(inputTemp);
		System.out.print("Is the temperature in (C)elcius or (F)arenheit? ");
		String inputFormat = userInput.nextLine();

		double convertedTemp;
			if (inputFormat.equals ("C")) {
				convertedTemp = inputTempPrime * 1.8 + 32;
			} else {
			convertedTemp = (inputTempPrime - 32) / 1.8;
			}
			char newFormat = 'A';
			if (inputFormat.equals ("C")) {
				newFormat = 'F';
			} else {
				newFormat = 'C';
			}


		System.out.println(inputTemp + inputFormat + " is " + convertedTemp + newFormat + ".");

	}

}
