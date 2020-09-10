package com.gachon.codiz.exception;

import org.springframework.http.HttpStatus;

public abstract class ServiceException extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    public ServiceException(String message, HttpStatus httpStatus, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
