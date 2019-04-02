# [236. Lowest Common Ancestor of a Binary Tree (Medium)](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## Description


Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

**Example:**

```
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
```


## 解法 1

通过遍历二叉树查找子结点并记录其路径, 对比两条路径的最后一个相同结点, 即为公共父节点 
由于需要遍历整个二叉树进行查找子结点, 所以时间复杂度为 T:O(n)
需要辅助栈存储路径, 所以空间复杂度为 S:O(n)
```java
class Solution {
    private boolean search(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root == node) {
            return true;
        }
        if (search(root.left, node, path) || search(root.right, node), path) {
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
}
```

## 解法 2
通过递归的方式分别在左右子树查找公共父节点;
如果返回为空,说明公共父节点在另一侧;如果返回都不会空说明p,q两结点分布在 root 结点两侧,则返回root为公共父节点
需要遍历整个二叉树所以时间复杂度 T: O(n)
递归调用栈也是额外的辅助空间所以空间复杂度 S: O(n)
```Java
class Solution { 
    public TreeNode lowestCommonAncestor02(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor02(root.left, p, q);
        TreeNode right = lowestCommonAncestor02(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }
}
```
