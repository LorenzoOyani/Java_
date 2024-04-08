package org.example.parellelSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelMax {
    private static final int SIZE = 700000;
    private final int[] list = new int[SIZE];

    public static int max(int[] list) {
        RecursiveTask<Integer> tasks = new MaxTasks(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(tasks);

    }

    void main() {
        int n = list.length;
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }
        long startTime = System.currentTimeMillis();
        System.out.println(STR."The max param is \{max(list)}");
        long endTime = System.currentTimeMillis();
        System.out.println(STR."The time for processing is \{Runtime.getRuntime().availableProcessors()}\{endTime - startTime} miliseconds");

    }

    public static class MaxTasks extends RecursiveTask<Integer> {
        private final int[] list;
        private final int low;
        private final int high;

        MaxTasks(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;

        }

        @Override
        protected Integer compute() {
            int THRESHOLD = 7000;
            int max = 0;
            if (high - low < THRESHOLD) {
                max = list[0];
                for (int i = low; i < high; i++) {
                    if (list[i] > max) {
                        max = list[i];
                    }
                }

            }
            return Integer.valueOf(max);

        }
    }

}
