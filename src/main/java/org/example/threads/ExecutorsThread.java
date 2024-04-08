package org.example.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsThread {
    void main() {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new printChar('c', 30));

        executorService.shutdown();

        while (!executorService.isTerminated()) {
//            System.out.println("The characters is "+  );
        }

    }



}
