package chags.io.ds;

import java.util.concurrent.atomic.AtomicInteger;

public class KthSmallestNodeInBinaryTree {

    public int kthSmallest(TreeNode root, int k) {

        AtomicInteger result = new AtomicInteger();
        traverse(root, new AtomicInteger(k), result);
        return result.get();
    }

    public void traverse(TreeNode root, AtomicInteger counter, AtomicInteger result) {

        if (root == null) {
            return;
        }

        traverse(root.left, counter, result);
        int counterVal = counter.decrementAndGet();
        if (counterVal == 0) {
            result.set(root.val);
        }
        traverse(root.right, counter, result);
    }

}
