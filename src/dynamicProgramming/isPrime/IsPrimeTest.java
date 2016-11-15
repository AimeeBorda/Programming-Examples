package dynamicProgramming.isPrime;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class IsPrimeTest {

    IsPrime p;

    @Before
    public void setUp(){
        p = new IsPrime();
    }

    @Test
    public void testIsPrimeFalse(){
        assertFalse("4 should not be prime", p.isPrime(4));
        assertFalse("18 should not be prime", p.isPrime(18));
        assertFalse("70 should not be prime", p.isPrime(70));
        assertFalse("49 should not be prime", p.isPrime(49));
        assertFalse("6 should not be prime", p.isPrime(6));
    }

    @Test
    public void testIsPrimeTrue(){
        assertTrue("5 should be prime", p.isPrime(5));
        assertTrue("23 should be prime", p.isPrime(23));
        assertTrue("71 should be prime", p.isPrime(71));
        assertTrue("97 should be prime", p.isPrime(97));
    }
}
