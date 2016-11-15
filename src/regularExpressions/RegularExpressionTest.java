package regularExpressions;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RegularExpressionTest {

    RegularExpressions r;
    @Before
    public void setUp(){
        r = new RegularExpressions();
    }

    @Test
    public void testExtractNumbers(){
        assertTrue("should be empty", r.extractNumbers("").isEmpty());
        assertTrue("should be empty", r.extractNumbers("hello world").isEmpty());
        assertEquals("should contain 35","[35]", Arrays.toString(r.extractNumbers("hello35 world").toArray()));
        assertEquals("should contain 35", "[35, 24]", Arrays.toString(r.extractNumbers("hello35 24 world").toArray()));
    }

    @Test
    public void testSplitNewLines(){
        assertEquals("should be empty","[hello world]",Arrays.toString(r.splitNewLine("hello world")));
        assertEquals("should be empty","[hello world, new line, , next line]",Arrays.toString(r.splitNewLine("hello world\nnew line\n\nnext line")));
    }

    @Test
    public void testLang(){
        assertTrue("empty string",r.langN(""));
        assertFalse("a",r.langN("a"));
        assertTrue("ab",r.langN("ab"));
        assertFalse("aabbb",r.langN("aabbb"));
        assertTrue("aaabbb",r.langN("aaabbb"));
        assertFalse("aaabbb",r.langN("aaacbbb"));
    }

    @Test
    public void testSpaces(){
        assertEquals("should be the same","hello world ",r.deleteExtraAndLeadingSpacesOnly("hello world "));
        assertEquals("should remove leading space","hello world ",r.deleteExtraAndLeadingSpacesOnly("   hello   world "));
        assertEquals("should remove leading space","hello world dd  ",r.deleteExtraAndLeadingSpacesOnly("   hello   world   dd  "));
    }
}
