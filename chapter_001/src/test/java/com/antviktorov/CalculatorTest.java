package com.antviktorov;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Calculator Test class.
*
* @author Anton Viktorov
* @since 1.0
*/
public class CalculatorTest {

    /**
     * Addition result.
     */
    private static final double ADDITION_RESULT          = 4.0;
    /**
     * First argument.
     */
    private static final double ADDITION_FIRST_ARGUMENT  = 2;
    /**
     * Second argument.
     */
    private static final double ADDITION_SECOND_ARGUMENT = 2;
    /**
     * Substraction result.
     */
    private static final double SUBSTRACTION_RESULT          = 5.0;
    /**
     * First argument.
     */
    private static final double SUBSTRACTION_FIRST_ARGUMENT  = 10;
    /**
     * Second argument.
     */
    private static final double SUBSTRACTION_SECOND_ARGUMENT = 5;

    /**
     * Multiplication result.
     */
    private static final double MULTIPLUCATION_RESULT                       = 10.0;
    /**
     * First argument.
     */
    private static final double MULTIPLUCATION_SUBSTRACTION_FIRST_ARGUMENT  = 2;
    /**
     * Second argument.
     */
    private static final double MULTIPLUCATION_SUBSTRACTION_SECOND_ARGUMENT = 5;

    /**
     * Division result.
     */
    private static final double DIVISION_RESULT = 3.0;
    /**
     * First argument.
     */
    private static final double DIVISION_SUBSTRACTION_FIRST_ARGUMENT  = 9;
    /**
     * Second argument.
     */
    private static final double DIVISION_SUBSTRACTION_SECOND_ARGUMENT = 3;
    /**
     * Addition Test 2 + 2 = 4.
     */
    @Test
    public void whenAdditionTwoPlusTwoThenFour() {
        Calculator calculator = new Calculator();
	calculator.calculate("+", ADDITION_FIRST_ARGUMENT, ADDITION_SECOND_ARGUMENT);
	assertThat(calculator.getResult(), is(ADDITION_RESULT));
    }


    /**
     * Substraction Test 10 - 5 = 5.
     */
    @Test
    public void whenSubstactionTenMinusFiveThenFive() {
        Calculator calculator = new Calculator();
        calculator.calculate("-", SUBSTRACTION_FIRST_ARGUMENT, SUBSTRACTION_SECOND_ARGUMENT);
        assertThat(calculator.getResult(), is(SUBSTRACTION_RESULT));
    }

    /**
     * Multiplication Test 2 * 5 = 10.
     */
    @Test
    public void whenMultiplicationTwoMultiplyFiveThenTen() {
   	Calculator calculator = new Calculator();
   	calculator.calculate(
             "*",
             MULTIPLUCATION_SUBSTRACTION_FIRST_ARGUMENT,
      	     MULTIPLUCATION_SUBSTRACTION_SECOND_ARGUMENT
   	);
   	assertThat(calculator.getResult(), is(MULTIPLUCATION_RESULT));
   }

   /**
     * Division Test 9 / 3 = 3.
     */
   @Test
   public void whenNineDivisitionThreeThenThree() {
       Calculator calculator = new Calculator();
       calculator.calculate(
            "/",
            DIVISION_SUBSTRACTION_FIRST_ARGUMENT,
            DIVISION_SUBSTRACTION_SECOND_ARGUMENT
       );
       assertThat(calculator.getResult(), is(DIVISION_RESULT));
    }
}
