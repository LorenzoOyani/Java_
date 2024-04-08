package org.example.threadCooperation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Accounts {
    private static final Lock lock = new ReentrantLock();
    private static final Condition withdrawal = lock.newCondition();
    private static final Condition newDeposit = lock.newCondition();
    static int balance = 0;
    Accounts(int balance) {
        this.balance = balance;
    }
    public static int getBalance() {
        return balance;
    }
    Accounts() {}
    public static void withdraw(int amount) {
        lock.lock();
        try {
            while(balance < amount) {
                System.out.println("\n wait for deposits\n");
                withdrawal.await();
            }
            System.out.println(STR."\t\twithdraw \{amount}\t\t\{getBalance()}");
        } catch (InterruptedException ex) {
            ex.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public static void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(STR."\t\t deposit \{amount}\t\{getBalance()}");
            newDeposit.signalAll();
        } finally {
            lock.unlock(); // release the lock
        }
    }


}
