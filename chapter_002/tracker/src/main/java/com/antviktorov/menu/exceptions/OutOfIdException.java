package com.antviktorov.menu.exceptions;

/**
 * ID doesn't exists exception.
 */
public class OutOfIdException extends RuntimeException {
    /**
     * Constructor with default parameter.
     */
    public OutOfIdException() {
        super("Provided ID doesn't exists");
    }
}
