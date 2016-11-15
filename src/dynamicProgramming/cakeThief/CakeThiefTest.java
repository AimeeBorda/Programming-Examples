package dynamicProgramming.cakeThief;

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
        assertEquals("testing null",0, thief.dynamicProg(null, 0));
        assertEquals("testing empty", 0, thief.dynamicProg(new Pair[0], 0));
    }

    @Test
    public void testExample(){
        Pair<Integer,Integer>[] pairs = new Pair[]{ new Pair(7, 160), new Pair(3, 90),new Pair (2, 15)};
        assertEquals("for [(7, 160), (3, 90), (2, 15)] ,20", 555, thief.dynamicProg(pairs, 20));
    }

    @Test
    public void testSort(){
        Pair<Integer,Integer>[] pairs = new Pair[]{ new Pair(7, 160), new Pair(3, 90),new Pair (2, 15), new Pair(5,50), new Pair(8,60)};
        thief.sort(pairs, 0, 4);
        assertEquals("for [(7, 160), (3, 90), (2, 15)] ,20", "[(2,15), (3,90), (5,50), (7,160), (8,60)]", Arrays.toString(pairs));
    }
}
