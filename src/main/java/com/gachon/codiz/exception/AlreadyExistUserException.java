package com.gachon.codiz.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistUserException extends ServiceException {

    public AlreadyExistUserException(String message) {
        super(message, HttpStatus.CONFLICT, new Exception(message));
    }
}
