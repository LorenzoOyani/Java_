package org.example.Exercise;

public class ReplaceOddNumbers {
    int oddCount = 0;
    int[] newOddIndex = new int[oddCount + 1];
    int oddIndex = 0;
    private final int[] arr = new int[]{2, 1, 3, 4, 8, 6, 9, 0, 4};

    private int[] removeOdd() {
        for (int i : arr) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }
        for (int j : arr) {
            if (isOdd(j)) {
                newOddIndex[oddIndex] = j;
                oddIndex++;
            }
        }
        return newOddIndex;

    }

    public boolean isOdd(int j) {
        return j % 2 != 0;
    }
}
