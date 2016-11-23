package dynamicProgramming.reverseKGroup;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseKGroupTest {
    ReverseKGroup rev;

    @Before
    public void setUp(){
        rev = new ReverseKGroup();
    }

    @Test
    public void testList(){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third= new ListNode(3);
        ListNode fourth= new ListNode(4);
        ListNode fifth= new ListNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        assertEquals("[1,2,3,4,5] with 2 -> [2,1,4,3,5]", "[2,1,4,3,5]", rev.toString(rev.reverseKGroup(head, 2)));

    }

    @Test
    public void testList2(){
        ListNode[] nodes = new ListNode[5];
        for(int i = 0 ; i < nodes.length;i++){
            nodes[i] = new ListNode(i+1);
            if(i > 0){
                nodes[i-1].next = nodes[i];
            }
        }

        assertEquals("[1,2,3,4,5] with 2 -> [2,1,4,3,5]", "[2,1,4,3,5]", rev.toString(rev.reverseKGroup(nodes[0], 2)));

    }

    @Test
    public void testList5(){
        ListNode[] nodes = new ListNode[1];
        for(int i = 0 ; i < nodes.length;i++){
            nodes[i] = new ListNode(i+1);
            if(i > 0){
                nodes[i-1].next = nodes[i];
            }
        }

        assertEquals("[1] with 2 -> [1]", "[1]", rev.toString(rev.reverseKGroup(nodes[0], 2)));

    }

    @Test
    public void testList4(){
        ListNode[] nodes = new ListNode[5];
        for(int i = 0 ; i < nodes.length;i++){
            nodes[i] = new ListNode(i+1);
            if(i > 0){
                nodes[i-1].next = nodes[i];
            }
        }

        assertEquals("[1,2,3,4,5] with 3 -> [3,2,1,4,5]", "[3,2,1,4,5]", rev.toString(rev.reverseKGroup(nodes[0], 3)));

    }

    @Test
    public void testList3(){
        ListNode[] nodes = new ListNode[7];
        for(int i = 0 ; i < nodes.length;i++){
            nodes[i] = new ListNode(i+1);
            if(i > 0){
                nodes[i-1].next = nodes[i];
            }
        }


        assertEquals("[1,2,3,4,5,6,7] with 3 -> [3,2,1,6,5,4,7]", "[3,2,1,6,5,4,7]", rev.toString(rev.reverseKGroup(nodes[0],3)));

    }

    @Test
    public void testReverseList(){
        ListNode[] nodes = new ListNode[7];
        for(int i = 0 ; i < nodes.length;i++){
            nodes[i] = new ListNode(i+1);
            if(i > 0){
                nodes[i-1].next = nodes[i];
            }
        }

        assertEquals("reverse test", "[7,6,5,4,3,2,1]", rev.toString(rev.reverseList(nodes[0])));

    }
}
