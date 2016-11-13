package MaxCoinsFromPot;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxCoinsFromPotTest {

    MaxCoinsFromPot pot;
    @Before
    public void setUp(){
        pot = new MaxCoinsFromPot();
    }

    @Test
    public void test1(){
        assertEquals("for empty list",0,pot.choosePots(new int[]{}));
        assertEquals("for null",0,pot.choosePots(null));
        assertEquals("for singleton list",2,pot.choosePots(new int[]{2}));
        assertEquals("for 2-element list",3,pot.choosePots(new int[]{2,3}));
        assertEquals("for 4-element list",8,pot.choosePots(new int[]{2,3,4,5}));
        assertEquals("for 10's list",105,pot.choosePots(new int[]{10, 100, 10, 5}));
        assertEquals("for another list",14,pot.choosePots(new int[]{8 ,7, 4, 6}));
    }
}
