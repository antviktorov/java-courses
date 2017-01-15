package com.antviktorov.start;

import com.antviktorov.menu.exceptions.MenuOutException;

/**
 * Override input class.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Read question.
     * @param question - question
     * @param range - range of available commands
     * @return key
     */
    @Override
    public int ask(String question, int[] range) {
        boolean valid = false;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                valid = true;
            } catch (MenuOutException e) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException e) {
                System.out.println("Please enter validated data again");
            }
        } while (!valid);
        return  value;
    }
}
