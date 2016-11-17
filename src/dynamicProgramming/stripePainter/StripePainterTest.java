package dynamicProgramming.stripePainter;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class StripePainterTest {

    StripePainter sp;

    @Before
    public void setUp(){
        sp = new StripePainter();
    }

    @Test
    public void testStripePainter(){
        assertEquals("BECBBDDEEBABDCADEAAEABCACBDBEECDEDEACACCBEDABEDADD -> 26",26,sp.minStrokes("BECBBDDEEBABDCADEAAEABCACBDBEECDEDEACACCBEDABEDADD"));
        assertEquals("RGBGR -> 3",3,sp.minStrokes("RGBGR"));
        assertEquals("RGRG -> 3",3,sp.minStrokes("RGRG"));
        assertEquals("ABACADA -> 4",4,sp.minStrokes("ABACADA"));
        assertEquals("AABBCCDDCCBBAABBCCDD -> 7",7,sp.minStrokes("AABBCCDDCCBBAABBCCDD"));
    }
}
