package org.example.consumerProducer;

public class ProducerTask implements Runnable {
    @Override
    public void run() {
        try {
            int i = 1;
            System.out.println(STR."producer writes \{i}");
            Buffer.write(i++);
            Thread.sleep((int) (Math.random() * 10000));


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
