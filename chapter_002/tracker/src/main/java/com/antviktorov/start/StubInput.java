package com.antviktorov.start;

import com.antviktorov.menu.exceptions.MenuOutException;

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
     * @param question - input question
     * @return selected question
     */
    public String ask(String question) {
        return answers[position++];
    }

    /**
     * Read question.
     * @param question - question
     * @param range - range of available commands
     * @throws MenuOutException
     * @return key
     */
    public int ask(String question, int[] range) throws MenuOutException {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (int value : range) {
            if (value == key) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException("Out if menu exception");
        }
    }
}
