# [1. Two Sum (Easy)](https://leetcode.com/problems/two-sum/)

## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly*** one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```


## 解法 1

题中需要在数组中选择两个数进行想加, 最先进行两次遍历两两想加求解; 
时间复杂度: O(n^2)
空间复杂度: O(1)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int lens = nums.length;
        for (int i = 0; i < lens; ++i) {
            for (int j = i + 1; j < lens; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
```

## 解法 2

可以考虑通过空间置换时间的方式, 将已遍历过的数字的补偿数 (target - num) 存入 HashMap 中; 如果在后续数字的遍历中含有补充数, 则得到求解  

利用 HashMap 作为存储，键为目标值减去当前元素值，索引为值，比如 `i = 0` 时，此时首先要判断 `nums[0] = 2` 是否在 map 中，如果不存在，那么插入键值对 `key = 9 - 2 = 7, value = 0`，之后当 `i = 1` 时，此时判断 `nums[1] = 7` 已存在于 map 中，那么取出该 `value = 0` 作为第一个返回值，当前 `i` 作为第二个返回值，具体代码如下所示。

时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
```
