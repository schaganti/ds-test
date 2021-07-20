package chags.io.ds;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        List<TreeNode> children = new ArrayList<>();

        if(root != null) {
            result.add(Arrays.asList(root.val));
            if(root.left != null) children.add(root.left);
            if(root.right != null) children.add(root.right);
        }

        while(!children.isEmpty()) {
            result.add(children.stream().map(c -> c.val).collect(Collectors.toList()));
            List<TreeNode> tempChildList = new ArrayList<>();
            children.forEach(treeNode -> {
                if(treeNode.left != null) tempChildList.add(treeNode.left);
                if(treeNode.right != null) tempChildList.add(treeNode.right);
            });
            children = tempChildList;

        }

        return result;

    }

}


