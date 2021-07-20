package chags.io.ds;


import java.util.ArrayList;
import java.util.List;

public class IsSubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if(t == null || s == null) return false;
        String tStr = traverse(t);
        String sStr = traverse(s);
        return sStr.indexOf(tStr) >= 0;
    }

    public String traverse(TreeNode t) {
        String val = "";
        if(t == null) {
            return "null";
        }
        val = val + traverse(t.left);
        val = "#"+t.val;
        val = val + traverse(t.right);
        return val;
    }
}

