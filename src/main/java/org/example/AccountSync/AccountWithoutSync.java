package org.example.AccountSync;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {

void main() {
    ExecutorService execute = Executors.newCachedThreadPool();
    for (int i = 1; i <= 100; i++) {
        execute.execute(new AddPenny());
    }
    execute.shutdown();

    while (!execute.isTerminated()) {
        System.out.println(STR."The new balance is \{}");
    }
}
}

