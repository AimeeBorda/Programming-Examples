package dynamicProgramming.duplicates;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicatesTest {

    Duplicates d ;
    @Before
    public void setUp(){
        d =new Duplicates();
    }


    @Test
    public void test(){
        assertEquals("no-dynamicProgramming.duplicates in an empty list", -1,d.findDuplicate(new int[0]));
        assertEquals("no-dynamicProgramming.duplicates in null", -1,d.findDuplicate(null));

        assertEquals("no-dynamicProgramming.duplicates", -1,d.findDuplicate(new int[]{1,2,3,4,5}));
        assertEquals("dynamicProgramming/duplicates ", 2,d.findDuplicate(new int[]{1,2,3,2,5}));
        assertEquals("multiple dynamicProgramming.duplicates ", 2,d.findDuplicate(new int[]{1,2,3,2,3}));
    }
}
