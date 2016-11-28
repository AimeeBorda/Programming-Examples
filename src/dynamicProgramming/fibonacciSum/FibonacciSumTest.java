package dynamicProgramming.fibonacciSum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FibonacciSumTest {

    FibonacciSum b;
    @Before
    public void setUp(){
        b = new FibonacciSum();
    }

    @Test
    public void test(){
        assertEquals("fib 1",1,b.howMany(1));
        assertEquals("fib 7",2,b.howMany(7));
        assertEquals("fib 70",3,b.howMany(70));
        assertEquals("fib 107",3,b.howMany(107));
        assertEquals("fib 144",1,b.howMany(144));
    }
}
