# [235. Lowest Common Ancestor of a Binary Search Tree (Easy)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

## Description


Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

**Example:**

```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
```


## 解法 1

根据二叉搜索树的特点: 左子树小于父结点, 右结点大于父结点; 可以分析以下三种情况:
1. 两个结点都小于根结点, 将根结点的左子树作为根结点传入继续寻找
2. 两个结点都大于根结点, 将根结点的右子树作为根结点传入继续寻找
3. 根结点大于其中一个结点小于另一个结点, 则根结点为需要寻找的最近公共结点
```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.val > root.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
```

## 解法 2
使用迭代的方式来处理
```Java
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (p.val < root.val && q.val < root.val) root = root.left;
      else if (p.val > root.val && q.val > root.val) root = root.right;
      else return root;
    }
    return null;
  }
}
```
