package com.kingkong.leetcode.MinimumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return (minDepth(root.right) + 1);
        if (root.right == null) return (minDepth(root.left) + 1);

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null) return 0;i

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode s = q.poll();
                if (s.left == null && s.right == null) return depth;
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            ++depth;
        }

        return -1;
    }
}
