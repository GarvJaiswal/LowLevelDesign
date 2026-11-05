package Part_2_Concurrency.Class_3.AdderSubProblem.AdderSubCallable;

import java.util.concurrent.Callable;

public class AdderTask implements Callable<Void> {
    private Counter counter;

    public AdderTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public Void call() throws Exception{
        for(int i=1;i<=1000;i++) {
            int x = counter.getX();
            x = x + i;
            counter.setX(x);
        }
        return null;
    }
}
