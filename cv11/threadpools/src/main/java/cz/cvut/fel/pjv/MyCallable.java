package cz.cvut.fel.pjv;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
  private final int id;

  public MyCallable(int id) {
    this.id = id;
  }

  @Override
  public Integer call() throws Exception {
    for (int cnt = 1; cnt <= 10; cnt++) {
      System.out.printf("Task id %d thread %s count %d%n", id, Thread.currentThread().getName(), cnt);
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        System.out.printf("Task id %d on thread %s INTERRUPTED%n", id, Thread.currentThread().getName());
      }
    }
    return 2 * id;
  }
}
