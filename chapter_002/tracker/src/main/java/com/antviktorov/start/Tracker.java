package com.antviktorov.start;

import com.antviktorov.models.Item;

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
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Update item in tracker.
     * @param needle - item to update
     */
    public void update(Item needle) {
        int position = 0;
        for (Item item : items) {
            if (item.getId().equals(needle.getId())) {
                this.items[position] = needle;
                break;
            }
            position++;
        }
    }

    /**
     * Remove item from tracker.
     * @param needle - item to remove
     */
    public void delete(Item needle) {
        Item[] newItems = new Item[this.items.length];

        int position = 0;
        for (Item item : items) {
            if (item.getId().equals(needle.getId())) {
                continue;
            }
            newItems[position++] = item;
        }

        this.items = newItems;
        this.position = position;

        newItems = null;
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
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }

        return result;
    }

    /**
     * Get all available items.
     * @return Item[]
     */
    public Item[] getItems() {
        Item[] result = new Item[position];
        result = Arrays.copyOfRange(items, 0, position);
        return result;
    }

    /**
     * Generate unique id.
     * @return int
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }
}
