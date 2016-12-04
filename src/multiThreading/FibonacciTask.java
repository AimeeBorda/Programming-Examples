package multiThreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;


public class FibonacciTask extends RecursiveTask<Long> {

    public ConcurrentHashMap<Integer,Long> fib = new ConcurrentHashMap<>();

    private int val;

    public FibonacciTask(int val){
        fib.putIfAbsent(0, 1l);
        fib.putIfAbsent(1, 1l);
        fib.putIfAbsent(2, 2l);
        this.val = val;
    }
    @Override
    protected Long compute() {

       return fib.computeIfAbsent(val,(k) -> calculuateFib(k));

    }


    private Long calculuateFib(int v){
        FibonacciTask t1 = new FibonacciTask(v - 2);
        FibonacciTask t2 = new FibonacciTask(v - 1);

        t1.fork();
        t2.fork();
        try {
            fib.put(v,t1.get() + t2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return 0l;
    }
}
