package com.antviktorov.chess.figures.moves;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;
/**
 * Straight move backward or forward.
 * @author antonviktorov
 * @since 1.0
 */

public class Straight extends BaseMove implements Move {
    /**
     * Position constructor.
     * @param position - current position
     */
    public Straight(Cell position) {
        super(position);
    }

    /**
     * Move straightly.
     * @param destination - new destination
     * @return way
     * @throws ImpossibleMoveException
     */
    public Cell[] move(Cell destination) throws ImpossibleMoveException {
        Cell vector = getMoveVector(destination);
        if (Math.abs(vector.x) == Math.abs(vector.y)) {
            throw new ImpossibleMoveException("Can't move in diagonally.");
        }
        return buildWay(destination, vector);
    }
}
