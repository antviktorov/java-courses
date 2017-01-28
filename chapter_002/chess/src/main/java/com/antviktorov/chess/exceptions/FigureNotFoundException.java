package com.antviktorov.chess.exceptions;

/**
 * Exception when not possible to find figure on cell.
 * @author antonviktorov
 * @since 1.0
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * Constuctor.
     * @param message - provided message
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
