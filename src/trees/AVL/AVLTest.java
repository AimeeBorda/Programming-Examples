package trees.AVL;


import org.junit.Before;
import org.junit.Test;
import trees.TreeNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AVLTest {

    AVL a;

    @Before
    public void setUp(){
        a = new AVL<Integer,Integer>();

        for (int i = 1; i < 25; i++) {
            a.insert(i, i);
        }
    }

    @Test
    public void testSetUp() {
        assertTrue("is Balanced", heightIfBalanced(a.root) > 0);
        assertEquals("in order traversal", "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24", a.traversal());
    }

    @Test
    public void testDelete() {
        a.delete(13);
        a.delete(5);
        a.insert(1, 3);
        assertTrue("is Balanced first", heightIfBalanced(a.root) > 0);
        a.delete(1);
        a.delete(6);
        a.delete(7);
        assertTrue("is Balanced second", heightIfBalanced(a.root) > 0);
        a.delete(33);
        a.delete(21);
        a.delete(24);
        a.delete(22);
        assertTrue("is Balanced third", heightIfBalanced(a.root) > 0);
        assertEquals("in order traversal", "2,3,4,8,9,10,11,12,14,15,16,17,18,19,20,23", a.traversal());

    }

    @Test
    public void testSearch(){
        assertNull("no item", a.search(25));
        assertEquals(" 23 should return 23",23, a.search(23));
    }


    private int heightIfBalanced(TreeNode node){
        if(node == null)
            return 0;
        else {
            int hl = heightIfBalanced(node.left);
            int hr = heightIfBalanced(node.right);

            if(hr - hl < -1 || hr - hl > 1) {
                System.out.println(hl+","+hr+","+node.value);
                return 0;
            }else
                return 1 + Math.max(hr,hl);
        }
    }
}
