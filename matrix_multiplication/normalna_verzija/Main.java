package normalna_verzija;
import java.util.Random;

/*
    Lab Vaj za Programiranje 3 - vzporedno programiranje
     * Druga ura
     * Casovna kompleksnost
     * Normalna verzija
*/

public class Main {

    
    public static void main(String[] args) {
        int n = 2000;
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
        RS = mnoziZaporedno(matrixA, matrixB);
        long t1 = System.currentTimeMillis();

        // cas izvajanaja
        System.out.println(t1-t0 + " ms");
        // print(RS);
    }

    public static int[][] mnoziZaporedno(int[][] A, int[][] B) {
        int [][] out = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for(int k =0; k < A.length;  k++){
                    out[i][j] = A[i][k] * B[k][j];
                }
            }
        }

        return out;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }    
            System.out.println();
        }
    }
}