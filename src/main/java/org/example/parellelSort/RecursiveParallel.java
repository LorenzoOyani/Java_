package org.example.parellelSort;

import java.util.Scanner;

// find the maximum of a  value in an array of integers.
public class RecursiveParallel {
    public static int findMaximumArr(int[] arr, int count) {
        if ( arr.length == 0 || count == 0) {
            return Integer.MIN_VALUE;
        } else {
            return findMaximumArrValues(arr, 0, count -1);

        }
    }

    public static int findMaximumArrValues(int[] arr, int low, int high) {
        int mid = 0, result = 0, firstHalf = 0, secondHalf = 0;
        if (low == high) {
           return  arr[low]; // return this if there is only one digit in the array.
        } else {
            while (low < high) {
                mid = (low + high) / 2;
                firstHalf = findMaximumArrValues(arr, low, mid);
                secondHalf = findMaximumArrValues(arr, low, mid + 1);
//                result = firstHalf + secondHalf;
//                if ((mid < arr.length - 1) && (arr[mid] == arr[mid + 1]) && (arr[mid] == 0)) {
//                    result++;
//                }


            }
            if ((mid < arr.length - 1) && (arr[mid] == arr[mid + 1] && arr[mid] == 0)) {
                return result++;
            } else {
                return Math.max(firstHalf, secondHalf);
            }

//
        }
    }

    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values or ( -1 to exit): ");
        int[] arr = new int[7000000];
        int count = 0;

        while (true) {
            int input = sc.nextInt();
            if (input == -1 || count == arr.length) {
                break;
            }
            if (input == 0) {

                System.out.println("The number zero not allowed");
                break;
            }

            arr[count++] = input;

        }
        int r = findMaximumArr(arr, count);
        System.out.println(STR."The  \{r}");
        

    }
}

