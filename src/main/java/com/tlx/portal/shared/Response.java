package com.tlx.portal.shared;

import java.time.LocalDateTime;

public class Response {
    private LocalDateTime timestamp;
    private String message;
    private int code;

    public Response() {
    }

    public Response(LocalDateTime timestamp, String message, int Code) {
        this.timestamp = timestamp;
        this.message = message;
        this.code = Code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
