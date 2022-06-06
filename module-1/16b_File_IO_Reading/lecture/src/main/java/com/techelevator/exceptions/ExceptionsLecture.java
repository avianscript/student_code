package com.techelevator.exceptions;

public class ExceptionsLecture {

    private static LectureHelper helper = new LectureHelper();

    public static void main(String[] args) {
        // count from 1 to 10
        printCount(1, 20);

        // what happens if the end number is less than the start number?
        printCount(15, 5);
    }

    private static void printCount(int start, int end) {
        System.out.println();
        System.out.println("start: " + start + " / end: " + end);
        String countString = helper.count(start, end);
        System.out.println("CountString: " + countString);
    }
}
