# [136. Single Number (Easy)](https://leetcode.com/problems/single-number/)

## Description

Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



**Example:**

```
Input: [2,2,1]
Output: 1
```


## 解法 1

通过 HashSet 获取所有数字, 将其结果乘以2,再减去原始数组的和便是我们求的数;
```java
class Solution {
    public int singleNumber01(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, uniqueSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                uniqueSum += num;
            }
            sum += num;
        }

        return 2*uniqueSum - sum;
    }
}
```

## 解法 2

该解法利用了相同数字异或(^)结果为0

```java
    public int singleNumber02(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }  }
}
```
