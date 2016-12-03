package com.antviktorov;

/**
 * Implements base math operations.
 * @author antonviktorov
 * @since 1.0
 */
public class Calculator {

    /**
     * Saved result.
     */
    private double result;

    /**
     * Get result of operation.
     * @return result
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Addition method.
     * @param first first argument
     * @param second second argument
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Substraction method.
     * @param first first argument
     * @param second second argument
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Multiplication method.
     * @param first first argument
     * @param second second argument
     */
    public void multiply(double first, double second) {
        this.result = first * second;
    }

    /**
     * Devision method.
     * @param first first argument
     * @param second second argument
     */
    public void div(double first, double second) {
        if (second != 0) {
            this.result = first / second;
        } else {
            throw new ArithmeticException("Itsn't possibly to divide by 0");
        }
    }

    /**
     * Clear result variable.
     */
    public void clear() {
        this.result = 0;
    }

    /**
     * Calculate according to provided operation.
     * @param operation possible operations + - * / ^
     * @param first first argument
     * @param second second argument
     */
    public void calculate(String operation, double first, double second) {
        if ("+".equals(operation)) {
            this.add(first, second);
        } else if ("-".equals(operation)) {
            this.substract(first, second);
        } else if ("*".equals(operation)) {
            this.multiply(first, second);
        } else if ("/".equals(operation)) {
            this.div(first, second);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
