package com.antviktorov.io.service;

import org.junit.Test;

import java.io.InputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SettingsTest {
    @Test
    public void whenLoadThenGetFile() throws Exception {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")){
            settings.load(in);
        }
        String value = settings.getValue("split.folder");
        assertThat(value, is("splited"));
    }
}