package org.example.Exercise;

public class mergeSort {
    private final int[] arr = new int[]{2, 4, 5, 1, 0, 9, 7, 6, 0};
    private final int[] b = new int[arr.length];

    public void merging(int low, int mid, int high) {
        int left, right, i;
        for (left = low, right = mid + 1, i = low; left <= mid && right <= high; i++) {

            if (arr[low] < arr[high]) {
                b[i] = arr[left++];
            } else {
                b[i] = arr[right++];
            }
            //copy fragments of the lists into the new Array.
            while (left <= mid) {
                b[i] = arr[left++];
            }
            while (right <= mid) {
                b[i] = arr[right++];
            }
            // get the full length of the array
            for (i = low; i <= high; i++) {
                arr[i] = b[i]; // copy the sorted list back to the main array.
            }
        }

    }

    public void sorts(int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sorts(low, mid - 1);
            sorts(mid + 1, high);
            merging(low, mid, high);
        } else {
            System.out.println("Recursive error");
        }

    }

    void main() {
        int i;
        int n = arr.length;
        System.out.println("arrays before sorting..");
        for (i = 0; i < n; i++) {
            System.out.println(STR."\{arr[i]}");
        }
        sorts(0, n - 1);

    }
}
