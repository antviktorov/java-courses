package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Array reverse test class.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class ArrayOperationsTest {

    /**
     * Reverse array test.
     */
    @Test
    public void bubbleSortTest() {
        ArrayOperations operations = new ArrayOperations();
        assertThat(operations.bubble(new int[]{3, 6, 1, 9, 2, 4, 8, 5, 7}), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
