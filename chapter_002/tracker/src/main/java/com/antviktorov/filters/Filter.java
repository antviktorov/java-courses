package com.antviktorov.filters;

import com.antviktorov.models.Item;

/**
 * Filter interface.
 */
public interface Filter {
    /**
     * Validate filter.
     * @param item - item model entity
     * @return is valid or not
     */
    Boolean valid(Item item);
}
