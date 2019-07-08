# [557. Reverse Words in a String III (Easy)](https://leetcode.com/problems/reverse-words-in-a-string-iii/)

## Description

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

**Example:**

```
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```


## 解法 1

双游标,分别标记单词起始和结尾; 
时间复杂度: O(n)
空间复杂度: O(n)

```java
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int start = 0, end = 0;

        char[] cList = s.toCharArray();

        while (start < s.length()) {
            while (end < s.length() && cList[end] != ' ') {
                end ++;
            }

            for (int i = start, j = end - 1; i < j; i++, j--) {
                char tmp = cList[i];
                cList[i] = cList[j];
                cList[j] = tmp;
            }

            start = end + 1;
            end = start;
        }
        return new String(cList);
    }
}
```
