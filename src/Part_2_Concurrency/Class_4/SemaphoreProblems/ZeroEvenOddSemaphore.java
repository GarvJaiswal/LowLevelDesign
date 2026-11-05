package Part_2_Concurrency.Class_4.SemaphoreProblems;


import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOddSemaphore {

    static class ZeroEvenOdd {
        private int n;
        private Semaphore zero;
        private Semaphore odd;
        private Semaphore even;

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.zero = new Semaphore(1);
            this.odd = new Semaphore(0);
            this.even = new Semaphore(0);
        }

        public void zero(IntConsumer printNumber)
                throws InterruptedException {

            for (int i = 1; i <= this.n; i++) {
                zero.acquire();

                printNumber.accept(0);

                if (i % 2 == 1) {
                    odd.release();
                } else {
                    even.release();
                }
            }
        }

        public void odd(IntConsumer printNumber)
                throws InterruptedException {

            for (int i = 1; i <= this.n; i += 2) {
                odd.acquire();

                printNumber.accept(i);

                zero.release();
            }
        }

        public void even(IntConsumer printNumber)
                throws InterruptedException {

            for (int i = 2; i <= this.n; i += 2) {
                even.acquire();

                printNumber.accept(i);

                zero.release();
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ZeroEvenOdd obj = new ZeroEvenOdd(n);

        Thread zeroThread = new Thread(() -> {
            try {
                obj.zero(System.out::print);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                obj.odd(System.out::print);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                obj.even(System.out::print);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start threads in a mixed order
        evenThread.start();
        oddThread.start();
        zeroThread.start();

        try {
            zeroThread.join();
            oddThread.join();
            evenThread.join();
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
