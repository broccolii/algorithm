# [169. Majority Element (Easy)](https://leetcode.com/problems/majority-element/)

## Description

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

**Example:**

```
Input: [3,2,3]
Output: 3
```

## 解法 1

试用辅助 HashMap 的方式进行处理存储出现数字的数量

时间复杂度: 需要遍历所有元素 O(n)
空间复杂度: 需要使用辅助 HashMap O(n)

```java
class Solution {
    public int majorityElementWithHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = 0, maxCount = 0;
        for (int num: nums) {
            int newCnt = map.getOrDefault(num, 0) + 1;
            map.put(num, newCnt);
            if (newCnt > maxCount) {
                maxCount = newCnt;
                maxNum = num;
            }
        }
        return maxNum;
    }
}
```

## 解法 2

使用 摩尔投票算法 

时间复杂度: 需要遍历所有元素 O(n)
空间复杂度: 无需额外的空间 O(1)

```java
class Solution {
   public int getMajority(int[] nums) {
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            } else if (nums[i] == num) {
                ++count;
            } else --count;
        }
        return num;
    }
}
```