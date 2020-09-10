package com.gachon.codiz.exception;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends ServiceException {

    public InvalidPasswordException(String message) {
        super(message, HttpStatus.BAD_REQUEST, new Exception(message));
    }
}
