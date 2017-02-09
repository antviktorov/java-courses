package com.antviktorov.io;

import org.junit.Test;
import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * StreamCheckerTest.
 * @author antonviktorov
 * @since 1.0
 */
public class StreamCheckerTest {
    @Test
    public void whenTestNotEvenByteStreamThenTrue() {
        byte[] bytes = new byte[] {1,2,3,4,5};
        try (BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(bytes))){
            StreamChecker checker = new StreamChecker();
            assertThat(checker.isNumber(in), is(false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenTestEvenByteStreamThenTrue() {
        byte[] bytes = new byte[] {2,4,6,8,10};
        try (BufferedInputStream in = new BufferedInputStream(new ByteArrayInputStream(bytes))){
            StreamChecker checker = new StreamChecker();
            assertThat(checker.isNumber(in), is(true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
