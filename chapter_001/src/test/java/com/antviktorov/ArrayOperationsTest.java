package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Array operations test class.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class ArrayOperationsTest {

    /**
     * Bubble sorting test.
     */
    @Test
    public void bubbleSortTest() {
        ArrayOperations operations = new ArrayOperations();
        assertThat(operations.bubble(new int[]{3, 6, 1, 9, 2, 4, 8, 5, 7}), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    /**
     * Turn array test.
     */
    @Test
    public void turnArrayTest() {
        ArrayOperations operations = new ArrayOperations();
        assertThat(
                operations.turnArray(
                    new int[][]{{1, 2, 3},{4, 5, 6},{7, 8, 9}}
                ),
                is(new int[][]{{7, 4, 1},{8, 5, 2},{9, 6, 3}})
        );
    }

    /**
     * Duplicates test.
     */
    @Test
    public void removeDuplicatesFromArrayTest() {
        ArrayOperations operations = new ArrayOperations();
        assertThat(
                operations.removeDuplicates(new String[]{"Привет","Привет","Мир","Мир"}),
                is(new String[]{"Привет","Мир"})
        );
    }

    /**
     * Duplicates test advanced.
     */
    @Test
    public void removeDuplicatesFromArrayAdvancedTest() {
        ArrayOperations operations = new ArrayOperations();
        assertThat(
                operations.removeDuplicates(
                        new String[]{"Java","JavaScript","Java","PHP","Java","JavaScript","Pascal","PHP"}
                ),
                is(new String[]{"Java", "JavaScript", "PHP", "Pascal"})
        );
    }
}
