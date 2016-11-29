package multiThreading;


import java.util.concurrent.atomic.AtomicInteger;

public class Consumer implements Runnable {

    AtomicInteger head = new AtomicInteger();
    public void run(){

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
