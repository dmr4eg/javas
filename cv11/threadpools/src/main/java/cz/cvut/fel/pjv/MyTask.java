package cz.cvut.fel.pjv;

public class MyTask implements Runnable{
  private final int id;

  public MyTask(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    for (int cnt = 1; cnt <= 10; cnt++) {
      System.out.printf("Task id %d thread %s count %d%n", id, Thread.currentThread().getName(), cnt);
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        System.out.printf("Task id %d on thread %s INTERRUPTED%n", id, Thread.currentThread().getName());
      }
    }

  }
}
