import java.lang.*;
class Display {
    public /*synchronized*/ void wish(String name) { 
        System.out.print("Hello ");
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
    MyThread(Display d,String name) {
        this.d=d;
        this.name=name;
    }
    public void run() {
        d.wish(name);
    }
}
public class SyncDemo {
    public static void main(String[] args) {
        Display d = new Display();
        MyThread t1 = new MyThread(d, "Anshika");
        MyThread t2 = new MyThread(d, "Naresh");
        t1.start();
        t2.start();
    }
}
