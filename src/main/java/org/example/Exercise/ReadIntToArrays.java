package org.example.Exercise;

import java.util.Scanner;

public class ReadIntToArrays {
    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value: ");
        int input = sc.nextInt();
        int[] arr = new int[input];
        int count = 0;
        int sum = 0;
        while (true) {
            input = sc.nextInt();
            if (input == -1) {
                break;
            }
            for (int i = 0; i < input; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            int average = sum / input;
            for (int j = 0; j < input; j++) {
                if (arr[j] > average) {
                    count++;

                }

            }
            System.out.println(STR."The average is \{average}");
            System.out.println(STR."The average count is \{count}");
        }


    }
}