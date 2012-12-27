package com.meritit.productmanagement.domain;

public class LoginException extends Exception {
    public LoginException(Exception cause, String message) {
        super(message, cause);
    }
}
