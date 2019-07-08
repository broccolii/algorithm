# [101. Symmetric Tree (Easy)](https://leetcode.com/problems/symmetric-tree/)

## Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

**Example:**

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```


## 解法 1

递归解法: 递归比较是否对称
时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l != null && r != null)
            return l.val == r.val &&
                isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
        else return l == null && r == null;
    }

    public boolean isSymmetric01(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
}
```

## 解法 2

递归解法: 利用辅助栈依次压入需要比较的两树, 比较顺序是 (左.左 == 右.右 && 左.右 == 右.左);
时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public boolean isSymmetric02(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }

        return true;
    }
}
```
