package org.example.Count;

import java.util.Arrays;

public class SetIntValue {

    private static int[] a;

    SetIntValue(int[] keys) {
        a = new int[keys.length];
        System.arraycopy(keys, 0, a, 0, keys.length);
        Arrays.sort(a);


    }

    public static boolean contains(int key) {
        return rank(key) != -1;
    }

    public static int rank(int key) {
        int low = 0;
        int high = a.length - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (a[mid] < key) low = mid - 1;
            if (key > a[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;

    }


    public static void main(String[] args) {
        int[] w = new int[]{Integer.parseInt(args[0])};
        SetIntValue value = new SetIntValue(w);
        
    }

}