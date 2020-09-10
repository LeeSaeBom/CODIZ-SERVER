package com.gachon.codiz.exception;

import org.springframework.http.HttpStatus;

public class InvalidProblemTypeException extends ServiceException {

    public InvalidProblemTypeException(String message) {
        super(message, HttpStatus.BAD_REQUEST, new Exception(message));
    }
}
