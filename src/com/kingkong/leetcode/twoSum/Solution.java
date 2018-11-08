package com.kingkong.leetcode.twoSum;

import java.util.HashMap;

public class Solution {
    public int[] twoSum01(int[] nums, int target) {
        int lens = nums.length;
        for (int i = 0; i < lens; ++i) {
            for (int j = i + 1; j < lens; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum02(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
