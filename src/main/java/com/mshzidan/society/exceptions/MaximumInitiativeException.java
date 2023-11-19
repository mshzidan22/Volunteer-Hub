package com.mshzidan.society.exceptions;

public class MaximumInitiativeException extends RuntimeException{
    public MaximumInitiativeException(String message) {
        super(message);
    }

    public MaximumInitiativeException(String message, Throwable cause) {
        super(message, cause);
    }
}
