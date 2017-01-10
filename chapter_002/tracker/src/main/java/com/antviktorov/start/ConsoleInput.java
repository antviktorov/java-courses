package com.antviktorov.start;

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
}
