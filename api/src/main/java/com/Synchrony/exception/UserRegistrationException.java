package com.Synchrony.exception;

public class UserRegistrationException extends RuntimeException {
    public UserRegistrationException(String username_is_already_taken) {
    }
}
