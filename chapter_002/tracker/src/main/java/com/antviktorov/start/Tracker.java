package com.antviktorov.start;

import com.antviktorov.menu.exceptions.MaxTrackerItemsException;
import com.antviktorov.menu.exceptions.OutOfIdException;
import com.antviktorov.models.Item;
import com.antviktorov.filters.Filter;

import java.util.Random;
import java.util.Arrays;

/**
 * Tracker management class.
 * @author antonviktorov
 * @since 1.0
 */
public class Tracker {
    /**
     * Items array.
     */
    private Item[] items = new Item[10];
    /**
     * Current item pointer in array.
     */
    private int position = 0;
    /**
     * Random entity.
     */
    private static final Random RANDOM = new Random();

    /**
     * Add item.
     * @param item - new item to ad in tracker.
     * @return Item
     * @throws MaxTrackerItemsException
     */
    public Item add(Item item) throws MaxTrackerItemsException {
        if (this.position == items.length) {
            throw new MaxTrackerItemsException();
        }
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Update item in tracker.
     * @param needle - item to update
     * @throws OutOfIdException
     */
    public void update(Item needle) throws OutOfIdException {
        int position = 0;
        Boolean fond = false;
        for (Item item : items) {
            if (item == null) {
                break;
            }
            if (item.getId().equals(needle.getId())) {
                this.items[position] = needle;
                fond = true;
                break;
            }
        }

        if (!fond) {
            throw new OutOfIdException();
        }
    }

    /**
     * Remove item from tracker.
     * @param needle - item to remove
     */
    public void delete(Item needle) {
        Item[] newItems = new Item[this.items.length];

        int position = 0;
        for (Item item : this.items) {
            if (item == null) {
                break;
            }
            if (item.getId().equals(needle.getId())) {
                continue;
            }
            newItems[position++] = item;
        }
        this.items = newItems;
        this.position = position;
    }

    /**
     * Look for item in items by name.
     * @param key - item in array
     * @return Item[]
     */
    public Item[] findByName(String key) {
        Item[] foundItems = new Item[this.items.length];
        int position = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            }
            if (item.getName().contains(key)) {
                foundItems[position++] = item;
            }
        }
        return Arrays.copyOfRange(foundItems, 0, position);
    }

    /**
     * Look for item in items.
     * @param id - needle id
     * @return Item
     * @throws OutOfIdException
     */
    public Item findById(String id) throws OutOfIdException {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }

        if (result == null) {
            throw new OutOfIdException();
        }

        return result;
    }

    /**
     * Get all available items.
     * @return Item[]
     */
    public Item[] getItems() {
        Item[] result = new Item[this.position];
        result = Arrays.copyOfRange(this.items, 0, this.position);
        return result;
    }

    /**
     * Get filtered items.
     * @param filters - array of filters
     * @return filtered items
     */
    public Item[] getItems(Filter[] filters) {
        Item[] result = new Item[this.position];
        int filtered = 0;

        for (Item item : this.items) {
            if (item == null) {
                continue;
            }
            for (Filter filter : filters) {
                if (filter.valid(item)) {
                    result[filtered++] = item;
                    break;
                }
            }
        }
        return Arrays.copyOfRange(result, 0, filtered);
    }

    /**
     * Generate unique id.
     * @return int
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }
}
