package com.antviktorov.filters;

import com.antviktorov.models.Item;

/**
 * Name filter.
 */
public class NameFilter extends StringFilter implements Filter {
    /**
     * Filter by name.
     * @param needle - provided string
     */
    public NameFilter(String needle) {
        super(needle);
    }
    /**
     * Filter Item entity by name.
     * @param item - item model entity
     * @return Valid or not
     */
    public Boolean valid(Item item) {
        return valid(item.getName());
    }
}
