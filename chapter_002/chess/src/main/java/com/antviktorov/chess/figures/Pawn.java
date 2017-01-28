package com.antviktorov.chess.figures;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;
import com.antviktorov.chess.figures.moves.Straight;

/**
 * Pawn class.
 * @author antonviktorov
 * @since 1.0
 */
public class Pawn extends Figure {
    /**
     * Move.
     */
    private Straight straight;
    /**
     * First move state.
     */
    private Boolean firstMove = false;

    /**
     * Constructor.
     * @param position - current position
     */
    public Pawn(Cell position) {
        super(position);
        this.straight = new Straight(position);
    }

    /**
     * Construcotr.
     * @param position - current position
     * @param firstMove - pawn first move state
     */
    public Pawn(Cell position, Boolean firstMove) {
        super(position);
        this.straight = new Straight(position);
        this.firstMove = firstMove;
    }

    /**
     * Generate Pawn way.
     * @param destination - new destination.
     * @return cells array
     * @throws ImpossibleMoveException
     */
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        Cell[] way = this.straight.move(destination);
        int max = 1;
        if (firstMove) {
            max = 2;
        }
        if (way.length > max) {
            throw new ImpossibleMoveException(String.format("Pawn can't move more than %s cell", max));
        }
        Cell first = way[0];
        if (first.getX() != destination.getX()) {
            throw new ImpossibleMoveException("Pawn can move only forward");
        }
        return way;
    }

    /**
     * Clone Pawn instance.
     * @param destination - new position
     * @return Pawn instance
     */
    public Figure clone(Cell destination) {
        return new Pawn(destination);
    }
}
