package com.techelevator;

public class Lecture {



    public void examples() {
        // for loop [3 iterations]
        //forLoopExample(3);

        // while loop [5 iterations]
//        whileLoopExample(5);

        // while loop -> what happens if we pass 0?
//        whileLoopExample(0);

        // do loop
//        doWhileLoopExample(0);

//        scopeExample();

//        int returnedVariable = returnVariableFromBlock(4);
//        System.out.println("returnedVariable: " + returnedVariable);
//        System.out.println();

//        int[] array1 = returnArray();
//        System.out.println("array1:");
//        printInts(array1);
//        System.out.printf("");

//        int firstElement = returnFirstElement();
//        System.out.println("firstElement: " + firstElement);

//        int lastElement = returnLastElement();
//        System.out.println("lastElement: " + lastElement);

//        int [] nums = { 10, 20, 30, 40, 50 };
//
//        int firstNumElement = returnFirstElementOfParam(nums);
//        System.out.println("firstNumElement: " + firstNumElement);

//        int lastNumElement = returnLastElementOfParam(nums);
//        System.out.println("lastNumElement: " + lastNumElement);

//        System.out.println();
//
//        String[] names = { "Yoav", "Tom", "Caitie", "Amber"};
//
//        printStrings(names);


    }

    public void forLoopExample(int max) {
        System.out.println("running forLoopExample (max=" + max + "): ");
        for (int i = 1; i <= max; i++) {
            System.out.println("Iteration " + i);
        }

        System.out.println();
    }

    public void whileLoopExample(int max) {

        System.out.println("running while loop (max=" + max + ") ...");
        int i = 1;

        // will run as long as condition evaluates to true
        while (i <= max) {
            System.out.println("Iteration " + i);
            i++;
        }
        System.out.println();
    }

    public void doWhileLoopExample(int max) {
        System.out.println("running while loop (max=" + max + ") ...");
        int i = 1;

        // do is guaranteed to run at least once even if while evaluates to false
        do {
            System.out.println("Iteration " + i);
            i++;
        } while (i <= max);
    }

    public void scopeExample() {

        boolean done = false;

        for (int i = 1; i <= 3; i++) {
            String status = "running";
            if (i == 3) {
                status = "done";
            }
            System.out.println(status);
        }

//        System.out.println("status: " + status);
        System.out.println();
    }

    public int returnVariableFromBlock(int number) {

        // A new block with scoped variables
        for (int i = 0; i < number; i++){

            int result = number * 5;

        } // the result variable disappears here

        return number; // We want to return result here. How?
    }

    /*
        Array Examples...
    */

    /*
    1. Return the created array
    */
    public int[] returnArray() {
        int[] array = { 80, 8080, 443 };
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return 1;
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return 1;
    }

    /*
    4. Return the first element of the array from the parameters
    */
    public int returnFirstElementOfParam(int[] passedInArray) {
        return 1;
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
        return 1;
    }

    public void printStrings(String[] strings) {

        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }

        System.out.println();
    }

    public void printInts(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        System.out.println();
    }



    /* More Examples to Try */

    /*
        What will the variable result be at the end of the method? Change the number in the logic expression so that
        it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier;
        }

        return result == 1; // <-- Change the number to match result and make this be true
    }

    /*
        Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return 0;
    }

    /*
        How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;
        }

        return counter == 1; // What should the number be to return true?
    }

    /*
        This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = { 4, 23, 9 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 1; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
        This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i <= arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
        We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i = i + 1) {
            sum = sum + arrayToLoopThrough[i];
        }

        return sum == 12;
    }


    // don't worry about what this is doing yet

    public static void main(String[] args) {
        Lecture lecture = new Lecture();
        lecture.examples();
    }
}