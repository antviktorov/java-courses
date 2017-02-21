package com.antviktorov.io.chat.states;

import com.antviktorov.io.chat.ConsoleChat;

/**
 * Base state class.
 * @author antonviktorov
 * @since 1.0
 */
public abstract class BaseState  {
    /**
     * Chat link.
     */
    ConsoleChat chat;

    /**
     * Base state constructor.
     * @param chat - chat link
     */
    BaseState(ConsoleChat chat) {
        this.chat = chat;
    }

    /**
     * Change state method.
     * @param state - new state
     */
    protected void changeState(State state) {
        this.chat.changeState(state);
    }

    /**
     * Check if state is finished.
     * @param request - current request
     * @return boolean
     */
    public Boolean isFinished(String request) {
        if (request.equals(Actions.ACTION_FINISH)) {
            changeState(new Finished(this.chat));
            return true;
        }
        return false;
    }
}
