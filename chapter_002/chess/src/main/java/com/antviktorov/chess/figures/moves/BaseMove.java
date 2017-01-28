package com.antviktorov.chess.figures.moves;

import com.antviktorov.chess.Cell;

import java.util.Arrays;

/**
 * Base move class for figures.
 * @author antonviktorov
 * @since 1.0
 */
abstract class BaseMove {
    /**
     * Current position.
     */
    protected Cell position;

    /**
     * Base constructor.
     */
    BaseMove() {
    }

    /**
     * Position constructor.
     * @param position - current position
     */
    BaseMove(Cell position) {
        this.position = position;
    }

    /**
     * Generate move vector according to destination.
     * @param destination - new destination
     * @return vector
     */
    protected Cell getMoveVector(Cell destination) {
        Cell cell = new Cell();

        if (destination.getX() > this.position.getX()) {
            cell.x = 1;
        } else if (destination.getX() < this.position.getX()) {
            cell.x = -1;
        }

        if (destination.getY() > this.position.getY()) {
            cell.y = 1;
        } else if (destination.getY() < this.position.getY()) {
            cell.y = -1;
        }
        return cell;
    }

    /**
     * Build way according vector.
     * @param destination - new position.
     * @param vector - new position vector.
     * @return way of cells
     */
    protected Cell[] buildWay(Cell destination, Cell vector) {
        int x = (int) this.position.getX();
        int y = (int) this.position.getY();

        Cell[] way = new Cell[8];
        int i = 0;

        while ((x != (int) destination.getX()) || (y != (int) destination.getY())) {
            x += vector.getX();
            y += vector.getY();
            way[i++] = new Cell(x, y);
        }

        return Arrays.copyOfRange(way, 0, i);
    }
}
