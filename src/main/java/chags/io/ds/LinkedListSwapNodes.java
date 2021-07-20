package chags.io.ds;

public class LinkedListSwapNodes {
    public ListNode swapPairs(ListNode head) {
        if(head != null && head.next != null) {
            int temp = head.val;
            head.val = head.next.val;
            head.next.val = temp;
            swapPairs(head.next.next);
        }
        return head;
    }
}
