package multiThreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


public class MainTest {

    private static final int NUM = 2;
    public static final int BUFFER = 10;

    public static AtomicInteger counter = new AtomicInteger();

    public static Semaphore s = new Semaphore(BUFFER);
    public static int[] buffer = new int[BUFFER];

    public static void main(String[] args) throws Exception {

        Producer p = new Producer();
        Consumer c = new Consumer();

        Thread[] ps = new Thread[NUM];
        Thread[] cs = new Thread[NUM];

        for(int i = 0 ; i < NUM; i++){
            ps[i] = new Thread(p);
            cs[i] = new Thread(c);

            ps[i].start();
            cs[i].start();

        }

        ps[0].join();
        cs[0].join();
        System.out.print("Dsfa");
    }
}
