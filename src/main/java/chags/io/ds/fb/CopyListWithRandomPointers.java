package chags.io.ds.fb;

import java.util.HashMap;

public class CopyListWithRandomPointers {


    public Node copyRandomList(Node head) {
        HashMap<Node, Node> nodeMap = new HashMap<>();

        Node newHead = null;

        while (head != null) {
            Node finalHead = head;
            Node newNode = nodeMap.compute(head, (k, v) -> v == null ? new Node(finalHead.val) : v);
            if (newHead == null) {
                newHead = newNode;
            }
            if (head.random != null) {
                Node newRandom = nodeMap.compute(head.random, (k, v) -> v == null ? new Node(finalHead.random.val) : v);
                newNode.random = newRandom;
            }
            if (head.next != null) {
                Node newNext = nodeMap.compute(head.next, (k, v) -> v == null ? new Node(finalHead.next.val) : v);
                newNode.next = newNext;
            }
            head = head.next;
        }
        return newHead;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


