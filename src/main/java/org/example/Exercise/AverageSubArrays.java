package org.example.Exercise;

import java.util.Arrays;

public class AverageSubArrays {
    public static double[] subArrays(int k, double[] array) {
        double[] result = new double[array.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < array.length - k; windowEnd++) {
            windowSum += array[windowEnd];

            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k; // get the average;
                windowSum -= array[windowStart];
                windowStart++;
            }
        }
        return result;
    }

    void main() {
        double[] result = AverageSubArray.subArray(5, new double[]{2, -1, 0, 4, 3, 2});
        System.out.println(STR."The sub array vales is \{Arrays.toString(result)}");

    }
}
