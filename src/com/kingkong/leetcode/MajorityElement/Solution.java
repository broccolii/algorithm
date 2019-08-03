package com.kingkong.leetcode.MajorityElement;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElementWithHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = 0, maxCount = 0;
        for (int num: nums) {
            int newCnt = map.getOrDefault(num, 0) + 1;
            map.put(num, newCnt);
            if (newCnt > maxCount) {
                maxCount = newCnt;
                maxNum = num;
            }
        }
        return maxNum;
    }

    public int getMajority(int[] nums) {
        int num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                num = nums[i];
                count = 1;
            } else if (nums[i] == num) {
                ++count;
            } else --count;
        }
        return num;
    }
}
