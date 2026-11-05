package Part_2_Concurrency.Class_3.AdderSubProblem.AdderSubCallable;

import java.util.concurrent.Callable;

public class SubtractorTask implements Callable<Void> {
    private Counter counter;

    public SubtractorTask(Counter counter) {
        this.counter = counter;
    }

    public Void call() throws Exception{
        for(int i=1;i<=1000;i++){
            int x = counter.getX();
            x = x - i;
            counter.setX(x);
        }
        return null;
    }
}
