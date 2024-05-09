package org.example.Exercise;

/* bubbleSort algorithm
 * This procedure uses a boolean value to mimic a successive sort across the array
 * Two for-loops are used to help compare the two index of the array elements for proper sorting.
 *  */
public class bubbleSortsM {
    public void bubbleSorts(int[] list) {
        boolean nextpass = true;
        int k;
        for (k = 1; k < list.length && nextpass; k++) {
            nextpass = false;
            for (int j = 0; j < list.length - k; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    nextpass = true;
                }
            }
        }

    }

    void main() {
        int[] arr = new int[]{1, 0, 4, 3, 8, 9, 7, 6, 2, 20};
        bubbleSorts(arr);
    }
}
