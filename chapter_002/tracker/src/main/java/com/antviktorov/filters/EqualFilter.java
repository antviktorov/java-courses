package com.antviktorov.filters;

/**
 * Numeric equal filter.
 */
public class EqualFilter {
    /**
     * Value.
     */
    protected long value;

    /**
     * Default constructor.
     */
    public EqualFilter() {
    }

    /**
     * Numeric equal filter constructor.
     * @param value - current value
     */
    public EqualFilter(long value) {
        this.value = value;
    }

    /**
     * Validate numeric value.
     * @param value - provided value
     * @return Valid or not
     */
    public Boolean valid(long value) {
        return this.value == value;
    }
}
