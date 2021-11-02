package ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {

    BlockingQueue<String> jobs;
    public Consumer(BlockingQueue<String> j) {
        this.jobs = j;
    }

    @Override
    public void run() {
        // consume
        while(true) {
            try {
                String todo = jobs.take();
                Thread.sleep(1000);
                System.out.println("Consumed job: " + todo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
