import java.util.*;

class PC2 {
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;
    int value = 0;
    public void producer() throws InterruptedException {
        synchronized(this) {
            while(list.size() == capacity) {
                System.out.println("List is full, producer waiting...");
                wait();
            }
            System.out.println("Producer is producing: " + value);
            list.add(value++);
            notify();
            Thread.sleep(1000); 
        }
    }
    
    public void consumer() throws InterruptedException {
        synchronized(this) {
            while(list.size() == 0) {
                System.out.println("List is empty, consumer waiting...");
                wait();
            }
            int val = list.removeFirst();
            System.out.println("Consumer is consuming: " + val);
            notify();
            Thread.sleep(1000); 
        }
    }
}

class Producer extends Thread {
    PC2 pc;
    
    public Producer(PC2 pc) {
        this.pc = pc;
    }
    
    public void run() {
        try {
            for(int i = 1; i < 10; i++) { // Produce 10 items
                pc.producer();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    PC2 pc;
    
    public Consumer(PC2 pc) {
        this.pc = pc;
    }
    
    public void run() {
        try {
            for(int i = 1; i < 10; i++) { 
                pc.consumer();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        PC2 pc = new PC2();
        Producer producer = new Producer(pc);
        Consumer consumer = new Consumer(pc);
        producer.start();
        consumer.start();
    }
}