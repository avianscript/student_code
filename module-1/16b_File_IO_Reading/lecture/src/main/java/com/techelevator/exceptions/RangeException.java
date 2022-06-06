package com.techelevator.exceptions;

public class RangeException extends Exception {

    private static final String COUNT_OUT_OF_RANGE_MESSAGE =
            "end value (%d) cannot be smaller than start value (%d)";

    public RangeException(int start, int end) {
        super("end value (" + end + ") cannot be smaller than start value (" + start + ")");
    }
}

