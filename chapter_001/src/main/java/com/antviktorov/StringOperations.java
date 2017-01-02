package com.antviktorov;

/**
 * Final task.
 * @author Anton Viktorov
 * @since 1.0
 */
public class StringOperations {

    /**
     * Check if stirng contains substring.
     * @param origin - entire string
     * @param sub - substring
     * @return boolean result
     */
    boolean contains(String origin, String sub) {

        boolean result = false;

        char[] originArray = origin.toCharArray();
        char[] subArray = sub.toCharArray();

        int originLength = originArray.length;
        int subLength = subArray.length;

        int subIndex = 0;

        for (int i = 0; i < originLength; i++) {
            if (subArray[subIndex] == originArray[i]) {
                if (subIndex == subLength - 1) {
                    result = true;
                    break;
                }
                subIndex++;
            } else {
                subIndex = 0;
            }
        }

        return result;
    }
}