package com.antviktorov.start;

import com.antviktorov.models.*;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tracker test class.
 *
 * @author antonviktorov
 * @since 1.0
 */
public class TrackerTest {

    /**
     * Test adding items to tracker.
     */
    @Test
    public void addItemsToTracker() {

        Tracker tracker = new Tracker();
        tracker.add(new Task("First Task", "Cool first task, hello World!"));
        tracker.add(new Task("Second Task", "I am cool man, keep adding tasks"));
        tracker.add(new Task("Third Task", "Hey, please add this to the footer"));

        Item[] items = tracker.getItems();

        assertThat(items.length, is(3));
    }
}
