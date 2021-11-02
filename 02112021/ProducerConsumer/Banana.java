package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Banana {
    
    public static void main(String[] args) {
        BlockingQueue<String> jobs = new ArrayBlockingQueue<String>(10);
        ExecutorService exe = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            new Consumer(jobs).start();
        }
        
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(10);
                System.out.println("jobs in queue: " + jobs.size());
                jobs.add("banana " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
