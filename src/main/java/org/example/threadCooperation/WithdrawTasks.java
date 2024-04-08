package org.example.threadCooperation;

public class WithdrawTasks implements Runnable {
    @Override
    public void run() {
        while (true) {
            Accounts.withdraw((int) (Math.random() * 10) + 1);

        }
    }
}
