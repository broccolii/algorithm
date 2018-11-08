package com.kingkong.leetcode.twoSum;

import static org.junit.Assert.*;

public class SolutionTest extends Solution {
    @org.junit.Test
    public void twoSum() throws Exception {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] result = solution.twoSum01(nums, 8);
        assertArrayEquals(result, new int[] {2, 4});

        result = solution.twoSum02(nums, 8);
        assertArrayEquals(result, new int[] {2, 4});
    }
}