package Part_2_Concurrency.Class_4.SemaphoreProblems;
import java.util.concurrent.Semaphore;

public class PrintOrderSemaphore {

    private static class Foo {
        Semaphore first;
        Semaphore second;
        Semaphore third;

        public Foo() {
            first = new Semaphore(1);
            second = new Semaphore(0);
            third = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            first.acquire();
            printFirst.run();
            second.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            second.acquire();
            printSecond.run();
            third.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            third.acquire();
            printThird.run();
            first.release();
        }
    }

    public static void main(String[] args) {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start threads in a deliberately incorrect order
        t3.start();
        t2.start();
        t1.start();
    }
}
