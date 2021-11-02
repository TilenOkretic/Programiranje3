package prviPrimer;
import java.util.*;

public class Sinhro {

    // Uporabimo Object za zaklepanje ki ni vezano na razred!!
    Object lock1 = new Object();
    Object lock2 = new Object();
    
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
        synchronized (lock1) {
            try {
                Thread.sleep(1);
                prva.add(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
                druga.add(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }
}
