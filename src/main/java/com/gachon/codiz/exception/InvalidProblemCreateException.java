package com.gachon.codiz.exception;

import org.springframework.http.HttpStatus;

public class InvalidProblemCreateException extends ServiceException {

    public InvalidProblemCreateException(String message) {
        super(message, HttpStatus.BAD_REQUEST, new Exception(message));
    }
}
