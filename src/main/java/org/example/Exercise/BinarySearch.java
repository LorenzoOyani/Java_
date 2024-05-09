package org.example.Exercise;

public class BinarySearch {
    public static int binary_search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (arr[mid] < key) {
                 low =   mid - 1;
            } else if (key < arr[mid]) {
                high = mid + 1;

            } else {
                return mid;
            }
        }
        return  -1;
    }

    void main() {
        int k = 5;
        int[] arr = new int[]{2, 3, 6, 7, 9, 4, 5, 6, 3, 4};
        int n = arr.length;
        int key = 6;
        int low = 0;
        int high = n - 1;
       int l =  binary_search(arr, key);
    }
}
