package com.antviktorov.chess.figures;

import com.antviktorov.chess.Cell;
import com.antviktorov.chess.exceptions.ImpossibleMoveException;

/**
 * Knight class.
 * @author antonviktorov
 * @since 1.0
 */
public class Knight extends Figure  {
    /**
     * Available Knight move combinations.
     */
    public final Cell[][] combinations = new Cell[][] {
            /**
             * Combination 1
             * - + - + -
             * * + - + *
             * - + * + -
             * * + - + *
             * - + - + -
             */
            {new Cell(-1, 0), new Cell(-1, 1), new Cell(-1, 2)},
            {new Cell(-1, 0), new Cell(-1, -1), new Cell(-1, -2)},
            {new Cell(1, 0), new Cell(1, 1), new Cell(1, 2)},
            {new Cell(1, 0), new Cell(1, -1), new Cell(1, -2)},
            /**
             * Combination 2
             * - * - * -
             * + + + + +
             * - - * - -
             * + + + + +
             * - * - * -
             */
            {new Cell(0, -1), new Cell(-1, -1), new Cell(-2, -1)},
            {new Cell(0, -1), new Cell(1, -1), new Cell(2, -1)},
            {new Cell(0, 1), new Cell(-1, 1), new Cell(-2, 1)},
            {new Cell(0, 1), new Cell(1, 1), new Cell(2, 1)},
            /**
             * Combination 3
             * - * - * -
             * + - - - +
             * + + * + +
             * + - - - +
             * - * - * -
             */
            {new Cell(-1, 0), new Cell(-2, 0), new Cell(-2, -1)},
            {new Cell(-1, 0), new Cell(-2, 0), new Cell(-2, 1)},
            {new Cell(1, 0), new Cell(2, 0), new Cell(2, -1)},
            {new Cell(1, 0), new Cell(2, 0), new Cell(2, 1)},
            /**
             * Combination 4
             * - + + + -
             * * - + - *
             * - - * - -
             * * - + - *
             * - + + + -
             */
            {new Cell(0, -1), new Cell(0, -2), new Cell(-1, -2)},
            {new Cell(0, -1), new Cell(0, -2), new Cell(1, -2)},
            {new Cell(0, 1), new Cell(0, 2), new Cell(-1, 2)},
            {new Cell(0, 1), new Cell(0, 2), new Cell(1, 2)},
    };

    /**
     * Constructor.
     * @param position - current position
     */
    public Knight(Cell position) {
        super(position);
    }

    /**
     * Add current position to way cells.
     * @param way - way of Cells
     * @return cells array
     */
    private Cell[] convertCombinationToWay(Cell[] way) {
        Cell[] converted = new Cell[3];
        int i = 0;
        for (Cell cell : way) {
            converted[i++] = this.position.add(cell);
        }
        return converted;
    }

    /**
     * Generate Knight way.
     * @param destination - new destination.
     * @return cells array
     * @throws ImpossibleMoveException
     */
    public Cell[] way(Cell destination) throws ImpossibleMoveException {
        Cell cell;
        for (Cell[] combination : this.combinations) {
            cell = combination[2];
            if (this.position.add(cell).equals(destination)) {
                return convertCombinationToWay(combination);
            }
        }

        throw new ImpossibleMoveException("Can't move to this destination");
    }

    /**
     * Clone Knight.
     * @param destination - new position
     * @return Knight instance
     */
    public Figure clone(Cell destination) {
        return new Knight(destination);
    }
}
