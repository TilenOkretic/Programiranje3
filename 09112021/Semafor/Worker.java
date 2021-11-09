import java.util.concurrent.Semaphore;

public class Worker extends Thread {
    private String name;
    Semaphore sem;

    public Worker(String n, Semaphore sem) { 
        this.name = n;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " acquireing lock...");
            System.out.println(name + " permits:" + sem.availablePermits());
            sem.acquire();
            System.out.println(name + " got the permit");
            sleep(1000); // critical section
            System.out.println(name + " permits:" + sem.availablePermits());
            sem.release();
            System.out.println(name + " permits:" + sem.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}