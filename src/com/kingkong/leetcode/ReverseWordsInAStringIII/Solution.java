package com.kingkong.leetcode.ReverseWordsInAStringIII;

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int start = 0, end = 0;

        char[] cList = s.toCharArray();

        while (start < s.length()) {
            while (end < s.length() && cList[end] != ' ') {
                end ++;
            }

            for (int i = start, j = end - 1; i < j; i++, j--) {
                char tmp = cList[i];
                cList[i] = cList[j];
                cList[j] = tmp;
            }

            start = end + 1;
            end = start;
        }
        return new String(cList);
    }
}
