package dynamicProgramming.badNeighbours;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadNeighbourTest {

    BadNeighbour bn;
    @Before
    public void setUp(){
        bn = new BadNeighbour();
    }

    @Test
    public void test(){
        assertEquals("{ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }",16, bn.maxDonations(new int[]{ 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }));
        assertEquals("[10, 3, 2, 5, 7, 8 ]",19, bn.maxDonations(new int[]{ 10, 3, 2, 5, 7, 8 }));
        assertEquals("[11,15]",15, bn.maxDonations(new int[]{ 11, 15}));
        assertEquals("{ 7, 7, 7, 7, 7, 7, 7 }",21, bn.maxDonations(new int[]{ 7, 7, 7, 7, 7, 7, 7 }));
        assertEquals("{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }",2926, bn.maxDonations(new int[]{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }));
    }
}
