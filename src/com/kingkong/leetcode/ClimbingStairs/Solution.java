package com.kingkong.leetcode.ClimbingStairs;

public class Solution {
    public int climbstairsRecursive(int n) {
        if (n < 2) return 1;
        return climbstairsRecursive(n-1) + climbstairsRecursive(n-2);
    }

    public  int climbstairsIterative(int n) {
        int first = 1, second = 1;

        for (int i = 1; i < n; ++i) {
            int third = first + second;
            first = second;
            second = third;
        }

        return second;
    }
}
