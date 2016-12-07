package com.antviktorov;

/**
 * Turn array class.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Turn {

    /**
     * Reverse array method.
     * @param array - entire array
     * @return
     */
    public int[] back(int[] array) {

        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex < endIndex) {
            int temp = array[startIndex];

            array[startIndex] = array[endIndex];
            array[endIndex] = temp;

            startIndex++;
            endIndex--;
        }

        return array;
    }
}