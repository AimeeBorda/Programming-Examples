package multiThreading;


import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

    AtomicInteger tail = new AtomicInteger();

    public void run(){

        while(true) {

            int t = tail.getAndIncrement();
            if (MainTest.counter.get() < MainTest.BUFFER) {
                MainTest.buffer[t % MainTest.BUFFER] = 1;
                System.out.println("Producer:" +Thread.currentThread().getId() + ": " + t +", "+(t % MainTest.BUFFER));
                MainTest.counter.incrementAndGet();
            }else{
                tail.set(MainTest.counter.get());
            }
        }

    }


}
