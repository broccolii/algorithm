package com.kingkong.leetcode.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ret;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int cursorL = i + 1;
            int cursorR = nums.length - 1;

            while (cursorL < cursorR) {
                int sum = nums[i] + nums[cursorL] + nums[cursorR];

                if (sum < 0) {
                    cursorL++;
                } else if (sum > 0) {
                    cursorR--;
                } else {
                    ArrayList list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[cursorL]);
                    list.add(nums[cursorR]);

                    ret.add(list);

                    cursorL++;
                    cursorR--;

                    while (cursorL < cursorR && nums[cursorL] == nums[cursorL - 1])
                        cursorL++;
                    while (cursorL < cursorR && nums[cursorR] == nums[cursorR + 1])
                        cursorR--;
                }
            }
        }
        return ret;
    }
}
