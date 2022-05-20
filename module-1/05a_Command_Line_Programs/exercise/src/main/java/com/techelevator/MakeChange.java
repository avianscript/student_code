package com.techelevator;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		System.out.println("Welcome to the Change-o-Matic!");
		System.out.print("Please enter the amount of the bill: ");
		String billTotal = userInput.nextLine();
		double bill = Double.parseDouble(billTotal);

		System.out.print("Please enter the amount tendered: ");
		String amountTendered = userInput.nextLine();
		double tendered = Double.parseDouble(amountTendered);

		System.out.println("The change required is " + (tendered - bill));
		System.out.println("Thank you for using the Change-o-Matic!");




	}

}
