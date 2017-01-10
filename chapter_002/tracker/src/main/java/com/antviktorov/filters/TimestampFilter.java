package com.antviktorov.filters;

import com.antviktorov.models.Item;

/**
 * Timestamp filter.
 */
public class TimestampFilter extends NumericFilter implements Filter {
    /**
     * TimestampFilter filter constructor.
     * @param min - min value
     * @param max - max value
     */
    public TimestampFilter(long min, long max) {
        super(min, max);
    }
    /**
     * Filter Item entity by created date.
     * @param item - item model entity
     * @return Valid or not
     */
    public Boolean valid(Item item) {
        return this.valid(Long.valueOf(item.getCreated()));
    }
}
