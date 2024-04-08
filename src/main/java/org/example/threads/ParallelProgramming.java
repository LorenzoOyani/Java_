package org.example.threads;

import java.util.Scanner;

/**
 * Fork/Join frameWork is used for parallel programming in Java
 * ForkJoinPool executes Fork/Join Tasks
 * ForkJoinTask is a Thread-like entity and executed by actual threads in a ForkJoinPool
 * The Fork/Join framework is made to parallelize divide and conquer solutions which are naturally recursive
 */

public class ParallelProgramming {
    public static int Fib(int x) {
        if (x == 1) {
            return 1;
        } else if (x == 0) {
            throw new RuntimeException("StackOverflow");

        } else {
            return x * Fib(x - 1);
        }
    }

    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a factorial number (enter -1 to exit): ");
//        int input = sc.nextInt();
//        String line = sc.nextLine();
        while (true) {

            int input = sc.nextInt();

            if (input == -1) {
                break;
            }
            System.out.println("The factorial of the input number is : " + Fib(input));


        }
//        sc.close();
    }
}

