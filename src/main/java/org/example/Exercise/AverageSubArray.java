package org.example.Exercise;

/*
 * A brute-force Approach for finding the sum of a small section of an array
 * */

import java.util.Arrays;

public class AverageSubArray {
    public static double[] subArray(int k, double[] arr) {
        double[] result = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {

            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
                result[j] = sum / k;
            }
        }
        return result;
    }

    void main() {
       double[] result = AverageSubArray.subArray(5, new double[]{2,5,7,8,9,0});
       System.out.println(STR."The result of the sub-array is \{Arrays.toString(result)}");

    }

}
