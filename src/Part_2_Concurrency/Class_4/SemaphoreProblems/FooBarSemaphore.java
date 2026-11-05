package Part_2_Concurrency.Class_4.SemaphoreProblems;


import java.util.concurrent.Semaphore;

public class FooBarSemaphore {

    static class FooBar {
        private int n;
        Semaphore foo;
        Semaphore bar;

        public FooBar(int n) {
            this.n = n;
            foo = new Semaphore(1);
            bar = new Semaphore(0);
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo.acquire();

                // Prints "foo"
                printFoo.run();

                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                bar.acquire();

                // Prints "bar"
                printBar.run();

                foo.release();
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        FooBar fooBar = new FooBar(n);

        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Start bar first to demonstrate semaphore coordination
        t2.start();
        t1.start();

        try {
            t1.join();
            t2.join();
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
