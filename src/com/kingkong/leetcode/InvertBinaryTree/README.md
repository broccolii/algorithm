# [226. Invert Binary Tree (Easy)](https://leetcode.com/problems/invert-binary-tree/)

## Description


Invert a binary tree.

**Example:**

```
intput
     4
   /   \
  2     7
 / \   / \
1   3 6   9

output
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```


## 解法 1

使用递归方式求解

时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public TreeNode invertTree01(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
```

## 解法 2

使用迭代方式求解

时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public TreeNode invertTree02(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;

            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }

        return root;
    }
}
```