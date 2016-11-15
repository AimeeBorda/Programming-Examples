package dynamicProgramming.maxCoinBalloonBurst;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MaxCoinTest {

    MaxCoin coin;
    @Before
    public void setUp(){
        coin  = new MaxCoin();
    }

    @Test
    public void test1(){
        assertEquals("3,1,5,8 -> 167", 167,coin.maxCoins(new int[]{3,1,5,8}));
    }

    @Test
    public void test2(){
//        assertEquals("smallest of [3,1,5,8]",  10,coin.getSmallest(10, new int[]{3, 1, 5, 8}, 0, 0,0));
    }

    @Test
    public void test3(){
//        assertEquals("smallest of [3,1,5,8]",  1,coin.getSmallest(10,new int[]{3,1,5,8},1,0,0));
    }

    @Test
    public void test4(){
//        assertEquals("smallest of [3,1,5,8]",  3,coin.getSmallest(10,new int[]{3,1,5,8},0,2,0));
    }

    @Test
    public void test5(){
        //21 64 76 97 9 60
        assertEquals("[9,76,64,21,9 7,60]",  1086136,coin.maxCoins(new int[]{9, 76, 64, 21, 97, 60}));
        assertEquals("{8, 5, 6, 9, 3, 0, 2, 4, 1, 7}",1652,coin.maxCoins(new int[]{8, 5, 6, 9, 3, 0, 2, 4, 1, 7}));
        assertEquals("{ 1, 2, 3, 4, 5, 6, 7, 8, 9}",1530,coin.maxCoins(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertEquals("[5,2,3,4,1,9,10]  ",819,coin.maxCoins(new int[]{5,2,3,4,1,9,10}));
    }
}
