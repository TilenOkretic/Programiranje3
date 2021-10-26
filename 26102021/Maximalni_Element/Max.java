import java.util.Random;

/*
    Lab Vaj za Programiranje 3 - vzporedno programiranje
     * Tretja ura
     * maximalni element
*/
public class Max {

    static volatile int max = 0; // volatile zagotovi L3 caching

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE / 5;
        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
        arr[rand.nextInt(n)] = 123141523;

        int threads = Runtime.getRuntime().availableProcessors();
        int chunk = n / threads;
        long t0 = System.currentTimeMillis();
        
        Finder[] finders = new Finder[threads];
        for (int i = 0; i < finders.length - 1; i++) {
            finders[i] = new Finder(i*chunk, i*chunk+chunk, arr);
        }
        finders[threads-1] = new Finder((threads-1)*chunk, n, arr);
        
        for (int i = 0; i < finders.length; i++) {
            finders[i].start();
        }
        
        for (int i = 0; i < finders.length; i++) {
            try {
                finders[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        long t1 = System.currentTimeMillis();
        System.out.println("Max elm:" + max + " in: " + (t1-t0) + "ms");

    }
}
