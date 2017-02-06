package com.antviktorov.islands;

/**
 * Island creator and finder.
 * @author antonviktorov
 * @since 1.0
 */
public class FindIsland {
    /**
     * Provided map.
     */
    int[][] map;
    /**
     * Generated islands.
     */
    Island[] islands = new Island[10];
    /**
     * Current island position.
     */
    int position = 0;
    /**
     * Constructor.
     * @param map - provided map.
     */
    public FindIsland(int[][] map) {
        this.map = map;
    }

    /**
     * Adding cell to island.
     * @param cell -  provided cell
     * @return if added then true
     */
    private Boolean addToIland(Cell cell) {
        if (position == 0) {
            this.islands[position++] = new Island();
        }

        Boolean result = false;

        for (Island island : this.islands) {
            if (island == null) {
                break;
            }
            if (island.add(cell)) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * Generate islands.
     */
    public void generateIslands() {
        Cell cell;
        for (int y = 0; y < this.map.length; y++) {
            for (int x = 0; x < this.map[y].length; x++) {
                if (this.map[y][x] == 1) {
                    cell = new Cell(x, y);
                    if (!addToIland(cell)) {
                        Island island = new Island();
                        island.add(cell);
                        this.islands[position++] = island;
                    }
                }
            }
        }
    }

    /**
     * Look for biggest island.
     * @return Islands entity
     */
    public Island findBiggestOne() {
        this.generateIslands();

        Island biggest = null;

        for (Island island : this.islands) {
            if (island == null) {
                break;
            }

            if (biggest == null) {
                biggest = island;
                continue;
            }

            if (island.getSize() > biggest.getSize()) {
                biggest = island;
            }
        }

        return biggest;
    }
}
