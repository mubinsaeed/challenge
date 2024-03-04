package com.tlx.portal.shared;

import org.springframework.http.HttpStatus;

public abstract class NotificationException extends RuntimeException {
private int code;
    private String message;

    public NotificationException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public HttpStatus getHttpStatus() {
        return ExceptionCodes.getStatus(code);
    }
}
