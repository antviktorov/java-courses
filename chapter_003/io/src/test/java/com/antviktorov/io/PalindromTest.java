package com.antviktorov.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PalindromTest {
    @Test
    public void whenPalindromThenCheck() {
        Palindrom palindrom = new Palindrom();
        assertThat(palindrom.check("РоТОр"), is(true));
        assertThat(palindrom.check("мотор"), is(false));
        assertThat(palindrom.check("Комок"), is(true));

        try {
            palindrom.check("ДлинноеДлинноеСлово");
        } catch (Palindrom.PalindromLimit e) {
            assertThat(e.getMessage(), is("Please provide string with length of 5 characters."));
        }
    }
}
