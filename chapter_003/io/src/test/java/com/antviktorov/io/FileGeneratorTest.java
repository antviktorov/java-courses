package com.antviktorov.io;

import com.antviktorov.io.service.Settings;
import org.junit.Test;

import java.io.InputStream;

public class FileGeneratorTest {
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
    public void whenGenerateFile() {
        Settings settings = loadSettings();
        FileGenerator generator = new FileGenerator(
                settings.getValue("generated.file"),
                Double.parseDouble(settings.getValue("size.small"))
        );
        generator.generate();
    }
}
