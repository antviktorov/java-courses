package com.antviktorov.chess.figures;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;

/**
 * Figure abstract class.
 * @author antonviktorov
 * @since 1.0
 */
public abstract class Figure {
    /**
     * Current figure position.
     */
    final Cell position;

    /**
     * Generate figure way.
     * @param destination - new destination.
     * @return way
     * @throws ImpossibleMoveException
     */
    public abstract Cell[] way(Cell destination) throws ImpossibleMoveException;

    /**
     * Clone figure abstarct method.
     * @param destination - new position
     * @return new figure instance
     */
    public abstract Figure clone(Cell destination);

    /**
     * Figure constructor.
     * @param position - current figure position.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Check if figure stand here or not.
     * @param destination - position to check
     * @return true/false
     */
    public Boolean isHere(Cell destination) {
        if (this.position.equals(destination)) {
            return  true;
        }
        return false;
    }
}
