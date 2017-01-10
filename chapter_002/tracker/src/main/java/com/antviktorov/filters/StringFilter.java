package com.antviktorov.filters;

/**
 * String filter.
 */
public class StringFilter {
    /**
     * Needle string.
     */
    protected String needle;
    /**
     * Default constructor.
     */
    public StringFilter() {
    }

    /**
     * Filter by string.
     * @param needle - provided string
     */
    public StringFilter(String needle) {
        this.needle = needle;
    }

    /**
     * Validate by string value.
     * @param value - provided string
     * @return Valid or not
     */
    public Boolean valid(String value) {
        return needle.contains(value);
    }
}
