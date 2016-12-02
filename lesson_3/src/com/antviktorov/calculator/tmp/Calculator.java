package com.antviktorov.calculator;

/**
 * Implements base math operations
 * @author antonviktorov
 * @since 29.11.16
 */
public class Calculator {

    /**
     * Saved result
     */
    private double result;

    /**
     * Get result of operation(s)
     * @return Result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Addition method
     * @param first first argument
     * @param second second argument
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Substraction method
     * @param first first argument
     * @param second second argument
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Multiplication method
     * @param first first argument
     * @param second second argument
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }


    /**
     * Devision method
     * @param first first argument
     * @param second second argument
     */
    public void div(double first, double second) {
        if (second != 0d) {
            this.result = first / second;
        } else {
            throw new ArithmeticException("It'snt possibly to divide by 0");
        }
    }

    /**
     * Involution method
     * @param first first argument
     * @param second power argument
     */
    public void power(double first, double second) {
        double temp = first;
        for (int index = 0; index != second; index++) {
            temp *= first;
        }

        this.result = first;
    }

    /**
     * Clear result variable
     */
    public void clear() {
        this.result = 0;
    }

    /**
     * Calculate according to provided operation
     * @param operation possible operations + - * / ^
     * @param first first argument
     * @param second second argument
     */
    public void calcuate(String operation, double first, double second) {
        if ("+".equals(operation)) {
            this.add(first, second);
        } else if ("-".equals(operation)) {
            this.substract(first, second);
        } else if ("*".equals(operation)) {
            this.multiply(first, second);
        } else if ("/".equals(operation)) {
            this.div(first, second);
        } else if ("^".equals(operation)) {
            this.power(first, (int) second);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}