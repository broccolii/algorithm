# [415. Add Strings (Easy)](https://leetcode.com/problems/add-strings/)

## Description


Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

**Example:**

```
1. The length of both num1 and num2 is < 5100.
2. Both num1 and num2 contains only digits 0-9.
3. Both num1 and num2 does not contain any leading zero.
4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
```


## 解法 1

通过遍历字符串每个字符, 使用变量 `carry` 存储进位, 将结果拼接到结果字符串, 最后反转字符串;
时间复杂度: 需要遍历整个字符串 O(n)
空间复杂度: 需要额外的字符串存储结果 O(n)

```java
public class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() ;
        int len2 = num2.length();

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (len1 > 0 || len2 > 0 || carry > 0) {
            int x = (len1 > 0) ? num1.charAt(len1 - 1) - '0' : 0;
            int y = (len2 > 0) ? num2.charAt(len2 - 1) - '0' : 0;

            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;

            len1--;
            len2--;

            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}
```
