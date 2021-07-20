package chags.io.ds;

import java.util.List;

public class MergeSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {

        MergeSortedLinkedList mergeSortedLinkedList = new MergeSortedLinkedList();


    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergedList = null;
        ListNode prev = null;

        while (l1 != null && l2 != null) {

            ListNode newNode = null;

            if (l1.val < l2.val) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l2.val < l1.val) {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                newNode = new ListNode(l2.val);
                newNode.next = new ListNode(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }

            if (prev == null) {
                mergedList = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode.next != null ? newNode.next : newNode;
        }
        if(prev == null) {
            mergedList = l1 != null ? l1 : l2;
        } else {
            prev.next = l1 != null ? l1 : l2;
        }
       return mergedList;
    }
}
