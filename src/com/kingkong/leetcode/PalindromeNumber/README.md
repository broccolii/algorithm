# [9. Palindrome Number (Easy)](https://leetcode.com/problems/palindrome-number/)

## Description

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

**Example:**

```
Input: 121
Output: true
```


## 解法 1

转成字符串,通过判断回文字符串的方式进行判断;
时间复杂度: O(n)
空间复杂度: O(1)

```java
class Solution {
    public boolean isPalindrome01(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
```

## 解法 2
由于是回文数字, 通过末项前移组成新数字进行相等判断;
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
