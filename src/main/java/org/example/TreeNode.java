package org.example;

import java.util.LinkedList;
import java.util.Objects;

public class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    //TODO: 目前不支持 Null TreeNode
    public static TreeNode initTreeNode(Integer[] array) {
        if (array.length == 0) return new TreeNode();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(array[0]);
        queue.offer(root);
        int n = array.length - 1;
        for (int i = 1; i < n; i = i + 2) {
            TreeNode nodeLeft = new TreeNode(array[i]);
            if (n - i >= 2) {
                TreeNode nodeRight = new TreeNode(array[i + 1]);
                if (!queue.isEmpty()) {
                    TreeNode rootChild = queue.poll();
                    rootChild.left = nodeLeft;
                    queue.offer(nodeLeft);
                    rootChild.right = nodeRight;
                    queue.offer(nodeRight);
                }
            } else {
                if (!queue.isEmpty()) {
                    TreeNode rootChild = queue.poll();
                    rootChild.left = nodeLeft;
                    queue.offer(nodeLeft);
                }
            }
        }
        return root;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeNode)) return false;
        TreeNode compareToTree = (TreeNode) obj;
        return dfsCompare(compareToTree);
    }

    private boolean dfsCompare(TreeNode root) {
        if (root == null && this.val == null) return true;
        if (root == null) return false;
        if (Objects.equals(root.val, this.val)) {
            if (root.left != null) {
                dfsCompare(root.left);
            }
            if (root.right != null) {
                dfsCompare(root.right);
            }
            return true;
        } else {
            return false;
        }
    }
}
