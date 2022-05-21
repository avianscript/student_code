package com.techelevator;

/*
In case you've ever pondered how much you weigh on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

$ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth is 37 lbs. on Mars.
 235 lbs. on Earth is 88 lbs. on Mars.
 185 lbs. on Earth is 69 lbs. on Mars. 
 */
import java.util.Scanner;

public class MartianWeight {


	public static void main(String[] args) {

		Scanner earthlingWeight = new Scanner(System.in);

		System.out.println("I am a Martian!");

		System.out.println("Please input a list of earthling weights for me to convert into martian weight.");
		System.out.println("Separate each weight with a single space. ");
		String earthWeight = earthlingWeight.nextLine();

		String[] listOfWeights = earthWeight.split(" ");


		for (int i = 0; i < listOfWeights.length; i++) {
			int numWeights = Integer.parseInt(listOfWeights[i]);
			double convertedWeights = numWeights * 0.378;
			int intConvertedWeights = (int)convertedWeights;
			System.out.println(listOfWeights[i] + " lbs. on Earth is " + intConvertedWeights + " lbs. on Mars.");
		}
	}
}





