package org.example.threadCooperation;

public class DepositTasks implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                Accounts.deposit((int) (Math.random() * 10) + 1);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
