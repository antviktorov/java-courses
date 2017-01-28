package com.antviktorov.chess.figures.moves;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;

/**
 * All directions move.
 * @author antonviktorov
 * @since 1.0
 */
public class Multiway extends BaseMove implements Move {
    /**
     * Position constructor.
     * @param position - current position
     */
    public Multiway(Cell position) {
        super(position);
    }
    /**
     * Move figure to destination.
     * @param destination - new destination
     * @return way
     * @throws ImpossibleMoveException
     */
    public Cell[] move(Cell destination) throws ImpossibleMoveException {
        return buildWay(destination, getMoveVector(destination));
    }
}
