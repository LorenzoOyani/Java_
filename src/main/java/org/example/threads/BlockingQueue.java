package org.example.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The ArrayBlockingQueue causes an element to block when you want to add an element to a fix sized full
 * list. and do the same when you try to remove from an empty list.
 */

public class BlockingQueue {

    private static final ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(2); // provide a capacity to the blocking lists.

    void main() {
        ExecutorService executables = Executors.newFixedThreadPool(2);
        executables.execute(new producerTasks());
        executables.execute(new consumerTask());
        executables.shutdown();

    }

    public static class producerTasks implements Runnable {
        @Override
        public void run() {
            try {
                int i = 1;
                System.out.println("\t\tThe producer tasks " + i);
                buffer.put(i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

        public static class consumerTask implements Runnable {
            @Override
            public void run() {
                try {
                    System.out.println(STR."\t\tThe consumer tasks \{buffer.take()}");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


}
