package com.antviktorov.calculator;

/**;
 * Implements base math operations
 * @author antonviktorov
 * @since 29.11.16
 */
public class ArgumentRunner {
    public static void main(String[] args) {
        final Calculator calculator = new Calculator();
        calculator.calculate(args[1], Double.valueOf(args[0]), Double.valueOf(args[2]));
        System.out.println(
                String.format("%s %s %s = %s", args[0], args[0], args[0], calculator.getResult())
        );
    }
}