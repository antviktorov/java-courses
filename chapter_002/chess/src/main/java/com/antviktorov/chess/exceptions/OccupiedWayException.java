package com.antviktorov.chess.exceptions;

/**
 * The way is occupied.
 * @author antonviktorov
 * @since 1.0
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * Constuctor.
     * @param message - provided message
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}
