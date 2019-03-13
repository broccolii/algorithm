package com.kingkong.leetcode.PalindromeNumber;

public class Solution {
    public boolean isPalindrome01(int x) {
        if (x < 0) return false;

        String s = String.valueOf(x);

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome02(int x) {
        if (x < 0) return false;

        int tmp = x;
        int y = 0;

        while (tmp > 0) {
            y = y * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return y == x;
    }
}
