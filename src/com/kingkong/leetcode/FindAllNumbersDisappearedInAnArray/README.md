# [448. Find All Numbers Disappeared in an Array (Easy)](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)

## Description


Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space

**Example:**

```
Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
```


## 解法 1

使用一个辅助数组存储布尔值进行判断数字是否出现, 如果数字出现则在对应index赋值为true

时间复杂度: 遍历两次数组 O(n)
空间复杂度: 需要额外的一个辅助数组进行存储出现结果 O(n)

```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        boolean[] existed = new boolean[nums.length];
        for (int num: nums) existed[num-1] = true;
        for (int i = 0; i < existed.length; ++i)
            if (!existed[i])
                result.add(i+1);
        return result;
    }
}
```
