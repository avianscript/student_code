package com.techelevator;

import java.math.BigDecimal;

public class Lecture {

	public void run() {

//		demoStack();

//		demoPassByValue();

//		demoPassByReference();

		demoStrings();
	}

	public void demoStack() {
		int num = 7;
		num += 5;
		System.out.println(num);
	}

	public void demoPassByValue() {

		int myNum = 5;
		System.out.println("");
		System.out.println("******************* passByValue *******************");
		System.out.println("myNum before call to passByValue: " + myNum);
		passByValue(myNum);
		System.out.println("myNum after call to passByValue: " + myNum);

	}

	public void demoPassByReference() {

		System.out.println("");
		System.out.println("******************* passByReference *******************");
		int [] myNums = new int [] {1, 2, 3, 4};
		System.out.println("myNums[0] before call to passByReference: " + myNums[0]);
		passByReference(myNums);
		System.out.println("myNums[0] after call to passByReference: " + myNums[0]);
	}

	public void passByValue(int num) {
		System.out.println("***** IN passByValue *****");
		System.out.println("num: " + num);
		num = 6;
		System.out.println("updated num to: " + num);
		System.out.println("***** OUT passByValue *****");
	}

	public void passByReference(int [] nums) {
		System.out.println("***** IN passByReference *****");
		System.out.println("nums[0]: " + nums[0]);
		nums[0] = 6;
		System.out.println("updated nums[0] to: " + nums[0]);
		System.out.println("***** OUT passByReference *****");

	}

	public void demoStrings() {

		int [] array1 = new int[] {1, 2, 3, 4};
		int [] array2 = new int [] {5, 6};

		System.out.println("Array 1 length: " + array1.length);
		System.out.println("Array 2 length: " + array2.length);

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes).  This
		 * is not the case for most classes */

		/* create a new instance of String using a literal */

		String hello1 = "Hello 1";
		String hello2 = new String("Hello 2!!!");



		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS *******");
		System.out.println("******************************");
		System.out.println();


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		/* print out length of Hello1 & 2 */
		System.out.println(hello1);

		System.out.println("Length of hello1: " + hello1.length());

		System.out.println(hello2);

		System.out.println("Length of hello2: " + hello2.length());

		/* length returns value you can store in int */

		int hello1Length = hello1.length();

		System.out.println("hello1Length: " + hello1Length);

		/* charAt - PAY ATTENTION TO BOUNDS!!!*/

		System.out.println("charAt(6): " + hello1.charAt(6));

		char result = hello1.charAt(4);
		System.out.println(result);

//		System.out.println("charAt(7): " + hello1.charAt(7));

		/*  endsWith */
		boolean hello1EndsWithExclamtions = hello1.endsWith("!!");
		boolean hello2EndsWithExclamtions = hello2.endsWith("!!");

		System.out.println("hello1EndsWithExclamtions: " + hello1EndsWithExclamtions);
		System.out.println("hello2EndsWithExclamtions: " + hello2EndsWithExclamtions);


		/*  startsWith */

		boolean hello1StartsWithHe = hello1.startsWith("He");
		boolean hello2StartsWithHe = hello2.startsWith("He");

		System.out.println("hello1StartsWithHe: " + hello1StartsWithHe);
		System.out.println("hello2StartsWithHe: " + hello2StartsWithHe);


		/*  indexOf  */
		int indexOfLl = hello1.indexOf("ll");
		System.out.println("indexOfLl: " + indexOfLl);

		int indexOfQq = hello1.indexOf("Qq");
		System.out.println("indexOfQq: " + indexOfQq);

		/* indexOf vs. lastIndexOf */
		/* indexOf vs. lastIndexOf */
		String helloFam = "Hello to my family!!!!";
		int lastIndex = helloFam.lastIndexOf("l");
		System.out.println(lastIndex);


		/*  toUpperCase and toLowerCase */

		System.out.println(hello1.toLowerCase());
		System.out.println(hello2.toUpperCase());


		/* trim */
		String trimExample = "  hello again!!! ";
		System.out.println("->>>>" + trimExample + "<<<<-");
		System.out.println("->>>>" + trimExample.trim() + "<<<<-");


		/* using substring */
		String subExample = "Oh my what a week!";
		System.out.println(subExample.substring(6, 10)); // what

		/* overloaded version of substring */
		String newString = subExample.substring(6);

		System.out.println(newString); // what a week!

		/* original String doesn't change when you use substring */
		System.out.println(subExample);

		/* store in new string if you want to save it */
		subExample = subExample.substring(0, 6);

		System.out.println(subExample);



		/* can reassign to same string to deal with immutability */


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();


		String equal1 = "equal";
		String equal2 = "equal";
		String ending = "ity";

		/* show strings not equals using == */

		if ((equal1 + ending) == (equal2 + ending)) {
			System.out.println("Strings equal");
		} else {
			System.out.println("Strings NOT equals");
		}

		if ((equal1 + ending).equals(equal2 + ending)) {
			System.out.println("Strings equal");
		} else {
			System.out.println("Strings NOT equals");
		}

		String sample1 = "SAMPLE";
		String sample2 = "Sample";

		System.out.println("Using equals: " + sample1.equals(sample2));
		System.out.println("Using equalsIgnoreCase: " + sample1.equalsIgnoreCase(sample2));



		System.out.println();
		System.out.println("*************************");
		System.out.println("****** BIG DECIMAL ******");
		System.out.println("*************************");
		System.out.println();

		double num = 66.6;
		System.out.println(num /100);

		BigDecimal bigDec1 = new BigDecimal("66.6");
		BigDecimal bigDec100 = BigDecimal.valueOf(100);

		System.out.println(bigDec1.add(bigDec100));

		System.out.println(bigDec1.divide(bigDec100));
//		System.out.println(bigDec1.divide(BigDecimal.ONE));

		System.out.println("compareTo: " + bigDec1.compareTo(bigDec100));

		if ( bigDec1.compareTo(bigDec100) > 0) {
			System.out.println("bigDec1 is bigger");
		} else if (bigDec1.compareTo(bigDec100) < 0) {
			System.out.println("bigDec1 is smaller");
		} else {
			System.out.println("they are equals");
		}

		/*

		Big Decimal is immutable

		bigDec1.add(bigDec100); will NOT update bigDec1

		must assign to new variable to retain result

		BigDecimal answer = bigDec1.add(bigDec100);

		can assign to self to replace reference to be the resulting BigDecmial object
		bigDec1 = bigDec1.add(bigDec100);

		 */

	}


	// don't worry about what this doing yet


	public static void main(String[] args) {

		Lecture lecture = new Lecture();
		lecture.run();

	}
}
