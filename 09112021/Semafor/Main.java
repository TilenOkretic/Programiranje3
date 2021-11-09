import java.util.concurrent.Semaphore;

public class Main {
    
    
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(4);
        System.out.println("Total number of permits: " + sem.availablePermits());
        new Worker("A", sem).start();
        new Worker("B", sem).start();
        new Worker("C", sem).start();
        new Worker("D", sem).start();
        new Worker("E", sem).start();
    }
}
