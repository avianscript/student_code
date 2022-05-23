package com.techelevator;
import java.util.Scanner;
import java.util.Arrays;
public class Fibonacci {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		//System.out.print("Please enter a number:");


		int[] fibArrayOne = {0, 1};

		int[] fibArray = new int[18];
		fibArray[0] = 0;
		fibArray[1] = 1;
		for (int i = 2; i < fibArray.length; i++) {
			fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
		//	String[] stringArray = new String[] {string.split(fibArray)};
			System.out.println(Arrays.toString(fibArray));
	//	int[] newFib = {fibArray[0], fibArray[1], fibArray[i]};
	//	String fibString = (String)(newFib);

		}

	}
}
