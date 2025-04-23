class Display {
    public synchronized void wish(String name) {
        System.out.print("Hello from " + Thread.currentThread().getName() + ": ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println(name);
    }
}

class MyThread extends Thread {
    Display d;
    String name;

    MyThread(Display d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.wish(name);
    }
}

public class Sync {
    public static void main(String[] args) {
        Display d = new Display();

        MyThread t1 = new MyThread(d, "Anshika ");
        MyThread t2 = new MyThread(d, "Neha ");

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}
