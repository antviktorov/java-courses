package com.antviktorov.io.bot;

import java.util.HashMap;

/**
 * Dictionary request/response.
 * @author antonviktorov
 * @since 1.0
 */
public class Dictionary {
    /**
     * HashMap for request/response.
     */
    HashMap<String, String> map;

    /**
     * Dictionary constructor.
     */
    public Dictionary() {
        this.map = new HashMap<String, String>();
    }

    /**
     * Init questions function.
     */
    public void init() {
        this.map.put("hello", "Hello, dear friend, I'm Oracle.");
        this.map.put("who are you?", "I'm Oracle.");
        this.map.put("What you can do for me?", "I can answer your questions.");
        this.map.put("Who is your developer?", "His name is Larry Ellison. He is CEO of the Oracle company.");
        this.map.put("What is you favorite hobby?", "I am fond of typing and chating, that's I made for.");
        this.map.put("To be or not to be?", "To be, of course!");
    }

    /**
     * Getting response according to request.
     * @param question - provided question
     * @return response
     */
    public String getResponse(String question) {
        return this.map.get(question);
    }
}
