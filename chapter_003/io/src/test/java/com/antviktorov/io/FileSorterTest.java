package com.antviktorov.io;

import com.antviktorov.io.service.Settings;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FileSorterTest {

    private Settings loadSettings() {
        Settings settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")){
            settings.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return settings;
    }

    @Test
    public void whenBigFileSorting() {
        Settings settings = loadSettings();
        try {
            FileSorter sorter = new FileSorter();
            sorter.sort(new File(settings.getValue("source.file")), new File(settings.getValue("sorted.file")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
