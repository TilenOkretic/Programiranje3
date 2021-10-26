public class Finder extends Thread {
    int start;
    int end;
    int[] arr;

    public Finder(int s, int e, int[] arr) {
        this.start = s;
        this.end = e;
        this.arr = arr;
    }
    
    @Override
    public void run() {
        for (int i = this.start; i < this.end; i++) {
            if(Max.max < this.arr[i]) {
                Max.max = this.arr[i];
            }
        }
    }
}
