package com.tlx.portal.shared;

import org.springframework.http.HttpStatus;

public enum ExceptionCodes {
    NOT_FOUND(404, HttpStatus.NOT_FOUND),
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST),

    INTERNAL_SERVER_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final HttpStatus status;

    ExceptionCodes(int code, HttpStatus status) {
        this.code = code;
        this.status = status;
    }



    public static HttpStatus getStatus(int code) {
        for (ExceptionCodes errorCode : ExceptionCodes.values()) {
            if (errorCode.code == code) {
                return errorCode.status;
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR; // Default status
    }

    public HttpStatus getStatus() {
        return status;
    }
}
