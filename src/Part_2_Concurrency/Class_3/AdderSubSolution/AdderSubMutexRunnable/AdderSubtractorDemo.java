package Part_2_Concurrency.Class_3.AdderSubSolution.AdderSubMutexRunnable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubtractorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new Counter(0);
        Lock lock = new ReentrantLock();
        AdderTask adderTask = new AdderTask(counter,lock);
        SubtractorTask subtractorTask = new SubtractorTask(counter, lock);

        Thread t1 = new Thread(adderTask);
        Thread t2 = new Thread(subtractorTask);

        t2.start();
        t1.start();

        t1.join(); //waits for the thread to get complete it's execution.
        t2.join();

        System.out.println(counter.getX());

    }
}
