package trees.levelOrderTraversal;

import org.junit.Before;
import org.junit.Test;
import trees.TreeNode;

import java.util.Arrays;

import static org.junit.Assert.*;


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


        TreeNode<Integer,Integer>[] list = new TreeNode[7];
        for(int i = 0;i <list.length ;i++){
             list[i] = new TreeNode(i+1,i+1);
        }

        for(int i = 0 ; i < 3 ; i++){
            list[i].left =list[2*i+1];
            list[i].right =list[2*(i+1)];

        }

        assertEquals("Empty string for empty tree","4567231",t.traversal(list[0]));
    }

    @Test
    public void testBalanced(){
        TreeNode<Integer,Integer>[] list = new TreeNode[7];
        for(int i = 0;i <list.length ;i++){
            list[i] = new TreeNode(i+1,i+1);
        }

        for(int i = 0 ; i < 3 ; i++){
            list[i].left =list[2*i+1];
            list[i].right =list[2*(i+1)];

        }

        assertTrue("tree is balanced",t.isSuperBalancedIterative(list[0]));
        assertTrue("Empty string for empty tree", t.isSuperBalancedIterative(new TreeNode(1, 1)));

        for(int i = 0 ; i < 3 ; i++){
            list[i].left =list[2*i+1];
            //list[i].right =list[2*(i+1)];

        }

        assertTrue("tree is not balanced",t.isSuperBalancedIterative(list[0]));
    }

    @Test
    public void testRootToLeaves(){
        TreeNode root = null;
        assertEquals("Empty string for empty tree","[]",Arrays.toString(t.allRootToLeavePaths(root)));


        TreeNode<Integer,Integer>[] list = new TreeNode[7];
        for(int i = 0;i <list.length ;i++){
            list[i] = new TreeNode(i+1,i+1);
        }

        for(int i = 0 ; i < 3 ; i++){
            list[i].left =list[2*i+1];
            list[i].right =list[2*(i+1)];

        }

        assertEquals("Empty string for empty tree","[124, 125, 136, 137]", Arrays.toString(t.allRootToLeavePaths(list[0])));
    }

    @Test
    public void testIsBST(){
        TreeNode root = null;
        assertTrue("empty tree is BST",  t.isBST2(root));
        assertTrue("empty tree is BST",  t.isBSTInOrder(root));


        TreeNode<Integer,Integer>[] list = new TreeNode[7];
        for(int i = 0;i <list.length ;i++){
            list[i] = new TreeNode(i+1,i+1);
        }

        list[3].left = list[1];
        list[3].right = list[5];

        list[1].left = list[0];
        list[1].right = list[2];

        list[5].left = list[4];
        list[5].right = list[6];
//        list[0].left = list[0].right = list[2].left = list[2].right = list[4].left = list[4].right = list[6].left = list[6].right = null;

        assertTrue("tree is  BST", t.isBST2(list[3]));
        assertTrue("tree is  BST", t.isBSTInOrder(list[3]));
        assertTrue("tree is  BST", t.isBSTInOrder(list[1]));
        assertTrue("tree is  BST", t.isBST2(list[1]));


    }

    @Test
    public void testTraversal(){
        TreeNode root = null;
        assertEquals("empty tree is BST", "", t.iterativeTraversal(root));
        assertEquals("empty tree is BST", "", t.iterativeTraversal(root));


        TreeNode<Integer,Integer>[] list = new TreeNode[7];
        for(int i = 0;i <list.length ;i++){
            list[i] = new TreeNode(i+1,i+1);
        }

        list[3].left = list[1];
        list[3].right = list[5];

        list[1].left = list[0];
        list[1].right = list[2];

        list[5].left = list[4];
        list[5].right = list[6];
//        list[0].left = list[0].right = list[2].left = list[2].right = list[4].left = list[4].right = list[6].left = list[6].right = null;

        assertEquals("tree is  BST","1234567", t.iterativeTraversal(list[3]));


    }
}
