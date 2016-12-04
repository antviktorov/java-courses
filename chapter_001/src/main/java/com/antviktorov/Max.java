package com.antviktorov;

/**
 * Class Max.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Max {
    /**
     * Get max from two.
     * @param first
     * @param second
     * @return
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Get max from three.
     * @param first
     * @param second
     * @param third
     * @return
     */
    public int max(int first, int second, int third) {
        return  max(max(first, second), third);
    }
}