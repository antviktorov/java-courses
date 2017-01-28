package com.antviktorov.chess.figures.moves;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;

/**
 * Diagonal move.
 * @author antonviktorov
 * @since 1.0
 */
public class Diagonal extends BaseMove implements Move {
    /**
     * Position constructor.
     * @param position - current position
     */
    public Diagonal(Cell position) {
        super(position);
    }

    /**
     * Move figure to destination.
     * @param destination - new destination
     * @return way
     * @throws ImpossibleMoveException
     */
    public Cell[] move(Cell destination) throws ImpossibleMoveException {
        Cell vector = getMoveVector(destination);
        if (Math.abs(vector.x) != Math.abs(vector.y)) {
            throw new ImpossibleMoveException("Can't move straightly.");
        }
        return buildWay(destination, vector);
    }
}
