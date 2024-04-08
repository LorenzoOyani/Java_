package org.example.threads;

import java.util.concurrent.Semaphore;

public class Accounts {
    private static final Semaphore semaphore = new Semaphore(1);
    private static int balance = 0;

    public void deposit(int amount) {
        try {
            semaphore.acquire();
            int newBalance = balance += amount;

            Thread.sleep(5); // delay added to magnify data-corruption problems.

            balance = newBalance;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }


    }

}
