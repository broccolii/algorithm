# [240. Search a 2D Matrix II (Medium)](https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/)

## Description

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

**Example:**

```
Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```


## 解法 1

可以使用从上往下一行行, 从右往左一列列进行遍历 
时间复杂度: O(m+n)
空间复杂度: O(1)

```java
class Solution {
   public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        // 行长度
        int m = matrix.length;
        // 列长度
        int n = matrix[0].length;

        // 游标
        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            if (target < matrix[i][j]) --j;
            else if (target > matrix[i][j]) ++i;
            else return true;
        }
        return false;
    }
}
```