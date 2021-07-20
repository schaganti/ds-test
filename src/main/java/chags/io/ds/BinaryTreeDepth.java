package chags.io.ds;

public class BinaryTreeDepth {
    public static void main(String[] args) {
        BinaryTreeDepth binaryTreeDepth = new BinaryTreeDepth();
        System.out.println(binaryTreeDepth.maxDepth(null));


    }

    public int maxDepth(TreeNode treeNode) {

        if(treeNode == null) {
            return 0;
        }
        return Integer.max(maxDepth(treeNode.left)+1, maxDepth(treeNode.right)+1);

    }
}
