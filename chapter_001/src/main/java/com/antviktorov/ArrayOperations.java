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

    /**
     * Turn arrat on CW 90.
     * @param values - provided multidemential array
     * @return
     */
    public int[][] turnArray(int values[][]) {

        int i;
        int n = values.length;

        // Check matrix if it's possible to turn
        for (i = 0; i < n; i++ ) {
            if (n != values[i].length) {
                throw new Error("Provided array isn't squarable.");
            }
        }

        int j;
        int result[][] = new int[n][n];

        // Turn array on CW 90
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < n; j++)
                result[i][j] = values[n - j - 1][i];
        }

        return result;
    }
}