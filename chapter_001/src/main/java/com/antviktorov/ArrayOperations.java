package com.antviktorov;

/**
 * General class for array operations.
 * @author Anton Viktorov
 * @since 1.0
 */
public class ArrayOperations {

    /**
     * Bubble sorting.
     * @param array - entire array
     * @return
     */
    public int[] bubble(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if(!swapped)
                break;
        }

        return array;
    }
}