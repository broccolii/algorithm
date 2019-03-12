package com.kingkong.leetcode.MergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = n + m - 1;

        while (m < 0 || n < 0) {
            if (nums1[m] > nums2[n]) {
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }

            k--;
        }

        while (j >= 0) nums1[k--] = nums2[j--];
    }
}
