package sortingByFrequency;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SortingByFrequencyTest {

    SortingByFrequency freq;

    @Before
    public void setUp(){
        freq = new SortingByFrequency();
    }

    @Test
    public void testIncrementLetter(){
        assertEquals("test -> ttse", "ttse",freq.createString("test"));
    }

    @Test
    public void testIncrementLetter2(){
        assertEquals("cccaaa -> aaaccc", "aaaccc",freq.createString("cccaaa"));
    }

    @Test
    public void testIncrementLetter3(){
        assertEquals("Aabb -> bbAa", "bbAa",freq.createString("Aabb"));
    }

    @Test
    public void testIncrementLetter4(){
        assertEquals("'' -> ''", "",freq.createString(""));
    }

    @Test
    public void testIncrementLetter5(){
        assertNull("null should return null", freq.createString(null));
    }
}
