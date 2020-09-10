package com.gachon.codiz.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ServiceException {

    public UserNotFoundException(String message, Throwable e) {
        super(message, HttpStatus.NOT_FOUND, e);
    }
}
