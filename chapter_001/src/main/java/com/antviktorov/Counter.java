package com.antviktorov;

/**
 * Counter class.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Counter {

    /**
     * Calculate even numbers.
     * @param start - from
     * @param finish - to
     * @return
     */
    public int add(int start, int finish) {
        int summ = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 != 0) {
                continue;
            }
            summ += i;
        }

        return  summ;
    }
}