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

        int [][] RS = new int[n][n]; // unused v tem primeru
        int [][] RP = new int[n][n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = rand.nextInt(1000);
                matrixB[i][j] = rand.nextInt(1000);
            }    
        } 

        // pararelna prvi nacin
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
        System.out.println("Pararelni cas 1: " + (t1-t0) + " ms");

        // pararelna drugi nacin

        // dobimo st procesorjev
        long t2 = System.currentTimeMillis();

        int threads = Runtime.getRuntime().availableProcessors();
        // "delo" radelimo na kose
        int chunk = n / threads;
        
        Banana[] bananas = new Banana[threads];
        for(int i = 0; i < threads;i++) {
            if(i==threads - 1) {
                bananas[i] = new Banana(i*chunk, n, RP, matrixA, matrixB);
            }
            bananas[i] = new Banana(i*chunk, i*chunk+chunk, RP, matrixA, matrixB);
            bananas[i].start();
        }

        for(int i = 0; i < bananas.length;i++) {
            try {
                bananas[i].join();
            } catch (Exception e) {
            }
        }

        long t3 = System.currentTimeMillis();
        // cas izvajanaja boljse verzije
        System.out.println("Pararelni cas 2: " + (t3-t2) + " ms");


        // System.out.println("Matriki sta enaki: " + isEqual(RP, RS));
    }

    // Za primirjanje RP in RS
    public static boolean isEqual(int[][] A, int[][] B) {
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(A[i][j] != B[i][j]) return false;
            }   
        }
        return true;
    }
}
