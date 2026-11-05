package Part_2_Concurrency.Class_3.AdderSubProblem.AdderSubRunnable;

import java.util.concurrent.ExecutionException;

public class AdderSubtractorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Counter counter = new Counter(0);
        AdderTask adderTask = new AdderTask(counter);
        SubtractorTask subtractorTask = new SubtractorTask(counter);

        Thread t1 = new Thread(adderTask);
        Thread t2 = new Thread(subtractorTask);

        t1.start();
        t2.start();

        t1.join(); //waits for the thread to get complete it's execution.
        t2.join();

        System.out.println(counter.getX());

    }
}
