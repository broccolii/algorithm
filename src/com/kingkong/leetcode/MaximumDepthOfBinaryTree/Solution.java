package com.kingkong.leetcode.MaximumDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
    }

    public int maxDepthIterative(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode s = q.poll();
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            ++depth;
        }
        return depth;
    }
}
