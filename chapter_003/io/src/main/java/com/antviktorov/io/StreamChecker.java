package com.antviktorov.io;

import java.io.InputStream;
import java.io.IOException;

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
}
