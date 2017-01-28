package com.antviktorov.chess.figures;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;
import com.antviktorov.chess.figures.moves.Diagonal;

/**
 * Bishop figure class move.
 * @author antonviktorov
 * @since 1.0
 */
public class Bishop extends Figure {
    /**
     * Bishop move.
     */
    private Diagonal diagonal;
    /**
     * Bishop constructor.
     * @param position - current position
     */
    public Bishop(Cell position) {
        super(position);
        this.diagonal = new Diagonal(position);
    }

    /**
     * Generate move.
     * @param destination - new position
     * @return way
     * @throws ImpossibleMoveException
     */
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        return this.diagonal.move(destination);
    }

    /**
     * Create new figure with new position.
     * @param destination - new destination
     * @return Bishop instance
     */
    public Figure clone(Cell destination) {
        return new Bishop(destination);
    }
}
