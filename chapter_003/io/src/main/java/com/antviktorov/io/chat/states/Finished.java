package com.antviktorov.io.chat.states;

import com.antviktorov.io.chat.ConsoleChat;

/**
 * Finished state.
 * @author antonviktorov
 * @since 1.0
 */
public class Finished extends BaseState implements State {
    /**
     * Finished state constructor.
     * @param chat - chat link
     */
    Finished(ConsoleChat chat) {
        super(chat);
    }

    /**
     * Process method implementation.
     * @param request - current request
     * @return response
     */
    public String process(String request) {
        return "";
    }

    /**
     * Get Finished state code.
     * @return code
     */
    public String code() {
        return States.STATE_FINISHED;
    }
}
