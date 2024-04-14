package org.example.Exercise;

import java.util.Scanner;

import static java.lang.System.in;

public class ImprovedFib {
    void main() {
        Scanner sc = new Scanner(in);
        System.out.println("enter index: ");
        int keys;
        while (true) {
             keys = sc.nextInt();
            if (keys == - 1) {
                break;
            }
            System.out.println(STR."The index of this fib at \n\{keys} is \{fib(keys)}");

        }

    }

    static int fib(int keys) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;
        if (keys == 0) {
            return (int) f0;
        } else if (keys == 1) {
            return (int) f1;
        } else if (keys == 2) {
            return (int) f2;
            
        }
        for (int i = 3; i <= keys; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f1 + f0;
        }
        return (int) f2;
    }
}
