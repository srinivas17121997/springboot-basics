package com.pracitce.basics.demo.DTO;

import java.time.LocalDateTime;

public class ErrorResponses {
    String message;
    LocalDateTime time;
    int statusCode;


    public ErrorResponses(String message, LocalDateTime time, int statusCode) {
        this.message = message;
        this.time = time;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
