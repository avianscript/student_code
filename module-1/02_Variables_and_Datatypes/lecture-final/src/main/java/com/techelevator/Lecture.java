package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

//		System.out.println("Hi!");


		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/

		int numberOfExercises = 26;

		System.out.println(numberOfExercises);

		numberOfExercises = 100;

		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;

		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/

		String name = "TechElevator";

		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/String myFavoriteLanguage = "Java";

		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;

		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Yoav";

		System.out.println(myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtonsOnMouse = 2;
		System.out.println(numberOfButtonsOnMouse);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double percentBatteryLeft = .90;
		System.out.println(percentBatteryLeft);


		// demo division vs modulo

		int value = 5 / 2;

		System.out.println("Value (division)=");
		System.out.println(value);

		int remainder = 5 % 2;
		System.out.println("Remainder=");
		System.out.println(remainder);

		int evenNumber = 4;
		int oddNumber = 9;

		System.out.println("evenNumber % 2");
		System.out.println(evenNumber % 2);

		System.out.println("oddNumber % 2");
		System.out.println(oddNumber % 2);


		// shortcut notation

		int myNumber = 5;

		System.out.println(myNumber);

//		myNumber = myNumber + 10;

		//shorthand

		myNumber += 10;

		System.out.println(myNumber);

		evenNumber %= 2;
//		evenNumber = evenNumber % 2;
		System.out.println(evenNumber);

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		int difference = 121 - 27;
		System.out.println(difference);

		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double additionValue = 12.3 + 32.1;
		System.out.println(additionValue);

		/*
		12. Create a String that holds your full name.
		*/
		String birthName = "Yoav Morahg";
		System.out.println(birthName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String helloName = "Hello, " + birthName;
		System.out.println(helloName);

		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		birthName = birthName + " Esquire";
		System.out.println(birthName);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		birthName += " Esquire";
		System.out.println(birthName);


		long bigNum = 15000;
		int smallNum = 5;

		// can't do this because result is promoted to a long
//		int result = bigNum + smallNum;
		long result = bigNum + smallNum;

		int wholeNum = 5;
		double decimalNum = .5;

		// can't do this because result is promoted to a double
//		int anotherResult = wholeNum + decimalNum;
		double anotherResult = wholeNum + decimalNum;

		// case double result as int
		int castResult = (int) (wholeNum + decimalNum);
		System.out.println(castResult);


		double tempInF = 98.6;

		System.out.println(5 / 9);

		// 5 /9 will yield 0 so result will be 0
//		double tempInC = (tempInF -32.0) * (5/9);
//		double tempInC = (tempInF -32.0) * (5.0/9);
		double tempInC = (tempInF -32.0) * ((double)5/9);

		// this will still yield wrong result because 5  / 9 is still 0 so casting
		// as doubel will make it 0.0
//		double tempInC = (tempInF -32.0) * (double)(5/9);
		System.out.println(tempInC);


		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String sawVariable = "Saw" + 2;
		System.out.println(sawVariable);

		System.out.println("5" + 6);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		sawVariable += 0;
		System.out.println(sawVariable);

		/*
		18. What is 4.4 divided by 2.2?
		*/
		System.out.println(4.4 / 2.2);

		/*
		19. What is 5.4 divided by 2?
		*/
		System.out.println(5.4  / 2);

		/*
		20. What is 5 divided by 2?
		*/
		System.out.println(5 / 2);

		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println(5.0 / 2);

		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println(66.6 / 100);

		/*
		23. If I divide 5 by 2, what's my remainder?
		*/

		System.out.println(5 % 2);
		/*
		24. What is 1,000,000,000 * 3?
		*/
		System.out.println(1000000000 * 3);

		int shortResult = 1000000000 * 3;
		System.out.println("Short result " + shortResult);

		long longResult = 1000000000L * 3;
		System.out.println("long result = " + longResult);


		/*
		25. Create a variable that holds a boolean called isDoneWithExercises and
		set it to false.
		*/
		boolean isDoneWithExercises = false;

		/*
		26. Now set isDoneWithExercise to true.
		*/
		isDoneWithExercises = true;
		
	}

}
