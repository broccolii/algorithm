package com.kingkong.leetcode.Sqrt;

public class Solution {
    public int mySqrt01(int x) {
        long result = x;

        while (result * result > x) {
            result = (x / result + result) / 2;
        }
        return (int)result;
    }

    public int mySqrt02(int x) {
        int low = 0;
        int height = x;

        while (low <= height) {
            int mid = (low + height) / 2;
            if (mid * mid > x) {
                height = mid - 1;
            } else if (mid * mid < x) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return height;
    }
}
