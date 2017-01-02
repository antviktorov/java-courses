package com.antviktorov;

import java.util.Arrays;

/**
 * Merge array class.
 * @author Anton Viktorov
 * @since 1.0
 */
public class Merge {

    /**
     * Merge two arrays into own.
     * @param array1 - first array
     * @param array2 - second array
     * @return merged array
     */
    public int[] merge(int[] array1, int[] array2) {
        int length1 = array1.length, length2 = array2.length;
        int index1 = 0, index2 = 0;
        int length = length1 + length2;

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            if (index1 < length1 && index2 < length2) {
                result[i] = ((array1[index1] > array2[index2]) ? array2[index2++] : array1[index1++]);
            } else if (index1 < length1) {
                result[i] = array1[index1++];
            } else {
                result[i] = array2[index2++];
            }
        }
        return result;
    }

    /**
     * Merge sort array.
     * @param array - entire array
     * @return sorted array
     */
    public int[] sort(int[] array) {
        int length = array.length;

        if (length < 2) {
            return array;
        }

        int half = length / 2;

        return merge(
                sort(Arrays.copyOfRange(array, 0, half)),
                sort(Arrays.copyOfRange(array, half, length))
        );
    }
}