package com.fivepoints.spring.response;

public class MessageResponse {
    private String message;

    // Constructor

    public MessageResponse(String message) {
        this.message = message;
    }

    // Getters & Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
