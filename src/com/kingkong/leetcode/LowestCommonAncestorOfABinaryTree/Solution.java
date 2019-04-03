package com.kingkong.leetcode.LowestCommonAncestorOfABinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean search(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root == node) {
            return true;
        }
        if (search(root.left, node, path) || search(root.right, node, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = new ArrayList<>();
        List<TreeNode> qpath = new ArrayList<>();

        search(root, p, ppath);
        search(root, q, qpath);

        int i = 0, len = Math.min(ppath.size(), qpath.size());
        while (i < len && ppath.get(i) == qpath.get(i)) {
            ++i;
        }
        return ppath.get(i-1);
    }

    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
