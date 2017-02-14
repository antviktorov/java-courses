package com.antviktorov.io;

/**
 * Palindrom checker class.
 * @author antonviktorov
 * @since 1.0
 */
public class Palindrom {
    /**
     * Inner exception class to check input limit.
     */
    public class PalindromLimit extends RuntimeException {
        /**
         * PalindromLimit exception constructor.
         */
        PalindromLimit() {
            super("Please provide string with length of 5 characters.");
        }
    }

    /**
     * Check method.
     * @param str - provided string
     * @return result
     * @throws PalindromLimit
     */
    public Boolean check(String str) throws PalindromLimit {
        if (str.length() != 5) {
            throw new PalindromLimit();
        }

        str = str.toLowerCase();
        int length = str.length();

        Boolean result = true;

        int i = 0;
        int j = length - 1;

        do {
            if (str.charAt(i) != str.charAt(j)) {
                result = false;
                break;
            }
            i++;
            j--;
        } while (i != j);

        return result;
    }
}
