# [107. Binary Tree Level Order Traversal II (Easy)](https://leetcode.com/problems/climbing-stairs/)

## Description


You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

**Example:**

```
Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
```

## 解法 1

这个问题可以抽象的看做 爬n阶楼梯的解=爬n-1阶楼梯的解+爬n-2阶楼梯的解 -> f(n) = f(n-1)+f(n-2)
很明显这个是一个斐波那契数列, 我们可以用迭代和递归两种方式来解答

时间复杂度: 由于使用了递归最后的递归栈会重复计算 O(2n方)
空间复杂度: 递归栈需要额外的空间 O(n)

```java
public class Solution {
    public int climbstairsRecursive(int n) {
        if (n < 2) return 1;
        return climbstairsRecursive(n-1) + climbstairsRecursive(n-2);
    }
}
```

## 解法 2

时间复杂度: 只需要遍历n次 O(n)
空间复杂度: 仅使用两个变量 O(1)

```java
public class Solution {
    public  int climbstairsIterative(int n) {
        int first = 1, second = 1;

        for (int i = 1; i < n; ++i) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
```
