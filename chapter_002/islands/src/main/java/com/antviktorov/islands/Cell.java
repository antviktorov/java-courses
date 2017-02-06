package com.antviktorov.islands;

import java.awt.Point;

/**
 * Island cell class.
 * @author antonviktorov
 * @since 1.0
 */
public class Cell extends Point {
    /**
     * Cell constructor.
     * @param x - provided x
     * @param y - provided y
     */
    public Cell(int x, int y) {
        super(x, y);
    }

    /**
     * If cell is neighbor.
     * @param cell - provided cell
     * @return true if neighbor
     */
    public Boolean isNear(Cell cell) {
        int distance = (int) distance(cell);
        return (distance == 1 ? true : false);
    }
}