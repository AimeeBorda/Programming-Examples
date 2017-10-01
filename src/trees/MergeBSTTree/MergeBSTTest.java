package trees.MergeBSTTree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import trees.TreeNode;


public class MergeBSTTest {

  MergeBST<Integer,Integer> tree;

  @Before
  public void setup() {
    tree = new MergeBST<>();
  }

  @Test
  public void testEmpty(){
    assertEquals("", tree.traverse(null,null));
  }

  @Test
  public void testSingleTree(){
    TreeNode<Integer,Integer> tree1 = new TreeNode<>(new TreeNode<>(1,1), 3,3, new TreeNode<>(5,5));
    assertEquals("1 3 5", tree.traverse(tree1,null));
    assertEquals("1 3 5", tree.traverse(null,tree1));
  }
  @Test
  public void test() {
    TreeNode<Integer,Integer> tree1 = new TreeNode<>(new TreeNode<>(1,1), 3,3, new TreeNode<>(5,5));
    TreeNode<Integer,Integer> tree2 = new TreeNode<>(new TreeNode<>(2,2), 4,4, new TreeNode<>(6,6));


    assertEquals("1 2 3 4 5 6",tree.traverse(tree1, tree2));
  }


  @Test
  public void testSingle() {
    TreeNode<Integer,Integer> tree3 = new TreeNode<>(new TreeNode<>(new TreeNode<>(1,1),2, 2, null), 8,8, new TreeNode<>(10,10));

    assertEquals("1 2 8 10", tree.traverse(tree3, null));
    assertEquals("1 2 8 10", tree.traverse(null, tree3));
  }

  @Test
  public void test2() {
    TreeNode<Integer,Integer> tree3 = new TreeNode<>(new TreeNode<>(new TreeNode<>(1,1), 2, 2,null), 8, 8,new TreeNode<>(10,10));
    TreeNode<Integer,Integer> tree4 = new TreeNode<>(new TreeNode<>(new TreeNode<>(0,0), 3,3, null), 5,5, null);

    assertEquals("0 1 2 3 5 8 10", tree.traverse(tree3, tree4));
  }

  @Test
  public void test3() {
    TreeNode<Integer,Integer> tree3 = new TreeNode<>(new TreeNode<>(new TreeNode<>(0,0), 3,3, null), 5, 5,null);
    TreeNode<Integer,Integer> tree4 = new TreeNode<>(null, 5, 5,new TreeNode<>(null, 8,8, new TreeNode<>(10,10)));

    assertEquals("0 1 3 5 5 8 10", tree.traverse(tree3, tree4));
  }
}
