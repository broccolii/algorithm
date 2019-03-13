package com.kingkong.leetcode.SingleNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber01(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, uniqueSum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                uniqueSum += num;
            }
            sum += num;
        }

        return 2*uniqueSum - sum;
    }

    public int singleNumber02(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }
}
