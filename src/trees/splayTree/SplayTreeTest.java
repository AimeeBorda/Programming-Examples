package trees.splayTree;


import org.junit.Test;

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
    public void testString(){
        SplayTree<Integer, Integer> tree = new SplayTree<>();
        tree.insert(5,5);
        tree.insert(6,6);
        tree.insert(7,7);

        assertEquals("testing printing", "(5, 5) (6, 6) (7, 7)", tree.toString());

        tree.delete(6);
        assertEquals("testing printing", "(5, 5) (7, 7)", tree.toString());
    }




}
