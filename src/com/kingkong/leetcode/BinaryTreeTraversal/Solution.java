package com.kingkong.leetcode.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal01(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        list.add(root.val);
        list.addAll(preorderTraversal01(root.left));
        list.addAll(preorderTraversal01(root.right));
        return list;
    }

    public List<Integer> preorderTraversal02(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return list;
    }

    public List<Integer> preorderTraversal03(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversal02(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }

            root = stack.pop();
            root = root.left;

        }
        return list;
    }

    public List<Integer> inorderTraversal01(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(inorderTraversal01(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal01(root.right));
        return list;
    }

}
