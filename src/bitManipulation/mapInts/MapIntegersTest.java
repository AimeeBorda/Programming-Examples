package bitManipulation.mapInts;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapIntegersTest {
    MapIntegers m;

    @Before
    public void setUp(){
        m = new MapIntegers();
    }

    @Test
    public void test(){
        assertEquals("",0, m.mapInt(5,5));
    }
}
