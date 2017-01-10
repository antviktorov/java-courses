package com.antviktorov.start;

import com.antviktorov.menu.MenuTracker;

/**
 * Application start point.
 * @author antonviktorov
 * @since 1.0
 */
public class StartUI {

    /**
     * Input flow.
     */
    private  Input input;
    /**
     * Tracker instance.
     */
    private Tracker tracker;

    /**
     * Main class constructor.
     * @param input - input flow
     * @param tracker - tracker instance
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Init tracker and main menu responsibilities.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select:"));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit? y")));
    }

    /**
     * Java CLI start point.
     * @param args - array of arguments provided in CLI
     */
    public static void main(String[] args) {
        new StartUI(
                new ConsoleInput(), new Tracker()
        ).init();
    }
}
