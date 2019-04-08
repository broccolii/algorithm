# [704. Binary Search (Easy)](https://leetcode.com/problems/binary-search/)

## Description


Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.

**Example:**

```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

## 解法 1

二分查找不断收敛区间进行折中查找

时间复杂度: 不断以二分之一收敛区间 O(logn)
空间复杂度: 需要 low 和 high 两个变量 O(1)

```java
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high)/2;
            if (nums[mid] > target) {
                low = mid + 1;
            } else if (nums[mid] < target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
```
