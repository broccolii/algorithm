package com.kingkong.leetcode.KthLargestElementInAStream;

import java.util.PriorityQueue;

public class Solution {
    class KthLargest {
        final PriorityQueue<Integer> q;
        final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for (int n : a)
                add(n);
        }

        public int add(int val) {
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }
    }
}
