package Part_2_Concurrency.Class_4;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;
    Semaphore producerS;
    Semaphore consumerS;

    Consumer(Queue<Object> store, int maxSize, String name, Semaphore producerS, Semaphore consumerS) {
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
                consumerS.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " is consuming the shirt. Size of the store: " + store.size());
            store.remove();
            producerS.release();
        }
    }
}