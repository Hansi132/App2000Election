package com.app2000.electionbackend.exception;

public class UserNotFoundException extends RuntimeException{
    /**
     * @param message
     * @param cause
     */
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public UserNotFoundException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
