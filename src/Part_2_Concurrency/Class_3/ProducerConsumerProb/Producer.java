package Part_2_Concurrency.Class_3.ProducerConsumerProb;
import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Object> store;
    private int maxSize;
    private String name;

    Producer(Queue<Object> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (store.size() < maxSize) { // P2 P5
                System.out.println(name + " is producing the shirt. Size of the store: " + store.size());
                store.add(new Object());
            }
        }
    }
}