package dynamicProgramming.storeCredit;


import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StoreCreditTest {

    StoreCredit credit;

    @Before
    public void setUp(){
        credit = new StoreCredit();
    }

    @Test
    public void testClosest(){
        assertEquals("Closest to 5 in [3,4,6,7] should be 4",4, credit.closest(new Integer[]{3,4,6,7},5) );
        assertEquals("Closest to 5 in [3,4,5,6,7] should be 5",5, credit.closest(new Integer[]{3,4,5,6,7},5) );
        assertEquals("Closest to 5 in [] should be max",Integer.MAX_VALUE, credit.closest(new Integer[]{},5) );
        assertEquals("Closest to 5 in [6] should be max", Integer.MAX_VALUE, credit.closest(new Integer[]{6}, 5));
    }

    @Test
    public void testSolveExample(){

        assertArrayEquals("C: 100 in {5,75,25} should be [25,75]", new int[]{25, 75}, credit.solveExample(100, new HashSet<Integer>() {{
            add(5);
            add(75);
            add(25);
        }}));
    }

    @Test
    public void testSolveExample2(){

        assertArrayEquals("C: 100 in {150, 24, 79, 50, 88, 345, 3} should be [50,150]", new int[]{50,150}, credit.solveExample(200, new HashSet<Integer>() {{
            add(150);
            add(24);
            add(79);
            add(50);
            add(88);
            add(345);
            add(3);
        }}));
    }

    public void testSolveExample3(){

        assertArrayEquals("C: 100 in {2 1 9 4 4 56 90 3} should be [4,4]", new int[]{4,4}, credit.solveExample(8, new HashSet<Integer>() {{
            add(2);
            add(1);
            add(9);
            add(4);
            add(4);
            add(56);
            add(90);
            add(3);
        }}));
    }
}
