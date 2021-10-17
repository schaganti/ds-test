package chags.io.ds.fb;

import java.util.Stack;

public class ReorderList {

    public void reorderList(ListNode head) {

        Stack<ListNode> nodeStack = new Stack<>();
        ListNode tempNode = head;
        while (tempNode != null) {
            nodeStack.push(tempNode);
            tempNode = tempNode.next;
        }
        tempNode = head;
        ListNode rearEndNode = nodeStack.pop();

        while(tempNode != rearEndNode && rearEndNode.next != tempNode) {
            int tempVal = tempNode.val;
            tempNode.val=rearEndNode.val;
            rearEndNode.val=tempVal;
            tempNode = tempNode.next;
            rearEndNode = nodeStack.pop();
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
