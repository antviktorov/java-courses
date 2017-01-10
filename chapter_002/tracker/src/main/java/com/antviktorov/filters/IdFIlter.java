package com.antviktorov.filters;

import com.antviktorov.models.Item;

/**
 * Entity ID filter.
 */
public class IdFIlter extends EqualFilter implements Filter {
    /**
     * IdFIlter filter constructor.
     * @param value - current value
     */
    public IdFIlter(long value) {
        super(value);
    }
    /**
     * Filter Item entity by ID.
     * @param item - item model entity
     * @return Valid or not
     */
    public Boolean valid(Item item) {
        return this.valid(Long.valueOf(item.getId()));
    }
}
