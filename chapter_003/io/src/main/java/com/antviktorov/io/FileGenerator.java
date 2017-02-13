package com.antviktorov.io;

import java.io.IOException;
import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.security.SecureRandom;

/**
 * File generator class.
 * @author antonviktorov
 * @since 1.0
 */
public class FileGenerator {
    /**
     * Alphabet.
     */
    static final String ABC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    /**
     * Random class.
     */
    static SecureRandom rnd = new SecureRandom();
    /**
     * Provided file size in bytes.
     */
    private double fileSize;
    /**
     * Path to file.
     */
    private String fileName;

    /**
     * FileGenerator constructor.
     * @param filename - filename
     * @param fileSize - file size
     */
    FileGenerator(String filename, double fileSize) {
        this.fileSize = fileSize;
        this.fileName = filename;
    }

    /**
     * Random string length in file.
     * @return length
     */
    protected int generateRandomLineLength() {
        return 1 + (int) (Math.random() * 100);
    }

    /**
     * Generating new line.
     * @param length - line length
     * @return generated line
     */
    public String generateLine(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ABC.charAt(rnd.nextInt(ABC.length())));
        }
        return sb.toString();
    }

    /**
     * Generation method.
     */
    public void generate() {
        File file = new File(this.fileName);
        if (file.exists()) {
            file.delete();
        }

        try (Writer writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(this.fileName), "utf-8"))) {
            double totalSize = 0;
            do {
                String newLine = this.generateLine(this.generateRandomLineLength());
                writer.write(newLine + System.getProperty("line.separator"));
                totalSize += newLine.getBytes().length;
            } while (totalSize < this.fileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
