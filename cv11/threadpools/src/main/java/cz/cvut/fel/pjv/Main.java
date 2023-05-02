package cz.cvut.fel.pjv;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
  private static final int THREAD_COUNT = 4;
  private static final int TASK_COUNT = 7;
  public static void main(String[] args) throws ExecutionException, InterruptedException{

// 1.
//    ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);
//    for (int i = 0; i < TASK_COUNT; i++) {
//      es.execute(new MyTask(i));
//    }
//    es.shutdownNow();

    ExecutorService es = Executors.newFixedThreadPool(THREAD_COUNT);
    List<Future<Integer>> myFutures = new ArrayList<>();
    for (int i = 0; i < TASK_COUNT; i++) {
      Future myFuture = es.submit(new MyCallable(i));
      myFutures.add(myFuture);
    }
    es.shutdown();
    for (Future<Integer> f : myFutures) {
      System.out.println("RESULT:" + f.get());
    }

    System.out.println("Konec");
  }
}