# [167.Two Sum II - Input array is sorted (Easy)](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

## Description


Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.



**Example:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```


## 解法 1

由于题目中要求数组是有序的, 可以使用两个指针向中间的方式进行加和判断;
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j --;
            } else if (numbers[i] + numbers[j] < target) {
                i ++;
            } else {
                return new int[]{i+1, j+1};
            }
        }

        return new int[]{-1, -1};
    }
}
```
