package com.example.EE25FinalProjectEventAggregatorService.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
