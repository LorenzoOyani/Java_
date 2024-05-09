package org.example.Count;

// using the sliding window method to solve this problem of average subArray.

import org.example.Exercise.AverageSubArray;

import java.util.Arrays;

public class AverageSubArrays {

    public static double[] averageSubs(int k, double[] list) {
        double[] result = new double[list.length - k + 1];
        int startWindowCount = 0;
        int endWindowCount = 0;
        double windowCountSum = 0;
        for (; endWindowCount < list.length - k; endWindowCount++) {
            windowCountSum += list[endWindowCount];
            endWindowCount++;

            if (endWindowCount >= k - 1) {
                // get the average of the subArray;
                result[startWindowCount] -= windowCountSum / k;
                startWindowCount++;
            }
        }
        return result;


    }

    void main() {
        double[] result = AverageSubArray.subArray(5, new double[]{2, -1, 0, 4, 3, 2});
        System.out.println(STR."The sub array vales is \{Arrays.toString(result)}");

    }
}
