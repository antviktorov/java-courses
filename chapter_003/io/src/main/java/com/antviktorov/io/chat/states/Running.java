package com.antviktorov.io.chat.states;

import com.antviktorov.io.chat.ConsoleChat;
import com.antviktorov.io.service.Settings;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Running state.
 * @author antonviktorov
 * @since 1.0
 */
public class Running extends BaseState implements State {
    /**
     * Application settings.
     */
    Settings settings;
    /**
     * Random class.
     */
    Random random;

    /**
     * Running state.
     * @param chat - chat link
     */
    public Running(ConsoleChat chat) {
        super(chat);

        this.settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")) {
            settings.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }

        random = new Random();
    }

    /**
     * Process Running state.
     * @param request - current request
     * @return response
     */
    public String process(String request) {
        if (isFinished(request)) {
            return "";
        }

        if (request == Actions.ACTION_STOP) {
            changeState(new Waiting(this.chat));
            return "";
        }
        return getRandmonString();
    }

    /**
     * Get state code.
     * @return code
     */
    public String code() {
        return States.STATE_RUNNING;
    }

    /**
     * Get random line from the dictionary.
     * @return random line
     */
    private String getRandmonString() {
        String randomLine = "";

        File dictionaryFile = new File(this.settings.getValue("chat.dictionary"));
        try (RandomAccessFile dictionary = new RandomAccessFile(dictionaryFile, "r")) {

            int i = 0;
            while (dictionary.readLine() != null) {
                i++;
            }
            dictionary.seek(0);

            int random = this.random.nextInt(i) + 1;
            i = 0;
            while ((randomLine = dictionary.readLine()) != null) {
                i++;
                if (i == random) {
                    break;
                }
            }

            dictionary.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomLine;
    }
}
