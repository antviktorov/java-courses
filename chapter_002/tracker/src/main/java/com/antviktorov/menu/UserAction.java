package com.antviktorov.menu;

import com.antviktorov.start.Tracker;
import com.antviktorov.start.Input;

/**
 * Action interface.
 */
public interface UserAction {
    /**
     * Get action key.
     * @return key
     */
    int key();
    /**
     * Execute action.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    void execute(Input input, Tracker tracker);
    /**
     * Info string.
     * @return info data
     */
    String info();
}
