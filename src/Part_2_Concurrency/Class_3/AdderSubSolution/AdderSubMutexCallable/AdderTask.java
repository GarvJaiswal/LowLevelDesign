package Part_2_Concurrency.Class_3.AdderSubSolution.AdderSubMutexCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class AdderTask implements Callable<Void> {
    private Counter counter;
    private Lock lock;

    public AdderTask(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public Void call() throws Exception{
        for(int i=1;i<=1000;i++) {
            lock.lock();
            int x = counter.getX();
            x = x + i;
            counter.setX(x);
            lock.unlock();
        }
        return null;
    }
}
