package com.tlx.portal.shared;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<Response> handleWpsException(NotificationException ex) {
        HttpStatus status = ex.getHttpStatus();
        Response error = new Response(LocalDateTime.now(), ex.getMessage(), ex.getCode());
        return new ResponseEntity<>(error, status);
    }
}
