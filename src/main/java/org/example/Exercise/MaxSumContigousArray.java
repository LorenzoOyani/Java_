package org.example.Exercise;

public class MaxSumContigousArray {
    public int solutions(int k, int[] arr) {

        int sumArr = 0;
        int maxSum = 0;
        int end;
        int start = 0;
        for (end = 0; end < arr.length - k; end++) {
            sumArr += arr[end];

            while (end >= k - 1) {
                maxSum = Math.max(maxSum, sumArr);

                sumArr -= arr[start];
                start++;
                end++;
            }
        }
        return maxSum;
    }
}
