package Part_2_Concurrency.Class_3.AdderSubSolution.AdderSubMutexRunnable;
import java.util.concurrent.locks.Lock;

public class SubtractorTask implements Runnable {
    private Counter counter;
    private Lock lock;

    public SubtractorTask(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    public void run(){
        for(int i=1;i<=1000;i++){
            lock.lock();
            int x = counter.getX();
            x = x - i;
            counter.setX(x);
            lock.unlock();
        }
    }
}
