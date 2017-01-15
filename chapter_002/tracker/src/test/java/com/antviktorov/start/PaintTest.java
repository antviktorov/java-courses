package com.antviktorov.start;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import com.antviktorov.strategy.*;

/**
 * Paint Test class.
 *
 * @author Anton Viktorov
 * @since 1.0
 */
public class PaintTest {

    /**
     * Drawing triangle.
     */
    @Test
    public void whenDrawThenTriangle() {
        Paint paint = new Paint();
        assertEquals(
                paint.draw(new Trianlge()),
                "  ^" + System.getProperty("line.separator") + " ^^" +
                        System.getProperty("line.separator") + "^^^" +
                        System.getProperty("line.separator")
        );
    }

    /**
     * Drawing square.
     */
    @Test
    public void whenDrawThenSquare() {
        Paint paint = new Paint();
        assertEquals(
                paint.draw(new Square()),
                "^^^^^" + System.getProperty("line.separator") +
                        "^^^^^" + System.getProperty("line.separator") +
                        "^^^^^" + System.getProperty("line.separator") +
                        "^^^^^" + System.getProperty("line.separator") +
                        "^^^^^" + System.getProperty("line.separator")
        );
    }
}
