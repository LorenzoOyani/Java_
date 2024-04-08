package org.example.consumerProducer;

public class ConsumerProducer implements Runnable {


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(STR."\t\tThe buffers is read by consumer \{Buffer.read()}");
                Thread.sleep((int) (Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
