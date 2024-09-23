package com.example.BODEGASTCCAPI.helpers.messages;

public enum Message {

    NEGATIVE_WEIGHT("Weight cannot be negative"),
    NEGATIVE_VOLUME("Volume cannot be negative"),
    INVALID_DATE("Check the entered date");

    private String message;

    Message() {
    }

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
