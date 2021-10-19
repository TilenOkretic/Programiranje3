import java.util.Random;

/*
    Lab Vaj za Programiranje 3 - vzporedno programiranje
     * Druga ura
     * Casovna kompleksnost
*/

public class Main {

    public static void main(String[] args) {
        int n = 100;
        int [][] matrixA = new int[n][n];
        int [][] matrixB = new int[n][n];

        int [][] RS = new int[n][n];
        int [][] RP = new int[n][n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextInt(1000);
                B[i][j] = rand.nextInt(1000);
            }    
        }

    }
}