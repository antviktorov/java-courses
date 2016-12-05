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
public class FactorialTest {

    /**
     * Calculate factorial of 4
     */
    @Test
    public void whenFactorialIsFourThenTwentyFour() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calculate(4), is(24));
    }

    /**
     * Calculate factorial of 5
     */
    @Test
    public void whenFactorialIsFiveThenOneHundredAndTwenty() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calculate(5), is(120));
    }
}