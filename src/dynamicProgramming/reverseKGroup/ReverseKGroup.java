package dynamicProgramming.reverseKGroup;


//https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode newHead = null;
        ListNode prev= null;

        while(temp !=null && hasKElements(temp,k)){
            ListNode newFirst = forwardKElements(temp,k);
            reverseGroup(temp,k);

            if(prev != null){
                prev.next = newFirst;
            }

            if(newHead == null)
                newHead = newFirst;
            prev = temp;
            temp = temp.next;

        }
        return newHead != null?newHead:head;
    }


    public String toString(ListNode head){
        StringBuffer str = new StringBuffer();

        while(head != null){
            str.append(head.val+",");
            head = head.next;
        }

        return  str.length() >0?"[" +str.substring(0,str.length()-1).toString()+"]":"" ;

    }
    public ListNode reverseGroup(ListNode head, int k){
        if(k > 1){

            ListNode newFirst = reverseGroup(head.next, k-1);

            ListNode after = newFirst.next;
            head.next = after;
            newFirst.next = head;
        }

        return head;
    }

    private boolean hasKElements(ListNode head, int k){
        ListNode current = head;
        while(k > 0 && current != null){
            k--;
            current = current.next;
        }
        return k ==0;
    }

    private ListNode forwardKElements(ListNode head, int k){
        ListNode current = head;
        while(k > 1){
            current = current.next;
            k--;
        }

        return k ==1?current:head;
    }



    public ListNode reverseList(ListNode head){
        ListNode firstElement = null;
        if(head != null){
            ListNode lastElement = head.next;
            firstElement= reverseList(head.next);
            if(firstElement != null) {
                lastElement.next = head;
                head.next = null;
            } else {
                firstElement = head;
            }
        }

        return firstElement;
    }

}