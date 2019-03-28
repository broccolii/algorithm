package com.kingkong.leetcode.FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        boolean[] existed = new boolean[nums.length];
        for (int num: nums) existed[num-1] = true;
        for (int i = 0; i < existed.length; ++i)
            if (!existed[i])
                result.add(i+1);
        return result;
    }
}
