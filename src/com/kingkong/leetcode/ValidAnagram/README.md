# [242. Valid Anagram (Easy)](https://leetcode.com/problems/valid-anagram/)

## Description

Given two strings s and t , write a function to determine if t is an anagram of s.

**Example:**

```
Input: s = "anagram", t = "nagaram"
Output: true
```


## 解法 1

使用一个长度26的字符数组存储,记录s中字母出现次数, 然后遍历t减去字母对应位置的count; 
时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
   public boolean isAnagram(String s, String t) {
       if (s.length() != t.length()) return false;

        int[] counts = new int[26];

        for (char item : s.toCharArray()) {
            counts[item - 'a']++;
        }
        for (char item : t.toCharArray()) {
            counts[item - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
```
