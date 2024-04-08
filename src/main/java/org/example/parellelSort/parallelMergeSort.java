package org.example.parellelSort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class parallelMergeSort {
    public static void parallelMergeSorts(int[] list) {
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);

    }

    void main() {
        final int SIZE = 7000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];

        for (int i = 0; i < list1.length; i++) {
            list1[i] = list2[i] = (int) (Math.random() * 1000000);
        }

        long startTime = System.currentTimeMillis();
        parallelMergeSorts(list1);
        long endTime = System.currentTimeMillis();
        System.out.println(STR."\nParallel time with \{Runtime.getRuntime().availableProcessors()}processor is \{endTime - startTime} milliseconds");

    }

    static class SortTask extends RecursiveAction {
        private static final int THRESHOLD = 500;
        private static int[] list;

        SortTask(int[] list) {
            SortTask.list = list;
        }


        @Override
        protected void compute() {
            if (list.length < THRESHOLD) {
                Arrays.sort(list);
            } else {
                int firstHalfLength = list.length / 2;
                int[] firstHalf = new int[firstHalfLength];
                System.arraycopy(list, 0, firstHalf, 0, firstHalfLength);
//                System.out.println(firstHalf.toString());

                int secondHalfLength = list.length - list.length / 2;
                int[] secondHalf = new int[secondHalfLength];
                System.arraycopy(list, list.length, secondHalf, 0, secondHalfLength);

                invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));

                MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
    }

}
