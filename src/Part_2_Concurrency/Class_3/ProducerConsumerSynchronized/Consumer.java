package Part_2_Concurrency.Class_3.ProducerConsumerSynchronized;
import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;

    Consumer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (store) {
                if (store.size() > 0) { // C1, C4
                    System.out.println(name + " is consuming the shirt. Size of the store: " + store.size());
                    store.remove();
                }
            }
        }
    }
}