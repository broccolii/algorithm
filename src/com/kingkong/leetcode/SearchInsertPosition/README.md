# [35. Search Insert Position (Easy)](https://leetcode.com/problems/search-insert-position/)

## Description

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

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
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
```
