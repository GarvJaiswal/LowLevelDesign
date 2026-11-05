package Part_2_Concurrency.Class_3.AdderSubProblem.AdderSubCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AdderSubtractorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new Counter(0);
        AdderTask adderTask = new AdderTask(counter);
        SubtractorTask subtractorTask = new SubtractorTask(counter);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Void> adderHalf = executorService.submit(adderTask);
        Future<Void> subtractorHalf = executorService.submit(subtractorTask);

        adderHalf.get();
        subtractorHalf.get();

        System.out.println(counter.getX());

        executorService.shutdown();

    }
}
