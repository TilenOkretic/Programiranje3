package prviPrimer;
import java.util.*;

public class Worker {
    
    List<Integer> prva = new ArrayList<Integer>();
    List<Integer> druga = new ArrayList<Integer>();

    Random random = new Random();
    public void main(String[] args) {
        
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
    
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        try {
            t1.start();
            t2.start();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
    }

    public void stageOne() {
        try {
            Thread.sleep(1);
            prva.add(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void stageTwo() {
        try {
            Thread.sleep(1);
            druga.add(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
}
