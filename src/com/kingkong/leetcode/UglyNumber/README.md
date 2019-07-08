# [263. Ugly Number (Easy)](https://leetcode.com/problems/search-insert-position/)

## Description

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

**Example:**

```
Input: 6
Output: true
Explanation: 6 = 2 × 3
```


## 解法 1

分别连续除以 2, 3, 5, 最后判断余数是否为 1; 
时间复杂度: O(1)
空间复杂度: O(1)

```java
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) {
            num /= 2;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return 1 == num;
    }
}
```
