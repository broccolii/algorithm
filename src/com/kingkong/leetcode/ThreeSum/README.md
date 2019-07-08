# [15. 3Sum (Medium)](https://leetcode.com/problems/3sum/)

## Description

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

**Example:**

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```


## 解法 1

双游标: 通过左右两个游标村缩小查找范围; 
时间复杂度: O(n^2)
空间复杂度: O(1)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ret;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int cursorL = i + 1;
            int cursorR = nums.length - 1;

            while (cursorL < cursorR) {
                int sum = nums[i] + nums[cursorL] + nums[cursorR];

                if (sum < 0) {
                    cursorL++;
                } else if (sum > 0) {
                    cursorR--;
                } else {
                    ArrayList list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[cursorL]);
                    list.add(nums[cursorR]);

                    ret.add(list);

                    cursorL++;
                    cursorR--;

                    while (cursorL < cursorR && nums[cursorL] == nums[cursorL - 1])
                        cursorL++;
                    while (cursorL < cursorR && nums[cursorR] == nums[cursorR + 1])
                        cursorR--;
                }
            }
        }
        return ret;
    }
}
```
