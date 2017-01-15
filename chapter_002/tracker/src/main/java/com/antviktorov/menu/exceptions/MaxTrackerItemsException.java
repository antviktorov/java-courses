package com.antviktorov.menu.exceptions;

/**
 * Max items in tracker exception.
 */
public class MaxTrackerItemsException extends RuntimeException {
    /**
     * Constructor with profiled message.
     */
    public MaxTrackerItemsException() {
        super("Can't add items in tracker, max. amount is exhausted");
    }
}