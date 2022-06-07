package com.techelevator.exceptions;

public class LectureHelper {

    // Version 1

//    public String count(int start, int end) {
//        String result = "";
//        for (int num = start; num <= end; num++) {
//            result += num;
//            if (num < end) {
//                result += ", ";
//            }
//        }
//        return result;
//    }


    //Version 2

    /* count - prints message when num is out of range */

//    public String count(int start, int end) {
//        String result = "";
//        if (end > start) {
//            for (int num = start; num <= end; num++) {
//                result += num;
//                if (num < end) {
//                    result += ", ";
//                }
//            }
//            return result;
//        } else {
//            return (MessageLibrary.getCountOutOfRangeMessage(start, end));
//        }
//    }

    // Version 3

    /* count - throws RangeException when num is out of range     */

    public String count(int start, int end) throws RangeException {
        String result = "";
        if (end < start) {
            throw new RangeException(start, end);

        }
        for (int num = start; num <= end; num++) {
            result += num;
            if (num < end) {
                result += ", ";
            }
        }
        return result;
    }



    // Version 4

    /* count - uses IllegalArgumentException instead of RangeException */

//    public String count(int start, int end)  {
//        String result = "";
//        if (end < start) {
//            throw new IllegalArgumentException(MessageLibrary.getCountOutOfRangeMessage(start, end));
//        }
//        for (int num = start; num <= end; num++) {
//            result += num;
//            if (num < end) {
//                result += ", ";
//            }
//        }
//        return result;
//    }
}
