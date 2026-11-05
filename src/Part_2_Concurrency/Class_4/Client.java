package Part_2_Concurrency.Class_4;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> store = new ConcurrentLinkedDeque<>();
        int maxSize = 6;
        Semaphore producerS = new Semaphore(maxSize);
        Semaphore consumerS = new Semaphore(0);

        Producer p1 = new Producer(store, maxSize, "P1", producerS, consumerS);
        Producer p2 = new Producer(store, maxSize, "P2", producerS, consumerS);
        Producer p3 = new Producer(store, maxSize, "P3", producerS, consumerS);
        Producer p4 = new Producer(store, maxSize, "P4", producerS, consumerS);
        Producer p5 = new Producer(store, maxSize, "P5", producerS, consumerS);
        Producer p6 = new Producer(store, maxSize, "P6", producerS, consumerS);


        Consumer c1 = new Consumer(store, maxSize, "C1", producerS, consumerS);
        Consumer c2 = new Consumer(store, maxSize, "C2", producerS, consumerS);
        Consumer c3 = new Consumer(store, maxSize, "C3", producerS, consumerS);
        Consumer c4 = new Consumer(store, maxSize, "C4", producerS, consumerS);
        Consumer c5 = new Consumer(store, maxSize, "C5", producerS, consumerS);

        Thread t1 = new Thread(p1);
        t1.start();

        Thread t2 = new Thread(p2);
        t2.start();

        Thread t3 = new Thread(p3);
        t3.start();

        Thread t4 = new Thread(p4);
        t4.start();

        Thread t5 = new Thread(p5);
        t5.start();

        Thread t6 = new Thread(p6);
        t6.start();

        Thread t7 = new Thread(c1);
        t7.start();

        Thread t8 = new Thread(c2);
        t8.start();

        Thread t9 = new Thread(c3);
        t9.start();

        Thread t10 = new Thread(c4);
        t10.start();

        Thread t11 = new Thread(c5);
        t11.start();
    }
}