package com.antviktorov.io;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * StreamChecker.
 * @author antonviktorov
 * @since 1.0
 */
public class StreamChecker {
    /**
     * StreamChecker constructor.
     */
    public StreamChecker() {
    }

    /**
     * Check stream is even.
     * @param in - stream
     * @return are all stream bytes even
     * @throws IOException
     */
    Boolean isNumber(InputStream in) throws IOException {
        int oneByte;
        Boolean result = true;
        while ((oneByte = in.read()) != -1) {
            if (oneByte % 2 != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Remove abused words.
     * @param in - input stream
     * @param out - output stream
     * @param abuse - array of abused words
     * @throws IOException
     */
    void dropAbuses(InputStream in, OutputStream out, String[] abuse) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : abuse) {
                    if (line.contains(word)) {
                        line = line.replace(word, "");
                    }
                }
                out.write(line.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
