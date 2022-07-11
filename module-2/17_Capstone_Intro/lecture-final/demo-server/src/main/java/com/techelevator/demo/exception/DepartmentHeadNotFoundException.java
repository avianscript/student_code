package com.techelevator.demo.exception;

public class DepartmentHeadNotFoundException extends Exception {

    public DepartmentHeadNotFoundException(String message) {
        super(message);
    }

    public DepartmentHeadNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
