import java.lang.*;
class MultiThreads {
    public static void main(String[] args) {
        Thread csThread = new Thread(new MyRunnable("CS thread"));
        Thread itThread = new Thread(new MyRunnable("IT thread"));
        csThread.start();
        itThread.start();
    }
}
class MyRunnable implements Runnable {
    private String threadName;
    private int count = 0;
    public MyRunnable(String name) {
        this.threadName = name;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                count++;
                System.out.println(threadName + " executed " + count + " times");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
    }
}
