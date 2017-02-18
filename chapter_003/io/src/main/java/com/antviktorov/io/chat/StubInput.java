package com.antviktorov.io.chat;

/**
 * Test input class.
 */
public class StubInput implements Input {
    /**
     * Prepared answers.
     */
    private String[] answers;
    /**
     * Answer position.
     */
    private int position = 0;

    /**
     * StubInput constructor.
     * @param answers - answers.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * Select next question from prepared.
     * @return selected question
     */
    public String ask() {
        return answers[position++];
    }
}
