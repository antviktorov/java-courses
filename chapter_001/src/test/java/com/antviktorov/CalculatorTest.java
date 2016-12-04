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
     * Addition Test 2 + 2 = 4.
     */
    @Test
    public void whenAdditionTwoPlusTwoThenFour() {
        Calculator calculator = new Calculator();
	    calculator.calculate("+", 2, 2);
	    assertThat(calculator.getResult(), is(4.0));
    }


    /**
     * Substraction Test 10 - 5 = 5.
     */
    @Test
    public void whenSubstactionTenMinusFiveThenFive() {
        Calculator calculator = new Calculator();
        calculator.calculate("-", 10, 5);
        assertThat(calculator.getResult(), is(5.0));
    }

    /**
     * Multiplication Test 2 * 5 = 10.
     */
    @Test
    public void whenMultiplicationTwoMultiplyFiveThenTen() {
        Calculator calculator = new Calculator();
        calculator.calculate("*", 2, 5);
        assertThat(calculator.getResult(), is(10.0));
   }

   /**
     * Division Test 9 / 3 = 3.
     */
   @Test
   public void whenNineDivisitionThreeThenThree() {
       Calculator calculator = new Calculator();
       calculator.calculate("/", 9, 3);
       assertThat(calculator.getResult(), is(3.0));
    }
}
