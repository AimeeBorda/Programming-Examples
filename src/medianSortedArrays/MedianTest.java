package medianSortedArrays;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianTest {

    Median median;

    @Before
    public void setUp() {
        median = new Median();
    }

    @Test
    public void testMedian1() {
        assertEquals("Median of [1,3] and [2] should be 2", 2.0, median.getMedian(new int[]{1, 3}, new int[]{2}),0.1);
    }

    @Test
    public void testMedian2() {
        assertEquals("Median of [1,2] and [3,4] should be 2.5", 2.5, median.getMedian(new int[]{1, 2}, new int[]{3, 4}),0.1);
    }

    @Test
    public void testMedian3() {
        assertEquals("Median of [] and [2] should be 2.5", 2, median.getMedian(new int[]{}, new int[]{2}),0.1);
    }

    @Test
    public void testMedian4() {
        assertEquals("Median of [3] and [] should be 2.5", 3, median.getMedian(new int[]{3}, new int[]{}),0.1);
    }

    @Test
    public void testMedian5() {
        assertEquals("Median of [] and [2,3] should be 2.5", 2.5, median.getMedian(new int[]{}, new int[]{2, 3}),0.1);
    }

    @Test
    public void testMedian6() {
        assertEquals("Median of [1,2,3,4,5] and [6,7,8,9] should be 0", 5, median.getMedian(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9}), 0.1);
        assertEquals("Median of [] and [] should be 0", 0, median.getMedian(new int[]{}, new int[]{}), 0.1);
        assertEquals("Median of [2,4,6] and [1,3,5,7,13] should be 0", 4.5, median.getMedian(new int[]{2, 4, 6}, new int[]{1, 3, 5, 7, 13}), 0.1);
        assertEquals("Median of [1,2,3,4,5] and [6,7,8,9,10] should be 0", 5.5, median.getMedian(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}), 0.1);
    }

    @Test
    public void testMedian7(){
        assertEquals("Median of [2,4,6,8,10,12] and [1,3,5,7,13] should be 0", 6, median.getMedian(new int[]{2,4,6,8,10,12}, new int[]{1,3,5,7,13}),0.1);
        assertEquals("Median of [2,4,6,8,10,12,14] and [1,3,5,7,13] should be 0", 6.0, median.getMedian(new int[]{2,4,6,8,10,12,14}, new int[]{1,3,5,7,13}),0.1);
        assertEquals("Median of [2,4] and [1,3,5,7,8,9,10,12,13,25,35,36] should be 0", 8.5, median.getMedian(new int[]{2,4}, new int[]{1,3,5,7,8,9,10,12,13,25,35,36}),0.1);
    }

    @Test
    public void testBaseCase(){
        assertEquals("Median of [] and [] should be 0", 0, median.getMedian(new int[]{}, new int[]{}),0.1);
        assertEquals("Median of [3] and [] should be 3", 3, median.getMedian(new int[]{3}, new int[]{}),0.1);
        assertEquals("Median of [] and [3] should be 3", 3, median.getMedian(new int[]{}, new int[]{3}),0.1);
        assertEquals("Median of [2] and [3] should be 3", 2.5, median.getMedian(new int[]{2}, new int[]{3}),0.1);
        assertEquals("Median of [3] and [2] should be 2.5", 2.5, median.getMedian(new int[]{3}, new int[]{2}),0.1);
        assertEquals("Median of [2,3] and [4,5] should be 2.5", 3.5, median.getMedian(new int[]{2,3}, new int[]{4,5}),0.1);
        assertEquals("Median of [4,5] and [2,3] should be 2.5", 3.5, median.getMedian(new int[]{2,3}, new int[]{4,5}),0.1);
        assertEquals("Median of [4,6] and [5] should be 2.5", 5, median.getMedian(new int[]{4,6}, new int[]{5}),0.1);
    }
}
