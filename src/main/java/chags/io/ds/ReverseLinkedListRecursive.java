package chags.io.ds;

import java.util.concurrent.atomic.AtomicReference;

public class ReverseLinkedListRecursive {

    public static void main(String[] args) {
        ReverseLinkedListRecursive reverseLinkedListRecursive = new ReverseLinkedListRecursive();
        reverseLinkedListRecursive.reverseList(new ListNode(1));

    }

    private ListNode reverseList(ListNode head) {

        if(head == null) {
            return null;
        }
        AtomicReference<ListNode> headReference = new AtomicReference<>();
        reverseList(head, headReference);
        return headReference.get();

    }

    private ListNode reverseList(ListNode head, AtomicReference<ListNode> headReferece) {

        if(head.next == null) {
            headReferece.set(head);
            return head;
        }

        ListNode next = reverseList(head.next, headReferece);
        next.next = head;
        head.next = null;
        return head;

    }

}
