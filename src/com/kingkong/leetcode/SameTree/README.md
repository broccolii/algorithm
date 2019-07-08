# [100. Same Tree (Easy)](https://leetcode.com/problems/same-tree/)

## Description

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

**Example:**

```
Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
```


## 解法 1

递归解法: 分别判断两棵树的左子树相同, 右子树也相同; 
时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public boolean isSameTree01(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isSameTree01(p.left, q.left) && isSameTree01(p.right, q.right);
    }
}
```

## 解法 2

迭代解法: 使用辅助栈push进两棵树的左叶子再push进右叶子, 不断迭代判断是否相等;

时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
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
```
