package com.kingkong.leetcode.SameTree;

import java.util.Stack;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree01(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree02(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            TreeNode l = stack.pop();
            TreeNode r = stack.pop();

            if (l == null && r == null) {
                continue;
            }

            if (l == null || r == null) {
                return false;
            }

            if (l.val != r.val) {
                return false;
            }

            stack.push(l.left);
            stack.push(r.left);

            stack.push(l.right);
            stack.push(r.right);
        }

        return true;
    }
}
