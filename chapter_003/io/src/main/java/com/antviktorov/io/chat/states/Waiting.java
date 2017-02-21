package com.antviktorov.io.chat.states;

import com.antviktorov.io.chat.ConsoleChat;

/**
 * Waiting state.
 * @author antonviktorov
 * @since 1.0
 */
public class Waiting extends BaseState implements State {
    /**
     * Waiting state constructor.
     * @param chat - chat link
     */
    Waiting(ConsoleChat chat) {
        super(chat);
    }

    /**
     * Process Waiting state.
     * @param request - provided request
     * @return response
     */
    public String process(String request) {
        if (isFinished(request)) {
            return "";
        }

        if (request.equals(Actions.ACTION_RUN)) {
            changeState(new Running(this.chat));
        }
        return "";
    }

    /**
     * Get Waiting state code.
     * @return code
     */
    public String code() {
        return States.STATE_RUNNING;
    }
}
