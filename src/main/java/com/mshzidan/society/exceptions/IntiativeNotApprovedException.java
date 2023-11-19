package com.mshzidan.society.exceptions;

public class IntiativeNotApprovedException extends RuntimeException{
    public IntiativeNotApprovedException(String message) {
        super(message);
    }

    public IntiativeNotApprovedException(String message, Throwable cause) {
        super(message, cause);
    }
}
