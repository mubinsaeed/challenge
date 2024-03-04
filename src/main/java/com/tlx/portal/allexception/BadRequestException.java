package com.tlx.portal.allexception;

import com.tlx.portal.shared.NotificationException;
import org.springframework.http.HttpStatus;

public class BadRequestException extends NotificationException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST.value());
    }
}
