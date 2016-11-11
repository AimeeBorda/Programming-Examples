package LevelOrderTreeTraversal;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class TraversalTest {

    Traversal t;
    @Before
    public void setUp(){
        t =new Traversal();
    }

    @Test
    public void test1(){
        TreeNode root = null;
        assertEquals("Empty string for empty tree","",t.traversal(root));


        TreeNode[] list = new TreeNode[7];
        for(int i = 0;i <list.length ;i++){
             list[i] = new TreeNode(i+1,null, null);
        }

        for(int i = 0 ; i < 3 ; i++){
            list[i].left =list[2*i+1];
            list[i].right =list[2*(i+1)];

        }

        assertEquals("Empty string for empty tree","4567231",t.traversal(list[0]));
    }

    @Test
    public void testRootToLeaves(){
        TreeNode root = null;
        assertEquals("Empty string for empty tree","[]",Arrays.toString(t.allRootToLeavePaths(root)));


        TreeNode[] list = new TreeNode[7];
        for(int i = 0;i <list.length ;i++){
            list[i] = new TreeNode(i+1,null, null);
        }

        for(int i = 0 ; i < 3 ; i++){
            list[i].left =list[2*i+1];
            list[i].right =list[2*(i+1)];

        }

        assertEquals("Empty string for empty tree","[124, 125, 136, 137]", Arrays.toString(t.allRootToLeavePaths(list[0])));
    }
}
