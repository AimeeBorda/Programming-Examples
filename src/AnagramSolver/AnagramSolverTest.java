package AnagramSolver;


import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class AnagramSolverTest {

    AnagramSolver a;

    @Before
    public void setUp(){
        a = new AnagramSolver();
    }

    @Test
    public void testEmpty(){

        assertEquals("should return empty string","",a.solveAnagram("word",null));
        assertEquals("should return empty string","",a.solveAnagram("",null));
        assertEquals("should return empty string","",a.solveAnagram(null,null));
        assertEquals("should return empty string","",a.solveAnagram(null,new HashSet<String>()));
    }

    @Test
    public void testAnagram(){

        HashSet<String> dictionary = new HashSet<String>(){{add("hello"); add("world"); add("to"); add("the"); add("is"); add("we"); add("tooth"); add("door"); }};
        assertEquals("should solve anagram", "hello to the world",a.solveAnagram("elhloothtedrowl",dictionary));

    }
}
