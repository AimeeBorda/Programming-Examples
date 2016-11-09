package MedianSortedArrays;


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
        assertEquals("Median of [1,3] and [2] should be 2", 2.0, median.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}),0.1);
    }

    @Test
    public void testMedian2() {
        assertEquals("Median of [1,2] and [3,4] should be 2.5", 2.5, median.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}),0.1);
    }

    @Test
    public void testMedian3() {
        assertEquals("Median of [] and [2] should be 2.5", 2.5, median.findMedianSortedArrays(new int[]{}, new int[]{2}),0.1);
    }

    @Test
    public void testMedian4() {
        assertEquals("Median of [3] and [] should be 2.5", 2.5, median.findMedianSortedArrays(new int[]{3}, new int[]{}),0.1);
    }

    @Test
    public void testMedian5() {
        assertEquals("Median of [] and [2,3] should be 2.5", 2.5, median.findMedianSortedArrays(new int[]{}, new int[]{2, 3}),0.1);
    }

    @Test
    public void testMedian6() {
        assertEquals("Median of [] and [] should be 0", 0, median.findMedianSortedArrays(new int[]{}, new int[]{}),0.1);
        assertEquals("Median of null and null should be 0", 0, median.findMedianSortedArrays(null, null),0.1);
    }
}
