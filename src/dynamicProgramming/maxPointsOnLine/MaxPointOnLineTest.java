package dynamicProgramming.maxPointsOnLine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aimeeborda on 15/11/2016.
 */
public class MaxPointOnLineTest {

    MaxPointsOnLine m;
    @Before
    public void setUp(){
        m = new MaxPointsOnLine();
    }

    @Test
    public void test1(){
        assertEquals("",0,m.method());
    }
}
