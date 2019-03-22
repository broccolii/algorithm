package com.kingkong.leetcode.AddStrings;

public class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() ;
        int len2 = num2.length();

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (len1 > 0 || len2 > 0 || carry > 0) {
            int x = (len1 > 0) ? num1.charAt(len1 - 1) - '0' : 0;
            int y = (len2 > 0) ? num2.charAt(len2 - 1) - '0' : 0;

            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;

            len1--;
            len2--;

            sb.append(sum);
        }

        return sb.reverse().toString();
    }
}
