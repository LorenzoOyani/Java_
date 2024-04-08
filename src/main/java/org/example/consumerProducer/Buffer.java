package org.example.consumerProducer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private static final int CAPACITY = 1;
    private static final LinkedList<Integer> queue = new LinkedList<>();
    private static final Lock lock = new ReentrantLock();

    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();

    Buffer() {
    }

    public static void write(int value) {
        lock.lock();
        try {

            if (queue.size() == CAPACITY) {
                notFull.await();
            }
            queue.offer(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static int read() {
        lock.lock();
        int value = 0;
        try {
            if (queue.isEmpty()) {
                notEmpty.await(); // can't remove from an empty queue, so you wait for the condition to be right, by filling the queue with values
            }
            value = queue.remove();
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            return value;
        }
    }
}
