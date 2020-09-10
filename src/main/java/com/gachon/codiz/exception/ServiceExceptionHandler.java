package com.gachon.codiz.exception;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gachon.codiz.support.Jackson;

public class ServiceExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    public void handle(HttpServletRequest request, HttpServletResponse response, Throwable cause) {
        if (response.isCommitted()) {
            return;
        }

        ErrorMessage errorMessage = handle(request, cause);

        byte[] bytes = asBytes(request, cause, errorMessage);

        response.setContentLength(bytes.length);
        response.setStatus(errorMessage.getCode());

        try (OutputStream out = response.getOutputStream()) {
            out.write(bytes);
        } catch (IOException e) {
            logger.warn("Fail to write error message", e);
        }
    }

    public ErrorMessage handle(HttpServletRequest request, Throwable cause) {
        int httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String responseMessage = "서버에 오류가 발생하였습니다.";
        Object reason = null;

        if (cause instanceof ServiceException) {
            ServiceException se = (ServiceException) cause;
            httpStatusCode = se.getHttpStatus().value();
            reason = se.getMessage();
        }

        logger.info("error {}", cause);

        return new ErrorMessage(httpStatusCode, responseMessage, reason);
    }

    public ModelAndView handleToModelAndView(HttpServletRequest request, HttpServletResponse response, Throwable cause) {
        if (!response.isCommitted()) {
            handle(request, response, cause);
        }

        return new ModelAndView();
    }

    private byte[] asBytes(HttpServletRequest request, Throwable cause, ErrorMessage errorMessage) {
        return Jackson.writeValueAsString(errorMessage).getBytes();
    }

    public static class ErrorMessage {
        private final int code;
        private final String message;
        private final Object reason;

        @JsonCreator
        public ErrorMessage(@JsonProperty("code") int code, @JsonProperty("message") String message,
                            @JsonProperty("reason") Object reason) {
            this.code = code;
            this.message = message;
            this.reason = reason;
        }

        public static ErrorMessage of(int code, String message) {
            return new ErrorMessage(code, message, null);
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public Object getReason() {
            return reason;
        }

        @Override
        public String toString() {
            return "ErrorMessage{" +
                   "code=" + code +
                   ", message='" + message + '\'' +
                   ", reason=" + reason +
                   '}';
        }
    }
}
