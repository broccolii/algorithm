# [637. Average of Levels in Binary Tree (Easy)](https://leetcode.com/problems/average-of-levels-in-binary-tree/)

## Description


Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

**Example:**

```
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
```

## 解法 1

通过一个辅助栈, 将每一层的结点存入;

时间复杂度: 需要遍历整个二叉树 O(n)
空间复杂度: 需要一个辅助数组存储, 数组长度为树高 h, O(h)

```java
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
    
        if (root == null) return result;
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
    
        while (!queue.isEmpty()) {
            double size = queue.size();
            double sum = 0;
    
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
   
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
   
            result.add(sum/size);
        }
    
        return result;
    }
}
```
