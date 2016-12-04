package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Max test class.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class MaxTest {

    /**
     * Max in two
     */
    @Test
    public void whenSevenSixThenMaxSeven() {
        Max max = new Max();
        assertThat(max.max(7, 6), is(7));
    }

    /**
     * Max in three.
     */
    @Test
    public void whenFiveTwoTenThenMaxTen() {
        Max max = new Max();
        assertThat(max.max(5, 2, 10), is(10));
    }
}
