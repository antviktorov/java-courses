package com.antviktorov.chess.figures;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;
import com.antviktorov.chess.figures.moves.Straight;

/**
 * Rook class.
 * @author antonviktorov
 * @since 1.0
 */
public class Rook extends Figure {
    /**
     * Rook straight move.
     */
    private Straight straight;

    /**
     * Rook constructor.
     * @param position - current position.
     */
    public Rook(Cell position) {
        super(position);
        this.straight = new Straight(position);
    }

    /**
     * Generate way.
     * @param destination - new destination.
     * @return cells array
     * @throws ImpossibleMoveException
     */
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        return this.straight.move(destination);
    }

    /**
     * Clone Rook.
     * @param destination - new position
     * @return new Rook instance
     */
    public Figure clone(Cell destination) {
        return new Rook(destination);
    }
}
