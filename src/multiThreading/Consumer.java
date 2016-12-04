package multiThreading;


import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Callable<String> {

    AtomicInteger head = new AtomicInteger();

    @Override
    public String call(){

        while(true){
            int h  = head.getAndIncrement();
            if(MainTest.counter.get() >=0) {
                System.out.println("Client:" +Thread.currentThread().getId() + ": " + (h % MainTest.BUFFER));

                MainTest.counter.decrementAndGet();
            }else {
                head.set(MainTest.counter.get());
            }
        }

    }
}
