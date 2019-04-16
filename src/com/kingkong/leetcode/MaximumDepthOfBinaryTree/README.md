# [104. Maximum Depth of Binary Tree (Easy)](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

## Description


Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

**Example:**

```
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
```

## 解法 1

递归方法, 分别求左右子树的最大高度;
时间复杂度: 需要遍历所有结点 O(n)
空间复杂度: 当所有结点都在左或者右,就是树的结点数 O(n)

```java
class Solution {
    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
    }
}
```

## 解法 2

迭代方法, 使用辅助栈层序遍历整棵树;
时间复杂度: 需要遍历所有结点 O(n)
空间复杂度: 当所有结点都在左或者右,就是树的结点数 O(n)

```java
class Solution {
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
```