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
public class TurnTest {

    /**
     * Reverse array test.
     */
    @Test
    public void reverseArrayTest() {
        Turn turn = new Turn();
        assertThat(turn.back(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}), is(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
}
