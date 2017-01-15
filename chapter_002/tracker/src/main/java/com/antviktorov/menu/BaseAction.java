package com.antviktorov.menu;

import com.antviktorov.start.Input;
import com.antviktorov.start.Tracker;

/**
 * Base action class.
 */
public abstract class BaseAction {
    /**
     * Action name.
     */
    protected String name;
    /**
     * Base action constructor.
     * @param name - provided name
     */
    public BaseAction(String name) {
        this.name = name;
    }
    /**
     * Action key.
     * @return key
     */
    abstract int key();
    /**
     * Execute action.
     * @param input - input flow
     * @param tracker - tracker entity
     */
    abstract void execute(Input input, Tracker tracker);
    /**
     * Info string.
     * @return info data
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
