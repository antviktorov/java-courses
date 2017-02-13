package com.antviktorov.io;

import com.antviktorov.io.service.Settings;

import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Sorting big files class.
 * @author antonviktorov
 * @since 1.0
 */
public class FileSorter {
    /**
     * Application settings.
     */
    private Settings settings;

    /**
     * Sorting class.
     */
    FileSorter() {
        this.settings = new Settings();
        ClassLoader loader = Settings.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("app.properties")) {
            settings.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Split files by a line.
     * @param source - source file
     * @return array to files links
     * @throws IOException
     */
    protected File[] splitSourceFile(File source) throws IOException {
        File splitDirectory = new File(this.settings.getValue("split.folder"));
        if (!splitDirectory.exists()) {
            splitDirectory.mkdir();
        }

        RandomAccessFile sourceFile = new RandomAccessFile(source, "r");
        String line;
        int linesCounter = 0;

        while ((line = sourceFile.readLine()) != null) {
            File newFile = new File(
                    this.settings.getValue("split.folder") + File.separator + linesCounter++ + ".txt"
            );
            newFile.createNewFile();
            RandomAccessFile newFileAccess = new RandomAccessFile(newFile, "rw");
            newFileAccess.writeBytes(line);
            newFileAccess.close();
        }
        sourceFile.close();

        return (new File(this.settings.getValue("split.folder")).listFiles());
    }

    /**
     * Sort file.
     * @param source - file source
     * @param distance - destination file
     * @throws IOException
     */
    public void sort(File source, File distance) throws IOException {
        File[] files = splitSourceFile(source);

        //Sorting files by size
        Arrays.sort(files, new FileSizeComparator());

        if (distance.exists()) {
            distance.delete();
        }

        RandomAccessFile distanceAccess = new RandomAccessFile(distance, "rw");
        for (File file : files) {
            RandomAccessFile fileAccess = new RandomAccessFile(file, "r");
            distanceAccess.writeBytes(fileAccess.readLine() + System.lineSeparator());
            fileAccess.close();
            file.delete();
        }
        distanceAccess.close();

        File splitDirectory = new File(this.settings.getValue("split.folder"));
        splitDirectory.delete();
    }
}
