package com.antviktorov;

/**
 * Counter class.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Factorial {

    /**
     * Calculate factorial
     * @param n - factorial
     * @return
     */
    public int calculate(int n) {
        int factorial = 1;
        while (n > 0) {
            factorial *= n;
            n--;
        }
        return factorial;
    }
}