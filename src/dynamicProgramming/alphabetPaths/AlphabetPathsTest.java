package dynamicProgramming.alphabetPaths;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AlphabetPathsTest {

    AlphabetPaths ap;
    @Before
    public void setUp(){
        ap = new AlphabetPaths();
    }

    @Test
    public void test(){
        assertEquals("{ABCDEF., V....Z.,T....H.,S....I.,R....X.,KLMNOPQ}",4l,ap.count(new String[]{"ABCDEF.","V....Z.","T....H.","S....I.","R....X.","KLMNOPQ"}));
        assertEquals("{ABCDEFZHIXKLMNOPQRST, ...................V}",2l,ap.count(new String[]{"ABCDEFZHIXKLMNOPQRST","...................V"}));
        assertEquals("test empty",0l,ap.count(new String[]{}));
        assertEquals("{.................VT., ....................,ABCDEFZHIXKLMNOPQRS.,..................S.,.................VT.}",0l,ap.count(new String[]{".................VT.", "....................","ABCDEFZHIXKLMNOPQRS.","..................S.",".................VT."}));
        assertEquals("{TBCDE.PQRSA, FZHIXKLMNOV}",50l,ap.count(new String[]{"TBCDE.PQRSA","FZHIXKLMNOV"}));
    }


}
