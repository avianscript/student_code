package com.techelevator;
import java.util.Scanner;
public class LinearConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		String inputLength = userInput.nextLine();
		double inputLengthPrime = Double.parseDouble(inputLength);
		System.out.print("Is the measurement in (m)eters or (f)eet? ");
		String inputFormat = userInput.nextLine();
		double convertedLength;
		if (inputFormat.equals ("m")) {
			convertedLength = inputLengthPrime * 3.2808399;
		} else {
			convertedLength = inputLengthPrime * 0.3048;
		}
		int convertedLengthPrime = (int)convertedLength;
		String newFormat;
			if (inputFormat.equals ("m")) {
				newFormat = "f";
			} else {
				newFormat = "m";
			}

		System.out.println(inputLength + inputFormat + " is " + convertedLengthPrime + newFormat + ".");
	}


}
