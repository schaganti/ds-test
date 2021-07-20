package chags.io.ds;

public class SearchBST {
    public static void main(String[] args) {
        SearchBST searchBST = new SearchBST();
    }

     public TreeNode searchBST(TreeNode treeNode, int val) {

        if(treeNode == null) {
            return null;
        }

        TreeNode result = null;

        if(val == treeNode.val) {
            result = treeNode;
        }
        if(val < treeNode.val) {
            result = result == null ? searchBST(treeNode.left, val) : result;
        } else {
            result = result == null ? searchBST(treeNode.right, val) : result;
        }
        return  result;
    }
}
