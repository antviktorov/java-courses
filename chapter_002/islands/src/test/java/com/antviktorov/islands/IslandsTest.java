package com.antviktorov.islands;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IslandsTest {
    @Test
    public void whenTestBiggestIland() {
        int[][] map = new int[][] {
            {0,0,0,0,0,0,1,1},
            {0,0,1,1,0,0,0,1},
            {0,1,1,1,1,0,1,0},
            {0,0,1,1,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,1,0,0,0,1,1,0},
            {1,1,1,0,0,1,1,0},
            {0,1,0,0,0,0,0,0},
        };
        FindIsland finder = new FindIsland(map);
        Island biggest = finder.findBiggestOne();
        assertThat(biggest.getSize(), is(8));
    }
}
