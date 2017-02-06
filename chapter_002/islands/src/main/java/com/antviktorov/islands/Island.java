package com.antviktorov.islands;

/**
 * Island class.
 * @author antonviktorov
 * @since 1.0
 */
public class Island {
    /**
     * Island cells.
     */
    private Cell[] cells = new Cell[10];
    /**
     * Current cell position.
     */
    private int position = 0;

    /**
     * Island constructor.
     */
    public Island() {
    }

    /**
     * Adding cell to island.
     * @param cell - provided cell.
     * @return if added then return true
     */
    public Boolean add(Cell cell) {
        Boolean result = false;

        if (position == 0) {
            this.cells[position++] = cell;
            return true;
        }

        for (Cell current : this.cells) {
            if (current == null) {
                break;
            }

            if (current.isNear(cell)) {
                cells[position++] = cell;
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Get size of island.
     * @return amount of cells
     */
    public int getSize() {
        return position;
    }
}
