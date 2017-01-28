package com.antviktorov.chess;

import java.awt.Point;

/**
 * Cell board class.
 * @author antonviktorov
 * @since 1.0
 */
public class Cell extends Point {
    /**
     * Default constructor.
     */
    public Cell() {
        super(0, 0);
    }

    /**
     * Constructor with provided start points.
     * @param x - current x
     * @param y - current y
     */
    public Cell(int x, int y) {
        super(x, y);
    }

    /**
     * Add cell to cell.
     * @param cell - Cell instance
     * @return new Cell
     */
    public Cell add(Cell cell) {
        return new Cell(this.x + cell.x, this.y + cell.y);
    }
}
