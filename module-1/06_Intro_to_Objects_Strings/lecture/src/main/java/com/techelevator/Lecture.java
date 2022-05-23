package com.techelevator;

public class Lecture {

	public void run() {

//		demoPassByValue();

//		demoPassByReference();

//		demoStrings();
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

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes).  This
		 * is not the case for most classes */

		/* create a new instance of String using a literal */



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

		/* length returns value you can store in int */

		/* charAt - PAY ATTENTION TO BOUNDS!!!*/

		/*  endsWith */

		/*  startsWith */

		/*  indexOf  */

		/* indexOf vs. lastIndexOf */

		/*  toUpperCase and toLowerCase */

		/* trim */

		/* using substring */

		/* overloaded version of substring */

		/* original String doesn't change when you use substring */

		/* store in new string if you want to save it */

		/* can reassign to same string to deal with immutability */


		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();





		System.out.println();
		System.out.println("*************************");
		System.out.println("****** BID DECIMAL ******");
		System.out.println("*************************");
		System.out.println();

	}


	// don't worry about what this doing yet


	public static void main(String[] args) {

		Lecture lecture = new Lecture();
		lecture.run();

	}
}
