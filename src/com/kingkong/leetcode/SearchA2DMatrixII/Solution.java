package com.kingkong.leetcode.SearchA2DMatrixII;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        // 行坐标
        int m = matrix.length;
        // 列坐标
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
