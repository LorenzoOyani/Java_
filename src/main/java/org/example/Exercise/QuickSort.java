package org.example.Exercise;

import java.util.Arrays;

public class QuickSort {

    private final int[] arrays = new int[]{2, 9, 8, 1, 5, 4, 3};

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int max = sort.arrays.length;
        sort.quickSort(0, max);
        System.out.println(Arrays.toString(sort.arrays));
    }

    public void swap(int left, int right) {
        int temp = arrays[left];
        arrays[left] = arrays[right];
        arrays[right] = temp;
    }

    public int partition(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (arrays[++leftPointer] < pivot) {
                leftPointer--;
            }
            while (rightPointer > 0 && arrays[--rightPointer] > pivot) {
                rightPointer--;
            }

            if (leftPointer >= rightPointer) {
                break;
            } else {
                swap(leftPointer, rightPointer);
            }

        }
        swap(leftPointer, rightPointer);
        return leftPointer;
    }

    public void quickSort(int left, int right) {
        if (right - left <= 0) {
        } else {
            int pivot = arrays[right];
            int partitionPoint = partition(left, right, pivot);
            quickSort(left, partitionPoint - 1);
            quickSort(partitionPoint + 1, right);
        }


    }
}
