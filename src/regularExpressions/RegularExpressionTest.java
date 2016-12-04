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
    public void testDate(){
        assertTrue(r.matchDate("1979-12-31 23:59:59.33"));
        assertFalse(r.matchDate("0979-12-31 23:59:59.33"));
    }
    @Test
    public void testSplitNewLines(){
        assertEquals("should be empty","[hello world]",Arrays.toString(r.splitNewLine("hello world")));
        assertEquals("should be empty","[hello world, new line, , next line]",Arrays.toString(r.splitNewLine("hello world\nnew line\n\nnext line")));
    }

    @Test
    public void testLang(){
        assertTrue("empty string",r.langN(""));
        assertTrue("true for ab",r.langN("ab"));
        assertTrue("true for aabb",r.langN("aabb"));
        assertTrue("true for aaabbb",r.langN("aaabbb"));

        assertFalse("false for aabbb",r.langN("aabbb"));
        assertFalse("false for a",r.langN("a"));
        assertFalse("false for aaabbb",r.langN("aaacbbb"));
    }

    @Test
    public void testSpaces(){
        assertEquals("should be the same","hello world ",r.deleteExtraAndLeadingSpacesOnly("hello world "));
        assertEquals("should remove leading space","hello world  ",r.deleteExtraAndLeadingSpacesOnly("   hello   world  "));
        assertEquals("should remove leading space","hello world dd  ",r.deleteExtraAndLeadingSpacesOnly("   hello   world   dd  "));
    }

    @Test
    public void testIsNumber(){
        assertTrue("0",r.isNumber("0"));
        assertTrue("1.1",r.isNumber("1.1"));
        assertTrue(".1",r.isNumber(".1"));
        assertTrue(".15",r.isNumber(".15"));
        assertFalse("1.",r.isNumber("1."));
        assertFalse("31.",r.isNumber("31."));
        assertTrue(".5e5",r.isNumber(".5e5"));
        assertTrue("35.5e5",r.isNumber("35.5e5"));
        assertTrue("35e5",r.isNumber("35e5"));
        assertFalse("35a5",r.isNumber("35a5"));
        assertFalse("35.e5",r.isNumber("35.e5"));
        assertFalse("e5",r.isNumber("e5"));
        assertFalse(".e5",r.isNumber(".e5"));
        assertFalse("35e",r.isNumber("35e"));

    }

    @Test
    public void testIsPrime(){
        assertTrue("2", r.isPrime(2));
        assertTrue("23", r.isPrime(23));
        assertFalse("24", r.isPrime(24));
        assertFalse("25", r.isPrime(24));
        assertFalse("27", r.isPrime(24));
    }

    @Test
    public void testCommaSeparation(){
        assertEquals("hello,world",2,r.commaSeparated("hello,world").length);
        assertEquals("[hello,\"world,test\"]",2,r.commaSeparated("hello,\"world,test\"").length);
        assertEquals("[hello,\"world,test\",goodbye]",3,r.commaSeparated("hello,\"world,test\",goodbye").length);
        assertEquals("[hello,\"world,test\",\"test,another\"]",3,r.commaSeparated("hello,\"world,test\",\"test,another\"").length);
    }


    @Test
    public void testMatchingBrackets(){
        assertTrue("has matching", r.hasMatchingParanthesis(""));
        assertTrue("has matching", r.hasMatchingParanthesis("()"));
        assertFalse("has matching", r.hasMatchingParanthesis("(()"));
        assertTrue("has matching", r.hasMatchingParanthesis("(C+D) (A + B)"));
        assertFalse("has matching", r.hasMatchingParanthesis("((C+D) (A + B))("));
        assertFalse("has matching", r.hasMatchingParanthesis("(((C+D) + E) (A + B)"));
        assertFalse("has matching", r.hasMatchingParanthesis("(()))("));
    }
}
