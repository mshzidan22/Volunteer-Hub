package com.mshzidan.society.exceptions;

public class InitiativeExpiredException extends RuntimeException{
    public InitiativeExpiredException(String message) {
        super(message);
    }

    public InitiativeExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}
