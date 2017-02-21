package com.antviktorov.io.chat;

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
     * @return flow question
     */
    public String ask() {
        return scanner.nextLine();
    }
}
