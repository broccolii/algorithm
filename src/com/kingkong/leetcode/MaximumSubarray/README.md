# [88.53. Maximum Subarray (Easy)](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
## Description

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

## 解法 1

使用动态规划的方式进行处理, 从第一个数开始累计 currentMax, 如果出现负数则需要排出前面所有数字, 从当前数开始重新累计;

时间复杂度: 只需要遍历一次数组 O(n)
空间复杂度: 无需额外的空间 O(1)

```java
class Solution {
    public int maxSumOfSubArry(int[] nums) {
        int max = Integer.MIN_VALUE, current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (current <= 0) {
                current = nums[i];
            } else {
                current = current + nums[i];
            }

            max = Math.max(max, current);
        }
        return max;
    }
}
```