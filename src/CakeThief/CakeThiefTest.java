package CakeThief;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CakeThiefTest {

    CakeThief thief;

    @Before
    public void setUp(){
        thief = new CakeThief();
    }

    @Test
    public void testEmptyAndNull(){
        assertEquals("testing null",0, thief.maxValue(null,0));
        assertEquals("testing empty", 0, thief.maxValue(new Pair[0],0));
    }

    @Test
    public void testExample(){
        Pair<Integer,Integer>[] pairs = new Pair[]{ new Pair(7, 160), new Pair(3, 90),new Pair (2, 15)};
        assertEquals("for [(7, 160), (3, 90), (2, 15)] ,20", 555, thief.maxValue(pairs,20));
    }

    @Test
    public void testSort(){
        Pair<Integer,Integer>[] pairs = new Pair[]{ new Pair(7, 160), new Pair(3, 90),new Pair (2, 15), new Pair(5,50), new Pair(8,60)};
        thief.sortDescending(pairs,0,4);
        assertEquals("for [(7, 160), (3, 90), (2, 15)] ,20", "[(8,60), (7,160), (5,50), (3,90), (2,15)]", Arrays.toString(pairs));
    }
}
