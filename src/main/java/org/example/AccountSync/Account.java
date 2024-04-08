package org.example.AccountSync;

/**
 * It is a good practice to follow the lock with a try-catch block
 * and release the lock with finally block
 * The lock can be acquired using a static class or static method
 * , and also an instance method or instance class
 */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static final Lock lock = new ReentrantLock();
    protected static int balance = 0;

    Account() {
    }

    ;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        Account.balance = balance;
    }

    // Critical Region.
    public void deposit(int amount) {
        lock.lock();
        int newBalance;
        try {
            newBalance = balance + amount;
            Thread.sleep(200); // sleep thread.

            balance = newBalance;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
