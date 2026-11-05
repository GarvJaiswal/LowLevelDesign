package Part_2_Concurrency.Class_4;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;
    Semaphore producerS;
    Semaphore consumerS;

    Producer(Queue<Object> store, int maxSize, String name, Semaphore producerS, Semaphore consumerS) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.producerS = producerS;
        this.consumerS = consumerS;
    }

    @Override
    public void run() {
        while (true) {
            try {
                producerS.acquire(); // if producerS > 0
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " is producing the shirt. Size of the store: " + store.size());
            store.add(new Object());
            consumerS.release(); // Notify the consumer.
        }
    }
}