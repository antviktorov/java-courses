package com.antviktorov.start;

import com.antviktorov.menu.exceptions.MenuOutException;

import java.util.Scanner;

/**
 * CLI input.
 */
public class ConsoleInput implements Input {
    /**
     * ClI reader class.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Read question.
     * @param question - input question
     * @return flow question
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Read question.
     * @param question - question
     * @param range - range of available commands
     * @return key
     * @throws MenuOutException
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
