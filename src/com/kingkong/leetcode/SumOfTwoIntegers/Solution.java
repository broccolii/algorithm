package com.kingkong.leetcode.SumOfTwoIntegers;

public class Solution {
    public int getSum01(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b)<<1);
    }

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
