package Part_2_Concurrency.Class_3.AdderSubProblem.AdderSubRunnable;

public class AdderTask implements Runnable {
    private Counter counter;

    public AdderTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i=1;i<=1000;i++) {
            int x = counter.getX();
            x = x + i;
            counter.setX(x);
        }
    }
}
