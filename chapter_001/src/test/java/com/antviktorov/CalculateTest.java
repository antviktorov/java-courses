package com.antviktorov;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test class.
*
* @author Anton Viktorov
* @since 30.11.2016
*/
public class CalculateTest {

	/**
	* First Test in Java.
	*/
	@Test
	public void whenAddOneToIneThenTwo() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(out.toString(), is("Hello World!\n"));
        }
}
