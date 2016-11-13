package ReverseWords;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReverseWordsTest {

    ReverseWords rev;
    @Before
    public void setUp(){
        rev = new ReverseWords();
    }

    @Test
    public void testInPaceReversal(){
        assertEquals("reverse","1234567", rev.inplaceReversal("7654321"));
    }
    @Test
    public void testEmpty(){
        assertArrayEquals("Empty list", new String[]{}, rev.reverse(new String[]{}));
    }

    @Test
    public void testOneElement(){
        assertArrayEquals("Reverse of [word] -> [word]", new String[]{"word"}, rev.reverse(new String[]{"word"}));
    }

    @Test
    public void testTwoElements(){
        assertArrayEquals("Reverse of [first,word] -> [word,first]", new String[]{"word","first"}, rev.reverse(new String[]{"first","word"}));
    }

    @Test
    public void testThreeElements(){
        assertArrayEquals("Reverse of [first,word,last] -> [last,word,first]", new String[]{"last","word","first"}, rev.reverse(new String[]{"first","word","last"}));
    }

    @Test
    public void testFourElements(){
        assertArrayEquals("Reverse of [first,word,last,test] -> [test,last,word,first]", new String[]{"test","last","word","first"}, rev.reverse(new String[]{"first","word","last","test"}));
    }
}
