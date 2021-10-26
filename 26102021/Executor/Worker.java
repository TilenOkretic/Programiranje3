public class Worker implements Runnable{
    private String command;

    public Worker(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Starting: " + command);
        System.out.println(Thread.currentThread().getName() + " end ");
    }

    private void doMath() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}