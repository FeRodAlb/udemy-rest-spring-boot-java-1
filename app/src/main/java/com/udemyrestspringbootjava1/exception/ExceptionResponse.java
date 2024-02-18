package com.udemyrestspringbootjava1.exception;

import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private HttpStatusCode statusCode;
    private LocalDateTime timestamp;
    private String message;

    public ExceptionResponse(HttpStatusCode statusCode, LocalDateTime timestamp, String message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
