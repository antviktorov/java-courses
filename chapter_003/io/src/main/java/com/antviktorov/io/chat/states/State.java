package com.antviktorov.io.chat.states;

/**
 * State interface.
 */
public interface State {
    /**
     * Process state mehtod.
     * @param request - provided request
     * @return response
     */
    String process(String request);

    /**
     * Get state code.
     * @return code
     */
    String code();
}
