package com.antviktorov.chess.exceptions;

/**
 * Impossible move exception.
 * @author antonviktorov
 * @since 1.0
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
     * Contsructor.
     * @param message - provided message
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
