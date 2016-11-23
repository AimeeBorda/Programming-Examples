package dynamicProgramming.roadsRecognition;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoadRecognitionTest {

    RoadRecognition rr;
    @Before
    public void setUp(){
        rr = new RoadRecognition();
    }

    @Test
    public void test(){
        assertEquals("test empty",0, rr.minDaysCount(new String[]{}));
        assertEquals("test \"010\", \"101\", \"010\"",1, rr.minDaysCount(new String[]{"010", "101", "010"}));
        assertEquals("test \"0111\", \"1000\", \"1000\", \"1000\"",3, rr.minDaysCount(new String[]{"0111", "1000", "1000", "1000"}));
        assertEquals("test \"01010\", \"10100\", \"01000\", \"10001\", \"00010\"",1, rr.minDaysCount(new String[]{"01010", "10100", "01000", "10001", "00010"}));
        assertEquals("test \"0100100\", \"1011000\", \"0100000\", \"0100000\", \"1000011\", \"0000100\", \"0000100\"",5, rr.minDaysCount(new String[]{"0100100", "1011000", "0100000", "0100000", "1000011", "0000100", "0000100"}));
        assertEquals("test \"011111\", \"100000\", \"100000\", \"100000\", \"100000\", \"100000\"",7, rr.minDaysCount(new String[]{"011111", "100000", "100000", "100000", "100000", "100000"}));
    }
}
