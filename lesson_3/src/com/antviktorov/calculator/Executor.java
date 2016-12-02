package com.antviktorov.calculator;

/**
 *
 * @author antonviktorov
 * @since 29.11.16
 */
public class Executor {
    public static void main(String[] args) {
        final Calculator calculator = new Calculator();
        calculator.add(Double.valueOf(args[0]), Double.valueOf(args[1]));
    }
}