package cz.cvut.fel.pjv;

public class MyRunnable implements Runnable {
    private final int delay;
    private int counter = 0;

    public MyRunnable(int delay) {
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("i: %d counter: %d on thread %s%n", i, ++counter, Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
