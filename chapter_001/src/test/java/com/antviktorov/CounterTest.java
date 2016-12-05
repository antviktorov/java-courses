package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest class.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class CounterTest {

    /**
     * Summ of even numbers from 1 to 4
     */
    @Test
    public void whenEvenOneToFourThenSix() {
        Counter counter = new Counter();
        assertThat(counter.add(1,4), is(6));
    }

    /**
     * Summ of even numbers from 1 to 10
     */
    @Test
    public void whenEvenOneToTenThenThirty() {
        Counter counter = new Counter();
        assertThat(counter.add(1,10), is(30));
    }
}