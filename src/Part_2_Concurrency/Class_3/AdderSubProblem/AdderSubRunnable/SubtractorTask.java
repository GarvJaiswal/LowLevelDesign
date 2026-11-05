package Part_2_Concurrency.Class_3.AdderSubProblem.AdderSubRunnable;

public class SubtractorTask implements Runnable {
    private Counter counter;

    public SubtractorTask(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for(int i=1;i<=1000;i++){
            int x = counter.getX();
            x = x - i;
            counter.setX(x);
        }
    }
}
