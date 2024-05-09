package org.example.Exercise;

public class InsertionSort {

    public static void insertionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }

    }

    void main() {
        int[] arr = new int[]{1, 3, 4, 5, 6, 7, 4};
        InsertionSort.insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {

            System.out.println("index at " + i + " is " + arr[i]);
        }

    }
}
