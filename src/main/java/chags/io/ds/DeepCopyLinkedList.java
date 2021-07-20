package chags.io.ds;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyLinkedList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {

            Map<Node, Node> nodeMap = new HashMap<>();

            Node newHead = null;
            Node prev = null;

            while(head != null) {
                Node newNode = new Node(head.val);
                if(prev != null) {
                    prev.next = newNode;
                } else {
                    newHead = newNode;
                }
                nodeMap.put(head, newNode);
                prev = newNode;
                head = head.next;
            }

            nodeMap.entrySet().stream().forEach(e -> {
                if(e.getKey().random != null) {
                    e.getValue().random = nodeMap.get(e.getKey().random);
                }
            });
            return newHead;
        }


        public Node copyRandomListRecursive(Node head) {

            HashMap<Node, Node> nodeMap = new HashMap<>();
            Node newHead = copyRandomListRecurrsive(nodeMap, head);
            nodeMap.entrySet().stream().forEach(e -> {
                Node original = e.getKey();
                Node newNode = e.getValue();
                if(original.random != null) {
                    newNode.random = nodeMap.get(original.random);
                }
            });
            return newHead;
        }


        public Node copyRandomListRecurrsive(Map<Node, Node> nodeMap, Node head) {

            if(head == null) {
                return null;
            }
            Node node = new Node(head.val);
            nodeMap.put(head, node);
            node.next = copyRandomListRecurrsive(nodeMap, head.next);
            return node;
        }


    }

}
