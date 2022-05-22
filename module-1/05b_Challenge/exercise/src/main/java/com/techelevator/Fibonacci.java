package com.techelevator;
import java.util.Scanner;
public class Fibonacci {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		//System.out.print("Please enter a number:");


		int[] fibArray = new int[20];
		fibArray[0] = 0;
		fibArray[1] = 1;
		for (int i = 2; i < fibArray.length; i++) {
			fibArray[i] = fibArray[i - 1] + fibArray[i - 2];

			System.out.println(fibArray);
		}

	}
}
