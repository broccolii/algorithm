# [50. Pow(x, n) (Medium)](https://leetcode.com/problems/powx-n/)

## Description

Implement pow(x, n), which calculates x raised to the power n (xn).

**Example:**

```
Input: 2.00000, 10
Output: 1024.00000
```


## 解法 1

将指数转化成二进制, 每次都进行减半;
时间复杂度: O(log(n))
空间复杂度: O(1)

```java
class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        long N = Math.abs((long)n);

        while (N != 0) {
            if ((N & 1) == 1) result *= x;
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1/result : result;
    }
}
```