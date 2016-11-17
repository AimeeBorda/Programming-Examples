package dynamicProgramming.quickSum;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuickSumTest {

    QuickSum qs;

    @Before
    public void setUp(){
        qs = new QuickSum();
    }

    @Test
    public void testQuickSum(){
        assertEquals("99999 45 returns: 4",4, qs.quickSums("99999",45));
        assertEquals("1110 3 returns: 3",3, qs.quickSums("1110",3));
        assertEquals("99999 100 returns: -1",-1, qs.quickSums("99999",100));
        assertEquals("382834 100 returns: 2",2, qs.quickSums("382834",100));
        assertEquals("9230560001 71 returns: 4",4, qs.quickSums("9230560001",71));
    }
}
