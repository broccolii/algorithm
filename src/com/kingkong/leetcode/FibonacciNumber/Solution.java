package com.kingkong.leetcode.FibonacciNumber;

public class Solution {
    public int fib01(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        int p = 0, q = 1;
        int sum = 0;

        for (int i = 2; i < N; i++) {
            sum = p + q;
            p = q;
            q = sum;
        }

        return sum;
    }

    public int fib02(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        return fib02(N - 1) + fib02(N - 2);
    }
}
