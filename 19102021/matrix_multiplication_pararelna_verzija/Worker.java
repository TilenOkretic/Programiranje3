package pararelna_verzija;

public class Worker extends Thread {

    int row_i;
    int[][] result;
    int[][] A;
    int[][] B;
    public Worker(int row_i, int[][] result, int[][] A, int[][] B) {
        this.row_i = row_i;
        this.result = result;
        this.A = A;
        this.B = B;
    }

    @Override
    public void run() {
            for (int j = 0; j < this.B.length; j++) {
                for(int k =0; k < A.length;  k++){
                    this.result[this.row_i][j] = this.A[this.row_i][k] * this.B[k][j];
                }
            }
    }
}
