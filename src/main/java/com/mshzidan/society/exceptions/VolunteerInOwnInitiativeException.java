package com.mshzidan.society.exceptions;

public class VolunteerInOwnInitiativeException extends RuntimeException {
    public VolunteerInOwnInitiativeException(String message) {
        super(message);
    }

    public VolunteerInOwnInitiativeException(String message, Throwable cause) {
        super(message, cause);
    }
}
