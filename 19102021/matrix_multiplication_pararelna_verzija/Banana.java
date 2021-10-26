package pararelna_verzija;

public class Banana extends Thread {
    int start;
    int end;
    int[][] result;
    int[][] A;
    int[][] B;
    public Banana(int start, int end, int[][] result, int[][] A, int[][] B) {
        this.result = result;
        this.A = A;
        this.B = B;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = this.start; i < this.end; i++) {
            for (int j = 0; j < A.length; j++) {
                for(int k =0; k < A.length;  k++){
                    this.result[i][j] = this.A[i][k] * this.B[k][j];
                }
            }
        }
    }
}

