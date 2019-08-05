package com.kingkong.leetcode.NumberOf1Bits;

public class Solution {
    public int numberOfOneWithMask(int n) {
        int mask = 1, count = 0;
        while (mask != 0) {
            if ((n & mask) != 0) ++count;
            mask <<= 1;
        }
        return count;
    }

    public int numberOfOne(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n &= (n - 1);
        }
        return count;
    }
}
