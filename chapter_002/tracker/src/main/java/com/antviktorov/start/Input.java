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

    /**
     * Read question.
     * @param question - question
     * @param range - range of available commands
     * @return key
     */
    int ask(String question, int[] range);
}
