package com.antviktorov.filters;

/**
 * Numeric filter.
 */
public class NumericFilter {
    /**
     * Max value.
     */
    protected long max;
    /**
     * Min value.
     */
    protected long min;

    /**
     * Default constructor.
     */
    public NumericFilter() {
    }

    /**
     * Numeric filter constructor.
     * @param min - min value
     * @param max - max value
     */
    public NumericFilter(long min, long max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Validate numeric value.
     * @param value - provided value
     * @return Valid or not
     */
    public Boolean valid(long value) {
        Boolean result = false;

        if (this.min > 0 && this.max > 0) {
            result = (value >= this.min && value <= this.max) ? true : false;
        } else if (this.min > 0) {
            result = (value >= this.min) ? true : false;
        } else if (this.max > 0) {
            result = (value <= this.max) ? true : false;
        }

        return  result;
    }
}
