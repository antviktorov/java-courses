package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Triangle Test class.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class TriangleTest {

    /**
     * Area should be 4.5
     */
    @Test
    public void whenProvidedPointsThenArea() {
        Triangle triangle = new Triangle(new Point(1,1), new Point(2.5, 4), new Point(4,1));
        assertThat(triangle.area(), closeTo(4.0, 0.5));
    }
}