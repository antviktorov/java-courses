package com.antviktorov.chess.figures;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;
import com.antviktorov.chess.figures.moves.Multiway;
import com.antviktorov.chess.figures.moves.Move;

/**
 * Queen class.
 * @author antonviktorov
 * @since 1.0
 */
public class Queen extends Figure {
    /**
     * Multiway move.
     */
    private Move multiway;

    /**
     * Queen contrutor.
     * @param position - current position
     */
    public Queen(Cell position) {
        super(position);
        this.multiway = new Multiway(position);
    }

    /**
     * Generate way.
     * @param destination - new destination.
     * @return cells array
     * @throws ImpossibleMoveException
     */
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        return this.multiway.move(destination);
    }

    /**
     * Clone Queen instance.
     * @param destination - new position
     * @return new Queen instance
     */
    public Figure clone(Cell destination) {
        return new Queen(destination);
    }
}
