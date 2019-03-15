# [371. Sum of Two Integers (Easy)](https://leetcode.com/problems/two-sum/)

## Description

Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.


**Example:**

```
Input: a = 1, b = 2
Output: 3
```


## 解法 1

解题思路: 首先不能使用加减,意味着我们需要用位运算进行解题; 
在加法运算过程中主要分为两部分: 1. 各位相加 2. 进位保存;
使用 ^ 进行各位相加
使用 & 得到进位, 在通过 << 1 移位, 确保进位数在正确位置想加;
循环累计直至进位为 0; 
```java
class Solution {
    public int getSum01(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b)<<1);
    }
}
```

## 解法 2

```java
class Solution {
    public int getSum02(int a, int b) {
        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;

            a = sum;
            b = carry;
        }
        return a;
    }
}
```
