# [102. Binary Tree Level Order Traversal (Medium)](https://leetcode.com/problems/binary-tree-level-order-traversal/)

## Description


Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

**Example:**

```
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
```

## 解法 1

使用辅助栈将每一层的结点压入, 遍历辅助栈进行遍历直至子结点为空

时间复杂度: 需要遍历整棵二叉树 O(n)
空间复杂度: 需要使用辅助栈 O(n)

```java
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null)
            return ret;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ret.add(list);
        }
        return ret;
    }
}
```
