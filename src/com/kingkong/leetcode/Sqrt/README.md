# [69. Sqrt(x) (Easy)](https://leetcode.com/problems/sqrtx/)

## Description

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example:**

```
Input: 4
Output: 2
```


## 解法 1
使用牛顿迭代法进行求解
时间复杂度: O(log(n))
空间复杂度: O(1)
```java
class Solution {
    public int mySqrt01(int x) {
        long result = x;

        while (result * result > x) {
            result = (x / result + result) / 2;
        }
        return (int)result;
    }
}
```

## 解法 2
使用二分法迭代求解
时间复杂度: O(log(n))
空间复杂度: O(1)
```java
class Solution {
    public int mySqrt02(int x) {
        long low = 0;
        long height = x;

        while (low <= height) {
            long mid = (low + height) / 2;
            if (mid * mid > x) {
                height = mid - 1;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                return (int)mid;
            }
        }
        return (int)height;
    }
}
```
