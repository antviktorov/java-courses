package com.antviktorov.chess.exceptions;

/**
 * All figures set exception.
 * @author antonviktorov
 * @since 1.0
 */
public class AllFiguresAreSetException extends RuntimeException {
    /**
     * Constructor.
     * @param message - provided message
     */
    public AllFiguresAreSetException(String message) {
        super(message);
    }
}
