package com.kingkong.leetcode.LowestCommonAncestorOfABinarySearchTree;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (q.val > root.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
