package Part_2_Concurrency.Class_3.AdderSubSolution.AdderSubMutexCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubtractorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new Counter(0);
        Lock lock = new ReentrantLock();
        AdderTask adderTask = new AdderTask(counter, lock);
        SubtractorTask subtractorTask = new SubtractorTask(counter, lock);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Void> adderHalf = executorService.submit(adderTask);
        Future<Void> subtractorHalf = executorService.submit(subtractorTask);

        adderHalf.get();
        subtractorHalf.get();

        System.out.println(counter.getX());

        executorService.shutdown();

    }
}
