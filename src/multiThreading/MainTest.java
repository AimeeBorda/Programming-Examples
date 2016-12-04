package multiThreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


public class MainTest {

    private static final int NUM = 2;
    public static final int BUFFER = 10;

    public static AtomicInteger counter = new AtomicInteger();

    public static Semaphore s = new Semaphore(BUFFER);
    public static int[] buffer = new int[BUFFER];


    public static void main(String[] args) throws Exception {
        AtomicInteger tail = new AtomicInteger();
        ForkJoinPool pool = new ForkJoinPool(3);

        ForkJoinTask<Long> task = pool.submit(new FibonacciTask(100));

        pool.shutdown();
        System.out.println(task.get());



    }


}
