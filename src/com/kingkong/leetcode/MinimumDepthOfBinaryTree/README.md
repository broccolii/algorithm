# [876. Middle of the Linked List (Easy)](https://leetcode.com/problems/middle-of-the-linked-list/)

## Description


Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.

**Example:**

```
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
```


## 解法 1

递归解法: 分别求左右两颗子树的最小深度

时间复杂度: 需要遍历整棵树 O(n)
空间复杂度: 考虑最坏情况, 所有节点都在一侧 O(n)
```java
class Solution {
    public int minDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return (minDepth(root.right) + 1);
        if (root.right == null) return (minDepth(root.left) + 1);

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}


```

## 解法 2

迭代解法: 使用辅助栈层序遍历整棵树;

时间复杂度: 需要遍历整棵树 O(n)
空间复杂度: 考虑最坏情况, 所有节点都在一侧 O(n)
```java
class Solution {
    public int minDepthIterative(TreeNode root) {
        if (root == null) return 0;i

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode s = q.poll();
                if (s.left == null && s.right == null) return depth;
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            ++depth;
        }

        return -1;
    }
}
```
