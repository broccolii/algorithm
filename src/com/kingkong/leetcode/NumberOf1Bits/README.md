# [191. Number of 1 Bits (Easy)](https://leetcode.com/problems/number-of-1-bits/)

## Description


Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).

**Example:**

```
Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
```

## 解法 1
通过一位掩码进行与运算找出所有1的个数
时间复杂度: O(m)
空间复杂度: O(1)

```java
class Solution { 
    public int numberOfOneWithMask(int n) {
        int mask = 1, count = 0;
        while (mask != 0) {
            if ((n & mask) != 0) ++count;
                mask <<= 1;
            }
            return count;
        }
    }
}
```

## 解法 2

通过自身与自身减一进行与运算消除最低位的1直至运算结果为0
时间复杂度: O(k)
空间复杂度: O(1)

```java
class Solution {
    public int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }
        return count;
    }
}
```
