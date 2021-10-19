
/*
    Lab Vaj za Programiranje 3 - vzporedno programiranje
     * Prva ura
*/

public class Main {

    public static void main(String[] args) {
        System.out.println();
        int n = 10;
        Thread[] threads = new Thread[n];
        for(int i = 0; i < n; i++) {
            threads[i] = new Delavec();
            threads[i].start();
        }

        for(int i = 0; i < n; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Konec");
    }
}