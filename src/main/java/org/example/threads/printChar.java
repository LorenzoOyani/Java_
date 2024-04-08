package org.example.threads;
class printChar implements Runnable {
    private final char firstChar;
    private int num;

    printChar(char c, int n) {
        this.firstChar = c;
        this.num = n;
    }

    @Override
    public void run() {
        Thread thread4 = new Thread(new printChar('c', 40));
        thread4.start();
        thread4.setPriority(Thread.MAX_PRIORITY);
        try {
            for (int i = 1; i <= num; i++) {
                System.out.println(STR."characters: \n\{firstChar}");
                Thread.yield();
                if (i == 50) thread4.join();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

