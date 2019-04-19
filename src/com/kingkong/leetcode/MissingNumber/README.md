# [268. Missing Number (Easy)](https://leetcode.com/problems/middle-of-the-linked-list/)

## Description


Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

**Example:**

```
Input: [3,0,1]
Output: 2
```


## 解法 1

遍历整个数组, 将结果累加减去每个数组中的数, 最后的结果就是缺少的数

时间复杂度: 需要遍历整个数组 O(n)
空间复杂度: 需要变量sum来存储最终结果 O(1)
```java
class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + i - nums[i];
        }

        return sum;
    }
}


```

