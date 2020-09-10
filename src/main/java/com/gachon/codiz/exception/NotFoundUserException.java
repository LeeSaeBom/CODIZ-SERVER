package com.gachon.codiz.exception;

import org.springframework.http.HttpStatus;

public class NotFoundUserException extends ServiceException {

    public NotFoundUserException(String message) {
        super(message, HttpStatus.NOT_FOUND, new Exception(message));
    }
}
