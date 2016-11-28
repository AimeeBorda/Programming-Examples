package dynamicProgramming.polygonSet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by aimeeborda on 28/11/2016.
 */
public class PolygonSetTest {

    PolygonSet p;

    @Before
    public  void setUp(){
        p = new PolygonSet();
    }

    @Test
    public void test(){
        assertEquals("", 2 , p.count(new int[]{1,2,3,4}));
        assertEquals("", 968 , p.count(new int[]{90,91,92,93,94,95,96,97,98,99}));
        assertEquals("", 402 , p.count(new int[]{2,5,8,7,4,3,9,1,6}));
        assertEquals("", 838 , p.count(new int[]{11,12,13,14,15,91,92,93,94,95}));
        assertEquals("", 402 , p.count(new int[]{1,2,3,4,5,6,7,8,9,100}));
    }

    @Test
    public void testIsPolygon(){
        assertFalse(p.formPolygon(new int[]{1,2,3},0,2));
        assertTrue(p.formPolygon(new int[]{4,2,3},0,2));
        assertTrue(p.formPolygon(new int[]{1,4,2,3},0,3));
    }
}
