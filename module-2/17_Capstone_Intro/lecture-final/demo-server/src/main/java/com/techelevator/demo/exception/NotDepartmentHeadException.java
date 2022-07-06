package com.techelevator.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class NotDepartmentHeadException extends RuntimeException {

    public NotDepartmentHeadException(String message) {
        super(message);
    }


}
