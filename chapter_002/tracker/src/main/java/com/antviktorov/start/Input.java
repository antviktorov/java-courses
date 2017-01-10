package com.antviktorov.start;

/**
 * Input flow interface.
 */
public interface Input {
    /**
     * Read question.
     * @param question - input question
     * @return flow question
     */
    String ask(String question);
}
