package com.antviktorov.io;

import java.io.File;
import java.util.Comparator;

/**
 * File size comparator.
 * @author antonviktorov
 * @since 1.0
 */
public class FileSizeComparator implements Comparator<File> {
    /**
     * Compare 2 files by it's size.
     * @param a - file a
     * @param b - file b
     * @return compare
     */
    public int compare(File a, File b) {
        long aSize = a.length();
        long bSize = b.length();
        if (aSize == bSize) {
            return 0;
        } else {
            return Long.compare(aSize, bSize);
        }
    }
}