package org.example.threads;

public class printNum implements Runnable {
    int num;

    printNum(int num) {
        this.num = num;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= num; i++) {
                System.out.println(STR."\{i} ");
                Thread.yield();
            }
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
    }
}
