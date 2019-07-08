package com.kingkong.leetcode.ValidateBinarySearchTree;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBSTBound(TreeNode root) {
        return isValidBSTBound(root, null, null);
    }

    public boolean isValidBSTBound(TreeNode root, TreeNode lower, TreeNode upper) {
        if (root == null) return true;
        if (lower != null && lower.val >= root.val) return false;
        if (upper != null && upper.val <= root.val) return false;
        return isValidBSTBound(root.left, lower, root) && isValidBSTBound(root.right, root, upper);
    }
}
