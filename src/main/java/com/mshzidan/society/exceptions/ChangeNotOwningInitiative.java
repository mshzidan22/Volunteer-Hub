package com.mshzidan.society.exceptions;

public class ChangeNotOwningInitiative extends RuntimeException {
    public ChangeNotOwningInitiative(String message) {
        super(message);
    }

    public ChangeNotOwningInitiative(String message, Throwable cause) {
        super(message, cause);
    }
}
