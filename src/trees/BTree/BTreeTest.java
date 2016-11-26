package trees.BTree;

import org.junit.Before;
import org.junit.Test;


public class BTreeTest {

    BTree<Integer> bt;

    @Before
    public void setUp(){
        bt = new BTree<>();
    }

    @Test
    public void testBTree(){
//        for(int i = 1 ; i <= 9; i++)
//                bt.insert(i);
//
//        assertEquals("test random property","1,2,3,4,5,6,7,8,9",bt.traversal());

        bt.getPixelColorsInCircle(3,3,2);
    }

}
