package pararelna_verzija;

import java.util.Random;

/*
    Lab Vaj za Programiranje 3 - vzporedno programiranje
     * Druga ura
     * Casovna kompleksnost
     * Pararelna
*/
public class Main {

    public static void main(String[] args) {
        System.out.println("Pararelna Verzija");

        int n = 1500;
        int [][] matrixA = new int[n][n];
        int [][] matrixB = new int[n][n];

        int [][] RS = new int[n][n];
        int [][] RP = new int[n][n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = rand.nextInt(1000);
                matrixB[i][j] = rand.nextInt(1000);
            }    
        } 

        long t0 = System.currentTimeMillis();
        Worker[] workers = new Worker[n];
        for(int i = 0; i < workers.length;i++){
            workers[i] = new Worker(i, RP, matrixA, matrixB);
            workers[i].start();
        }
        for(int i = 0; i < workers.length;i++){
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long t1 = System.currentTimeMillis();

        // cas izvajanaja
        System.out.println(t1-t0 + " ms");
    }
}
