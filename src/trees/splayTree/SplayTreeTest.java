package trees.splayTree;


import org.junit.Test;
import trees.TreeNode;

import static org.junit.Assert.*;

public class SplayTreeTest {

    @Test
    public void testIsEmpty(){
        SplayTree<Integer, Integer> tree = new SplayTree<>();

        assertTrue(tree.isEmpty());

        tree.insert(5,5);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void testInsert(){
        SplayTree<Integer, Integer> tree = new SplayTree<>();

        tree.insert(5,5);
        assertEquals("5 should be at the top", (Integer)5,tree.getRoot());

        tree.insert(6,6);
        assertEquals("6 should be at the top", (Integer)6, tree.getRoot());

        tree.insert(7,7);
        assertEquals("7 should be at the top",(Integer)7, tree.getRoot());
    }

    @Test
    public void testDelete(){
        SplayTree<Integer, Integer> tree = new SplayTree<>();
        tree.insert(5,5);
        tree.insert(6,6);
        tree.insert(7,7);

        tree.delete(5);
        tree.delete(6);
        tree.delete(7);
        tree.delete(8);

        assertTrue(tree.isEmpty());
    }

    @Test
    public void testSplit(){
        SplayTree<Integer, Integer> tree = new SplayTree<>();
        tree.insert(5,5);
        tree.insert(4,4);
        tree.insert(7,7);
        tree.insert(9,9);

        TreeNode[]nodes= tree.split(6);
        assertNotNull(nodes[0]);
        assertEquals("(5,5) (6,6)", nodes[0]);
        assertEquals("(7,7) (9,9)", nodes[0]);
        assertEquals("nodes 0 should not be null",4, nodes[0].key);
        assertEquals("nodes 0 should not be null",9, nodes[1].key);
    }

    @Test
    public void testFind(){
        SplayTree<Integer, Integer> tree = new SplayTree<>();
        tree.insert(5,5);
        tree.insert(6,6);
        tree.insert(7,7);

        assertEquals((Integer)6, tree.find(6));
        assertEquals((Integer)6, tree.getRoot());

        assertEquals((Integer)7, tree.find(7));
        assertEquals((Integer)7, tree.getRoot());

        assertNull(tree.find(8));
    }
    @Test
    public void testString(){
        SplayTree<Integer, Integer> tree = new SplayTree<>();
        tree.insert(5,5);
        tree.insert(6,6);
        tree.insert(7,7);

        assertEquals("testing printing", "(5, 5) (6, 6) (7, 7)", tree.toString());

        tree.delete(6);
        assertEquals("testing printing", "(5, 5) (7, 7)", tree.toString());

        tree.delete(8);
        assertEquals("testing printing", "(5, 5) (7, 7)", tree.toString());
    }
}
