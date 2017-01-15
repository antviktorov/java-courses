package com.antviktorov.menu.exceptions;

/**
 * Menu out of action exception.
 */
public class MenuOutException extends RuntimeException {
    /**
     * Constructor with message parameter.
     * @param msg - provided message
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
