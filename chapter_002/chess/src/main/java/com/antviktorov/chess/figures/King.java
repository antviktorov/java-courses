package com.antviktorov.chess.figures;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;
import com.antviktorov.chess.figures.moves.Multiway;
import com.antviktorov.chess.figures.moves.Move;

/**
 * King figure class move.
 * @author antonviktorov
 * @since 1.0
 */
public class King extends Figure {
    /**
     * Multiway for bishop.
     */
    private Move multiway;

    /**
     * Current constructor.
     * @param position - new psotio
     */
    public King(Cell position) {
        super(position);
        this.multiway = new Multiway(position);
    }

    /**
     * Generate move.
     * @param destination - new position
     * @return way
     * @throws ImpossibleMoveException
     */
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        Cell[] way = this.multiway.move(destination);
        if (way.length > 1) {
            throw new ImpossibleMoveException("King can't move more than 1 cell");
        }
        return way;
    }

    /**
     * Clone King.
     * @param destination - new position
     * @return King instance
     */
    public Figure clone(Cell destination) {
        return new King(destination);
    }
}
