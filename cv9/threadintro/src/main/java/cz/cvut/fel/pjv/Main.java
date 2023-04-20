package cz.cvut.fel.pjv;

public class Main {
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyRunnable(50));
        Thread th2 = new Thread(new MyRunnable(500));

        th1.start();
        th2.start();
        try{
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Hello world!");
    }
}