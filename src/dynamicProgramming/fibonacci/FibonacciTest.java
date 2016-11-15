package dynamicProgramming.fibonacci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    Fibonacci f;
    @Before
    public void setUp(){
        f = new Fibonacci();
    }

    @Test
    public void test(){
        assertEquals("fib 1", 1, f.fib(1));
        assertEquals("fib 2", 1, f.fib(2));
        assertEquals("fib 3", 2, f.fib(3));
        assertEquals("fib 5", 5, f.fib(5));
        assertEquals("fib 12", 144, f.fib(12));
    }
}
