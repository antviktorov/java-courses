package com.antviktorov.io.chat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.antviktorov.io.chat.states.Running;
import com.antviktorov.io.chat.states.State;
import com.antviktorov.io.chat.states.States;
import com.antviktorov.io.service.Settings;

/**
 * Console chat.
 * @author antonviktorov
 * @since 1.0
 */
public class ConsoleChat {
    /**
     * Input data.
     */
    protected Input input;
    /**
     * Current chat state.
     */
    protected State state;
    /**
     * Debug chat in console.
     */
    protected boolean debug;
    /**
     * Application settings.
     */
    protected Settings settings;

    /**
     * Chat constructor.
     * @param input - input data
     * @param debug - debug in console
     */
    public ConsoleChat(Input input, boolean debug) {
        this.input = input;
        this.debug = debug;
    }

    /**
     * Starting console chat.
     */
    public void start() {
        initEnv();
        changeState(new Running(this));
        do {
            String request = input.ask();
            log(request);
            log(state.process(request));
        } while (!(state.code()).equals(States.STATE_FINISHED));
    }

    /**
     * Log chat line.
     * @param line - current chat line
     */
    public void log(String line) {
        if (line == null || line == "") {
            return;
        }
        if (this.debug) {
            System.out.println(line);
        }

        try {
            File logFile = new File(this.settings.getValue("chat.log"));
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            RandomAccessFile fileAccess = new RandomAccessFile(logFile, "rw");
            fileAccess.seek(fileAccess.length());
            fileAccess.writeBytes(getCurrentDate() + " " + line + System.lineSeparator());
            fileAccess.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Change chat state.
     * @param state - new state
     */
    public void changeState(State state) {
        this.state = state;
    }

    /**
     * Get current date String for log.
     * @return current date
     */
    protected String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Setting uo.
     */
    protected void initEnv() {
        this.settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")) {
            settings.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Console function.
     * @param params - console params
     */
    public static void main(String[] params) {
        ConsoleChat chat = new ConsoleChat(new ConsoleInput(), true);
        chat.start();
    }
}
