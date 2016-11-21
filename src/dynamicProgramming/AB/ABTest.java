package dynamicProgramming.AB;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aimeeborda on 21/11/2016.
 */
public class ABTest {

    AB ab;
    @Before
    public void setUp(){
        ab = new AB();
    }

    @Test
    public void test(){
        assertEquals("test empty","",ab.createString(0,0));
        assertEquals("test 3 2","ABB",ab.createString(3,2));
        assertEquals("test 2 0","BB",ab.createString(2,0));
        assertEquals("test 5 8","",ab.createString(5,8));
        assertEquals("test 10 12","ABBBBABBBB",ab.createString(10,12));
    }
}
