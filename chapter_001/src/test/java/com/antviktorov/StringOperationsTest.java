package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Final test.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class StringOperationsTest {

    /**
     * Check if origin string contains substring.
     */
    @Test
    public void whenStringContainsSubstring() {
        StringOperations operations = new StringOperations();
        assertThat(operations.contains("Anton Viktorov","Anton"), is(true));
    }

    /**
     * Check if origin string not contains substring.
     */
    @Test
    public void whenStringNotContainsSubstring() {
        StringOperations operations = new StringOperations();
        assertThat(operations.contains("Vasia Pupkin","Anton"), is(false));
    }
}
