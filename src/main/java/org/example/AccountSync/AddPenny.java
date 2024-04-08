package org.example.AccountSync;

public class AddPenny implements Runnable {

    AddPenny(){};
    @Override
    public void run() {
        Account account = new Account();
        account.deposit(34);
    }
}
