package org.example.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FindThread {
    static int takePtr, putPtr, count;
    private final Object[] items = new Object[100];
    private final Lock locks = new ReentrantLock();
    private final Condition notEmpty = locks.newCondition();
    private final Condition notFull = locks.newCondition();

    public void putPointer(Object x) throws InterruptedException {
        locks.lock();
        try {
            while (count == items.length) {
                notFull.await();
                items[putPtr] = x;
                if (++putPtr == items.length) putPtr = 0;
                ++count;
                notEmpty.signal();
            }
        } finally {
            locks.unlock();
        }
    }

    public Object takePtr() throws InterruptedException {
        locks.lock();
        try {
            while (count == 0) {
                notEmpty.await();
                Object x = items[takePtr];
                if (++takePtr == items.length) takePtr = 0;
                --count;
                notFull.signal();
                return x;
            }
        } finally {
            locks.unlock();
        }
        return null;
    }


}
