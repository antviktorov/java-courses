package com.antviktorov.io.service;

import java.io.InputStream;
import java.util.Properties;

/**
 * Settings class.
 * @author antonviktorov
 * @since 1.0
 */
public class Settings {
    /**
     * Represents a persistent set of properties.
     */
    private final Properties properties = new Properties();

    /**
     * Load properties file.
     * @param in - input stream (file)
     */
    public void load(InputStream in) {
        try {
            this.properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting property value.
     * @param key - provided key
     * @return property value
     */
    public String getValue(String key) {
        return  this.properties.getProperty(key);
    }
}
