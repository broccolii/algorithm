package com.kingkong.leetcode.MaximumSubarray;

public class Solution {
    public int maxSumOfSubArry(int[] nums) {
        int max = Integer.MIN_VALUE, current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (current <= 0) {
                current = nums[i];
            } else {
                current = current + nums[i];
            }

            max = Math.max(max, current);
        }
        return max;
    }
}
