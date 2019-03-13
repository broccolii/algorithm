package com.kingkong.leetcode.InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree01(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode invertTree02(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }

        return root;
    }
}
