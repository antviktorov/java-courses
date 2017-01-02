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
     * Creates Tracker class instance with some items on board.
     * @return Tracker
     */
    private Tracker createTrackerWithItems() {
        Tracker tracker = new Tracker();
        tracker.add(new Task("First Task", "Cool first task, hello World!"));
        tracker.add(new Task("Second Task", "I am cool man, keep adding tasks"));
        tracker.add(new Task("Third Task", "Hey, please add this to the footer"));

        return tracker;
    }

    /**
     * Test adding items to tracker.
     */
    @Test
    public void addItemsToTracker() {
        Tracker tracker = this.createTrackerWithItems();
        Item[] items = tracker.getItems();

        assertThat(items.length, is(3));
    }

    /**
     * Update item in tracker.
     */
    @Test
    public void updateItemInTracker() {
        Tracker tracker = this.createTrackerWithItems();
        Item[] items = tracker.getItems();

        Item newItem = new Task("First Task has been updated", "New description");
        newItem.setId(items[0].getId());
        tracker.update(newItem);

        items = tracker.getItems();

        assertThat(items[0].getName(), is(newItem.getName()));
    }

    /**
     * Test deletion item from tracker.
     */
    @Test
    public void deleteItemFromTracker() {
        Tracker tracker = this.createTrackerWithItems();
        Item[] items = tracker.getItems();

        tracker.delete(items[0]);

        items = tracker.getItems();

        assertThat(items.length, is(2));
    }

    /**
     * Test findByName method in tracker.
     */
    @Test
    public void findByNameInTracker() {
        Tracker tracker = this.createTrackerWithItems();
        Item[] fond = tracker.findByName("Task");

        assertThat(fond.length, is(3));
    }

    /**
     * Test findById method in tracker.
     */
    @Test
    public void findByIdInTracker() {
        Tracker tracker = this.createTrackerWithItems();
        Item[] items = tracker.getItems();
        Item fond = tracker.findById(items[2].getId());

        assertThat(fond.getId(), is(items[2].getId()));
    }
}
