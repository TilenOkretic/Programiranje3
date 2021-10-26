import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    Lab Vaj za Programiranje 3 - vzporedno programiranje
     * Tretja ura
     * Template za projekt
     * Thread pull
*/
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        int tasks = 20;

        for(int i = 0; i < tasks; i++) {
            executorService.execute(new Worker("" + i));
        }

        executorService.shutdown();
        // Z tem while cakamo d se executor sevice zakljuci
        while(!executorService.isTerminated()) {
        }
        System.out.println("End!");
    }
}
