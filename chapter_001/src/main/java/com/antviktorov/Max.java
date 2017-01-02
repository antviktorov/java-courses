package com.antviktorov;

/**
 * Class Max.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Max {
    /**
     * Get max from two.
     * @param first - first value
     * @param second - second value
     * @return max among
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Get max from three.
     * @param first - first value
     * @param second - second value
     * @param third - third value
     * @return max among
     */
    public int max(int first, int second, int third) {
        return  max(max(first, second), third);
    }
}