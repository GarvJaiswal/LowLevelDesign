package Part_2_Concurrency.Class_4.SemaphoreProblems;

import java.util.concurrent.Semaphore;

public class H2OSemaphore {

    static class H2O {
        Semaphore hydrogen = new Semaphore(2);
        Semaphore oxygen = new Semaphore(0);

        public void hydrogen(Runnable releaseHydrogen)
                throws InterruptedException {
            hydrogen.acquire();
            releaseHydrogen.run();
            oxygen.release();
        }

        public void oxygen(Runnable releaseOxygen)
                throws InterruptedException {
            oxygen.acquire(2);
            releaseOxygen.run();
            hydrogen.release(2);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String input = "HHOHHHHOOOHH";
        H2O h2o = new H2O();

        Thread[] threads = new Thread[input.length()];

        for (int i = 0; i < input.length(); i++) {
            char atom = input.charAt(i);

            if (atom == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.hydrogen(() -> System.out.print("H"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else if (atom == 'O') {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.oxygen(() -> System.out.print("O"));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            } else {
                throw new IllegalArgumentException(
                        "Invalid character: " + atom);
            }
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println();
    }
}
