import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.net.URL;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ChapmanPuzzleTest {

    static boolean condition = false;
    @Test
    public void testSolvableEmpty(){
        assertFalse(ChapmanPuzzle.isSolvable(null));
        assertTrue(ChapmanPuzzle.isSolvable(new int[]{}));
    }

    @Test
    public void testSolvableSingle(){
        assertFalse(condition);
        assertTrue(ChapmanPuzzle.isSolvable(new int[]{3,5}));
        assertFalse(ChapmanPuzzle.isSolvable(new int[]{5,3}));
    }

    @Test
    public void testSolvable(){
        assertTrue(ChapmanPuzzle.isSolvable(new int[]{1,2,3,5,6,7,8,4}));
        assertFalse(ChapmanPuzzle.isSolvable(new int[]{1,2,3,5,7,8,4,6}));
        assertTrue(ChapmanPuzzle.isSolvable(new int[]{1,2,3,5,7,8,6,9}));
    }

    @Test
    public void testIsSolvedFalse(){
        assertFalse(ChapmanPuzzle.isSolved(null));
        assertFalse(ChapmanPuzzle.isSolved(new int[]{8,7,6}));
        assertFalse(ChapmanPuzzle.isSolved(new int[]{3,8,9,34,15}));
    }

    @Test
    public void testIsSolvedTrue(){
        assertTrue(ChapmanPuzzle.isSolved(new int[]{}));
        assertTrue(ChapmanPuzzle.isSolved(new int[]{3}));
        assertTrue(ChapmanPuzzle.isSolved(new int[]{3,8}));
        assertTrue(ChapmanPuzzle.isSolved(new int[]{3,8,9,34,1000}));
    }

    @Test
    public void testEvenPerm(){
       assertTrue(ChapmanPuzzle.even_perm(new int[]{3,8}));
       assertTrue(ChapmanPuzzle.even_perm(new int[]{3,8,4,6}));
       assertFalse(ChapmanPuzzle.even_perm(new int[]{3,8,6,4}));
       assertFalse(ChapmanPuzzle.even_perm(null));
       assertTrue(ChapmanPuzzle.even_perm(new int[]{}));
   }


   @Test
    public void testSolve(){
        ChapmanPuzzle.solve();
   }


    static ChapmanPuzzle sdn;

    @BeforeClass
    public static void oneTimeSetUp() throws Exception {
        sdn = new ChapmanPuzzle();
    }

    @Test
    public void constructorTest() {


        try {
            URL location = ChapmanPuzzle.class.getProtectionDomain().getCodeSource().getLocation();

            File file = new File(location.getFile() +"SelfDivisibleNumbers.java");
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String str = new String(data, "UTF-8");

            assertFalse(str.contains("381654729"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
