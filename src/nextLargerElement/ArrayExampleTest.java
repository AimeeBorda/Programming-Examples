package nextLargerElement;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ArrayExampleTest {
    ArrayExample ex;

    @Before
    public void setUp(){
        ex = new ArrayExample();
    }

    @Test
    public void test1(){
        int[] res = ex.arrayEx(new int[]{1, 2, 3, 4, 5});
        assertEquals("sorted list ASC","[1, 1, 1, 1, -1]", Arrays.toString(res));

        res = ex.arrayEx(new int[]{5,4,3,2,1});
        assertEquals("sorted list DESC","[-1, -1, -1, -1, -1]", Arrays.toString(res));
    }

    @Test
    public void test2(){
        int[] res = ex.arrayEx(new int[]{});
        assertEquals("empty list","[]", Arrays.toString(res));

        res = ex.arrayEx(new int[]{5,4,7,2,10, 5, 3, 8, 33, 15, 18, 20});
        assertEquals(" list ","[2, 1, 2, 1, 4, 2, 1, 1, -1, 1, 1, -1]", Arrays.toString(res));
    }
}
