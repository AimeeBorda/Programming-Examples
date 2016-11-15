package bitManipulation.mapInts;


import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class MapIntegersTest {
    MapIntegers m;

    @Before
    public void setUp(){
        m = new MapIntegers();
    }

    @Test
    public void testNumberOfOnes() {

        assertEquals("number of 1 in 5 is 2", 2, m.countSetNaive(5));
        assertEquals("number of 1 in 8 is 1", 1, m.countSetNaive(8));
        assertEquals("number of 1 in 2 is 1", 1, m.countSetNaive(2));
        assertEquals("number of 1 in 1 is 1", 1, m.countSetNaive(1));
        assertEquals("number of 1 in 0 is 0", 0, m.countSetNaive(0));
        assertEquals("number of 1 in 2 is 2", 2, m.countSetNaive(3));
        assertEquals("number of 1 in 127 is 7", BigInteger.valueOf(127).bitCount(), m.countSetNaive(127));
    }



    @Test
    public void testDifferentSigns(){
        assertTrue("5 and -3", m.diffSign(5,-3));
        assertTrue("5 and -3", m.diffSign(-3,5));
        assertTrue("max and min", m.diffSign(Integer.MAX_VALUE, Integer.MIN_VALUE));
        assertFalse("0 and 0", m.diffSign(0, 0));
        assertFalse("-1 and -2", m.diffSign(-1, -2));
        assertTrue("-1 and 1", m.diffSign(-1, 1));
    }

    @Test
    public void testMax(){
        assertEquals("5 and 4",5 , m.max(5,4));
        assertEquals("5 and 4",5 , m.max(4,5));
        assertEquals("5 and 4",6 , m.max(4,6));
        assertEquals("5 and 4",6 , m.max(6,4));
        assertEquals("5 and 4",7 , m.max(7,3));
        assertEquals("5 and 4",7 , m.max(3,7));
        assertEquals("4 and 4",4 , m.max(4,4));
        assertEquals("-4 and 4",4 , m.max(-4,4));
        assertEquals("-4 and 4",4 , m.max(4,-4));
        assertEquals("-0 and 0",0 , m.max(-0,0));
        assertEquals("-1 and 1",1 , m.max(-1,1));
        assertEquals("2 and 4",4 , m.max(2,4));
        assertEquals("2 and 4",4 , m.max(4,2));
        assertEquals("min and max",Integer.MAX_VALUE , m.max(Integer.MIN_VALUE,Integer.MAX_VALUE));
        assertEquals("min and max",Integer.MAX_VALUE , m.max(Integer.MAX_VALUE,Integer.MIN_VALUE));
    }

    @Test
    public void testNumberOfOnesNeg(){
        assertEquals("number of 1 in -1 ",32-BigInteger.valueOf(-1).bitCount(), m.countSetNaive(-1));
        assertEquals("number of 1 in -2 ", 32- BigInteger.valueOf(-2).bitCount(), m.countSetNaive(-2));
        assertEquals("number of 1 in -3 ", 32- BigInteger.valueOf(-3).bitCount(), m.countSetNaive(-3));
        assertEquals("number of 1 in -4 ", 32- BigInteger.valueOf(-4).bitCount(), m.countSetNaive(-4));
        assertEquals("number of 1 in -5 ", 32- BigInteger.valueOf(-5).bitCount(), m.countSetNaive(-5));
        assertEquals("number of 1 in -6 ", 32- BigInteger.valueOf(-6).bitCount(), m.countSetNaive(-6));
        assertEquals("number of 1 in -7 ", 32- BigInteger.valueOf(-7).bitCount(), m.countSetNaive(-7));
        assertEquals("number of 1 in -7 ", 32- BigInteger.valueOf(-8).bitCount(), m.countSetNaive(-8));
        assertEquals("number of 1 in -7 ", 32- BigInteger.valueOf(-8).bitCount(), m.countSetNaive(-8));
        assertEquals("number of 1 in -127 ", 32- BigInteger.valueOf(-127).bitCount(), m.countSetNaive(-127));
    }

    @Test
    public void testIsNegative(){
        assertTrue("-5",  m.isNegative(-5));
        assertFalse("5", m.isNegative(5));
        assertFalse("1", m.isNegative(1));
        assertTrue("-1", m.isNegative(-1));
        assertFalse("0", m.isNegative(0));
        assertFalse("8", m.isNegative(8));
        assertFalse("Max", m.isNegative(Integer.MAX_VALUE));
        assertTrue("Min", m.isNegative(Integer.MIN_VALUE));
    }

    @Test
    public void testAbsoluteValue(){
        assertEquals("-5",5, m.absValue(-5));
        assertEquals("5",5, m.absValue(5));
        assertEquals("1",1, m.absValue(1));
        assertEquals("-1",1, m.absValue(-1));
        assertEquals("0", 0, m.absValue(0));
        assertEquals("8",8,  m.absValue(8));
        assertEquals("Max",Integer.MAX_VALUE, m.absValue(Integer.MAX_VALUE));
        assertThat("Min", m.absValue(Integer.MIN_VALUE), lessThan(0));
    }

    @Test
    public void testPowerOf2(){
        assertFalse("0", m.isPowerOf2(0));
        assertTrue("1", m.isPowerOf2(1));
        assertTrue("2", m.isPowerOf2(2));
        assertFalse("3", m.isPowerOf2(3));
        assertTrue("4", m.isPowerOf2(4));
        assertFalse("5", m.isPowerOf2(5));
        assertFalse("max", m.isPowerOf2(Integer.MAX_VALUE));
        assertTrue("-2", m.isPowerOf2(-2));
        assertTrue("-4", m.isPowerOf2(-4));
        assertFalse("-3", m.isPowerOf2(-3));
        assertTrue("-1", m.isPowerOf2(-1));
//        assertFalse("min should be false", m.isPowerOf2(Integer.MIN_VALUE));
    }


    @Test
    public void testExtendingNumber(){
        assertEquals("6 of len 3 -> len 6",62, m.extendNum(6,3,6));
        assertEquals("0 of len 2 -> len 4",0, m.extendNum(0,2,4));
        assertEquals("6 of len 4 -> len 5",6, m.extendNum(6,4,6));
    }

    @Test
    public void testConditionalMask(){
        assertEquals("0110 mask 10000 true -> 10110",22, m.condClearOrSet(6,16,true));
        assertEquals("0110 mask 10000 false -> 10110",6, m.condClearOrSet(6,16,false));
        assertEquals("0110 mask 11 true -> 0111",7, m.condClearOrSet(6,3,true));
        assertEquals("0110 mask 11 false -> 0100",4, m.condClearOrSet(6, 3, false));
    }

    @Test
    public void testMaskedMerge(){
        assertEquals("merge 682 and 341 with 682 ",0, m.merge(682,341,682));
        assertEquals("merge 682 and 341 with 682 ",682|341, m.merge(682, 341, 341));

    }

    @Test
    public void testLSB(){
        assertEquals("lsb 4 ",4, m.lsb(4,32));
        assertEquals("lsb ",32, m.lsb(35,32));

    }
}
