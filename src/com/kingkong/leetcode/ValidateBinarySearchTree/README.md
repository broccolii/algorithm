# [98. Validate Binary Search Tree (Medium)](https://leetcode.com/problems/valid-anagram/)

## Description

Given a binary tree, determine if it is a valid binary search tree (BST).
 
 Assume a BST is defined as follows:
 
 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 
**Example:**

```
Input:
    2
   / \
  1   3
Output: true
```


## 解法 1

递归方法验证, 左子树也符合二叉搜索树, 右子树也符合二叉搜索树; 如果不符合左 < 中 < 右,则跳出循环; 
时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
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
```
