package org.example.threadCooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * You need a way for threads to communicate.
 * conditions can be used to facilitate communications among threads
 * conditions are objects created by invoking newCondition() on the Lock object.
 * the condition object has to await(), signal(), signalALL() METHODS for Thread communication.
 *
 */

public class ThreadCooperation {
    void main() {
        ExecutorService executables = Executors.newFixedThreadPool(2);
        executables.execute(new DepositTasks());
        executables.execute(new WithdrawTasks());
        executables.shutdown();

        System.out.println("Thread1\t Thread2\t balance");
    }

}